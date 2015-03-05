/*
 * The MIT License
 *
 * Copyright 2015 ykitac <y-urano@kitadenshi.co.jp>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.kitac.kinesissamples.consumer;

import com.kitac.kinesissamples.consumer.model.*;
import com.kitac.kinesissamples.consumer.communication.DynamoDBManager;
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream;
import java.io.*;
import java.util.Base64;
import java.util.Iterator;
import java.util.logging.*;
import org.apache.spark.SparkConf;
import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.api.java.*;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.kinesis.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import scala.Tuple2;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public class Consumer implements Serializable
{

    private final String streamNameString;
    private final String endpointString;
    private static final Logger LOG = Logger.getLogger(Consumer.class.getName());

    public Consumer( String streamName, String endpointUString )
    {
        streamNameString = streamName;
        endpointString = endpointUString;
    }

    public void consume()
    {
        SparkConf conf = new SparkConf().setAppName(AppConfig.getApplicationName());
        Duration batchInterval = new Duration(AppConfig.getDuration());

        JavaStreamingContext jsc = new JavaStreamingContext(conf, batchInterval);

        // Sets the checkpoint interval to the same 
        // as the batch interval of the consumer application.
        JavaReceiverInputDStream<byte[]> kinesisStream = KinesisUtils.createStream(
                jsc, streamNameString, endpointString, batchInterval, InitialPositionInStream.LATEST 
        // Uses the default storage level.
                ,StorageLevel.MEMORY_ONLY() );          

        JavaPairDStream<Integer, UnitRecord> dataStream = kinesisStream
                // Transforms kinesis records into KinesisRecord objects.
                .map(x->toKinesisRecord(new String(x)))
                // Transforms KinesisRecord objects into UnitRecord objects.
                .map(x->new UnitRecord(x))
                // Specifies a return value of UnitRecord.getUnitId() as a key,
                // a UnitRecord object itself as a value.
                .mapToPair((x)->
                {
                    return new Tuple2<Integer, UnitRecord>(x.getUnitId(), x);
                })
                .reduceByKey((x, y)->UnitRecord.reduce(x, y));
        
        // print data.
        dataStream.print();
        
        // Push the output data to DynamoDB.
        dataStream.foreachRDD(rdd->
        {
            rdd.foreachPartition(
                partitionOfRecords->
                {
                    DynamoDBManager manager = DynamoDBManager.DYNAMODB_MANAGER;
                    for(Iterator<Tuple2<Integer, UnitRecord>> i=partitionOfRecords; i.hasNext();)
                    {
                        Tuple2<Integer, UnitRecord> record = i.next();
                        manager.putRecord(record._2());
                    }
                });
            
            // A template code for lambda expression, 
            // the type of return value of which is java.lang.Void.
            return null;
        });



        jsc.start();

        jsc.awaitTermination();
    }

    /**
     * Converts a byte array to a string object that is JSON format.
     */
    private String toJsonString( byte[] source )
    {
        String retVal;
        
        byte[] src;
        
        try
        {
            // Decode Base64 encoded string.
            src = Base64.getDecoder().decode(source);
        }
        catch(IllegalArgumentException e)
        {
            LOG.severe(e.getMessage());
            src = null;
        }
        
        if(src != null)
        {
            try
            {
                retVal = new String(src, "UTF-8");
            }
            catch ( UnsupportedEncodingException ex )
            {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                retVal = new String(src);
            }
        }
        else
        {
            retVal = "";
        }

        return retVal;
    }

    /**
     * Converts a JSON string object to a KinesisRecord object.
     *
     * @param json A string object that is JSON format.
     * @return A KinesisRecord object deserialize from JSON.
     * @throws java.io.IOException
     * @throws com.fasterxml.jackson.core.JsonParseException
     * @throws org.codehaus.jackson.JsonParseException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     */
    protected KinesisRecord toKinesisRecord( String json )
            throws IOException, JsonParseException, JsonMappingException
    {
        ObjectMapper mapper = new ObjectMapper();        
        KinesisRecord record = null;

        try
        {
            record = mapper.readValue(json, KinesisRecord.class);
        }
        catch ( Exception ex )
        {
            LOG.log(Level.SEVERE, null, ex);
            throw ex;
        }

        return record;
    }

}
