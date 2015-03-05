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

import com.kitac.kinesissamples.consumer.model.KinesisRecord
import java.io.EOFException
import java.nio.charset.Charset
import org.scalatest.FunSpec;
import com.kitac.kinesissamples.consumer._
import org.scalatest.PrivateMethodTester._


class ConsumerSpec extends FunSpec {
  
  describe("Consumer")
  {
    val consumer = new Consumer("test", "test")
    val toJsonString = PrivateMethod[String]('toJsonString)
    val toKinesisRecord = PrivateMethod[KinesisRecord]('toKinesisRecord)
    
    val string = "eyJQcm9kdWNlcklkIjoxLCJQdWxzZURhdGEiOls5MiwxOTksMTMyLDIwLDEzNCw3LDIwMiwxNjQsMjIxLDIzMSwxNjEsMjA2LDIzOSw4NywyMjUsMTQzLDExMCwxMjUsMTU1LDE4MiwyMjcsMjA1LDgwLDUzLDEwNSwxNzMsMTE0LDUsODksMTA3LDIxNywyMjgsODAsMTYzLDE0MSwyMzgsMTQ1LDE5MiwxMzQsNDAsMTcxLDc1LDI0MSwxMiwyNCwxMTEsMTcsNjhdLCJTZXF1ZW5jZU51bWJlciI6MCwiVGltZSI6IlwvRGF0ZSgxNDIzNzkyOTE5MjYzKzA5MDApXC8iLCJVbml0SWQiOjExN30="    
    val buff = string.getBytes(Charset.forName("UTF-8"))

    describe(".toJasonString(byte[]) method")
    {
      it("should convert the byte array into JSON format string.")
      {
        var r = consumer invokePrivate toJsonString(buff)
        assert(!r.isEmpty())
      }
    }
    
    describe(".toKinesisRecord(String) method")
    {
      ignore("should produce EOFException when argument is empty string.")
      {
        intercept[EOFException]
        {
          consumer invokePrivate toKinesisRecord("") 
        }        
      }
      
      it("should convert a string into a KinesisRecord.")
      {
        var s = consumer invokePrivate toJsonString(buff)
        val kinesisRecord = consumer invokePrivate toKinesisRecord(s)
        
        assert(kinesisRecord.getUnitId === 117)
        assert(kinesisRecord.getProducerId === 1)
        assert(kinesisRecord.getSequenceNumber === 0)
      }
    }
  } 
}
