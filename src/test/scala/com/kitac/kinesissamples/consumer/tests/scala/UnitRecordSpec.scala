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

import org.scalatest.FunSpec
import com.kitac.kinesissamples.consumer.model._

class UnitRecordSpec extends FunSpec{
  describe("UnitRecord")
  {
    describe(".setDataSource( KinesisRecord ) method")
    {
      it("should not throw exception.")
      {
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
      }
    }
  }
}
