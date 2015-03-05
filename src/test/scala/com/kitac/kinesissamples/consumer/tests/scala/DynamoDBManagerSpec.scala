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

package com.kitac.kinesissamples.consumer.tests.scala

import java.util.logging.Level
import java.util.logging.Logger
import org.scalatest.FunSpec
import com.kitac.kinesissamples.consumer.model._
import com.amazonaws.AmazonServiceException
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException
import com.kitac.kinesissamples.consumer.communication._
import scala.reflect._


class DynamoDBManagerSpec extends FunSpec {
  describe("DynamoDBManager")
  {
    describe(".putRecord(UnitRecord) method")
    {      
        var manager : DynamoDBManager = DynamoDBManager.DYNAMODB_MANAGER
        
      it("should produce NullPointerException when argument is null")
      {
        intercept[NullPointerException]
        {
          manager.putRecord(null)  
        }
      }
      
      val record = new UnitRecord()
      val kinesis = new KinesisRecord()
      kinesis.setUnitId(1)
      kinesis.setProducerId(1)
      kinesis.setSequenceNumber(1)
      kinesis.setTime(org.joda.time.DateTime.now())
      val array = new Array[Byte](0x40)  
      for(i<-0 until array.length)
      {
        array.update(i, 0.toByte)
      }
      kinesis.setPulseData(array)
      record.setDataSource(kinesis)
      
      it("should produce ResourceNotFoundException when specified table is not found.")
      {
        intercept[ResourceNotFoundException]
        {
          manager.putRecord(record, "not_a_table_name")
        }
      }
      
      it("should produce AmazonServiceExeption when specified table name is incorrect.")
      {
        intercept[AmazonServiceException]
        {
          manager.putRecord(record, "not a table name")
        }
      }
      
      
      it("should success when it is specified valid argument.")
      {        
        val outcome = manager.putRecord(record)
//        val tag = classTag[DynamoDBManagerSpec]
//        var logger = Logger.getLogger(tag.toString)
        
//        logger.log(Level.INFO,"unit_id:{0}",outcome.getItem.toString)
      }
   }
  }
}
