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
package com.kitac.kinesissamples.consumer.communication;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.kitac.kinesissamples.consumer.model.*;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public class DynamoDBManager
{
    // <editor-fold defaultstate="collapsed" desc=">>> private fields <<<">
    private final DynamoDB dynamoDBConnection;    
    
    private final ClientConfiguration config;
    
    private final String TABLE_NAME = "records";
    // </editor-fold>
    
    /**
     * The manager object of Amazon DynamoDB operation.
     */
    public final static DynamoDBManager DYNAMODB_MANAGER;
    
    // <editor-fold defaultstate="collapsed" desc=">>> constructors <<<">
    static
    {
        DYNAMODB_MANAGER = new DynamoDBManager();
    }
    
    private DynamoDBManager()
    {
        config = new ClientConfiguration();
        
        
        /* TODO: ClientConfiguration setting code is here. */
        

        
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(
                // For use IAM role, specify DefaultAWSCredentialsProviderChain instance.
                new DefaultAWSCredentialsProviderChain(),
                config);
        

        client.setRegion(Regions.AP_NORTHEAST_1);
        
        dynamoDBConnection = new DynamoDB(client);
    }
    // </editor-fold>
    
    /**
     * Puts an item that represents the UnitRecord object to the DynamoDB table.
     * @param record The UnitRecord object as an item of the DynamoDB table.
     * @return a PutItemOutcome object.
     */
    public PutItemOutcome putRecord( UnitRecord record )
    {
        return putRecord(record, TABLE_NAME);
    }
    
    /**
     * Puts an item that represents the UnitRecord object 
     * to the DynamoDB table whose name is specified by 'tableName' parameter.
     * @param record The UnitRecord object as an item of the DynamoDB table.
     * @param tableName Name of the DynamoDB table.
     * @return a PutItemOutcome object.
     */
    public PutItemOutcome putRecord( UnitRecord record, String tableName )
    {
        PutItemOutcome outcome = null;
        try
        {
            Table table = dynamoDBConnection.getTable(tableName);
            
            Item item = new Item()
                .withPrimaryKey("unit_id", record.getUnitId(),
                                "datetime", record.getTime().toString())
                .withLong("out", record.getOut())
                .withLong("safe", record.getSafe())
                .withLong("start", record.getStart())
                .withLong("prize1", record.getPrize1())
                .withLong("prize2", record.getPrize2())
                .withLong("prize3", record.getPrize3())
                .withLong("input1", record.getInput1())
                .withLong("input2", record.getInput2())
                .withLong("cheat1", record.getCheat1())
                .withLong("cheat2", record.getCheat2())
                .withLong("cheat3", record.getCheat3())
                .withLong("cheat4", record.getCheat4())
                .withLong("sales1", record.getSales1())
                .withLong("sales2", record.getSales2())
                .withLong("sales3", record.getSales3())
                .withLong("sales4", record.getSales4());
        
            record.getAdvancedDataTable().entrySet().stream().forEach(
                entrySet->item.withLong(entrySet.getKey().name(), entrySet.getValue()));
                    
            outcome = table.putItem(item);
        }
        catch ( ResourceNotFoundException e )
        {
            throw e;
        }
        
        return outcome;
    }
}
