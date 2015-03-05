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
package com.kitac.kinesissamples.consumer.model;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
@JsonIgnoreProperties(ignoreUnknown = false)
public class KinesisRecord implements Serializable
{
    // <editor-fold defaultstate="collapsed" desc=">>> constructors <<<">
    
    public KinesisRecord()
    {

    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=">>> properties <<<">
    private int producerId;

    /**
     * Get the value of producerId
     *
     * @return the value of producerId
     */
    @JsonProperty( "ProducerId" )
    public int getProducerId()
    {
        return this.producerId;
    }

    /**
     * Set the value of producerId
     *
     * @param producerId new value of producerId
     */
    @JsonProperty( "ProducerId" )
    public void setProducerId( int producerId )
    {
        this.producerId = producerId;
    }

    private int unitId;

    /**
     * Get the value of unitId
     *
     * @return the value of unitId
     */
    @JsonProperty( "UnitId" )
    public int getUnitId()
    {
        return unitId;
    }

    /**
     * Set the value of unitId
     *
     * @param unitId new value of unitId
     */
    @JsonProperty( "UnitId" )
    public void setUnitId( int unitId )
    {
        this.unitId = unitId;
    }

    private int sequenceNumber;

    /**
     * Get the value of sequenceNumber
     *
     * @return the value of sequenceNumber
     */
    @JsonProperty( "SequenceNumber" )
    public int getSequenceNumber()
    {
        return sequenceNumber;
    }

    /**
     * Set the value of sequenceNumber
     *
     * @param sequenceNumber new value of sequenceNumber
     */
    @JsonProperty( "SequenceNumber" )
    public void setSequenceNumber( int sequenceNumber )
    {
        this.sequenceNumber = sequenceNumber;
    }

    private DateTime time;

    /**
     * Get the value of time
     *
     * @return the value of time
     */
    
    public DateTime getTime()
    {
        return time;
    }

    /**
     * Set the value of time
     *
     * @param time new value of time
     */
    public void setTime( DateTime time )
    {
        this.time = time;
    }

    private byte[] pulseData;

    /**
     * Get the value of pulseData
     *
     * @return the value of pulseData
     */
    @JsonProperty( "PulseData" )
    public byte[] getPulseData()
    {
        return pulseData;
    }

    /**
     * Set the value of pulseData
     *
     * @param pulseData new value of pulseData
     */
    @JsonProperty( "PulseData" )
    public void setPulseData( byte[] pulseData )
    {
        this.pulseData = pulseData;
    }

    private String timeString;

    /**
     * Get the value of timeString
     *
     * @return the value of timeString
     */
    @JsonProperty( "Time" )
    public String getTimeString()
    {
        return timeString;
    }

    /**
     * Set the value of timeString
     *
     * @param timeString new value of timeString
     */
    @JsonProperty( "Time" )
    public void setTimeString( String timeString )
    {
        this.timeString = timeString;
        // Convert time string into DateTime.
        String[] buff = this.timeString.split("[¥(¥)¥+]");
        long l = Long.parseLong(buff[1]);
        setTime(new DateTime(l, DateTimeZone.getDefault()));
        
    }

    // </editor-fold>
}
