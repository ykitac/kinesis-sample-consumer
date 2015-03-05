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

import com.kitac.kinesissamples.consumer.AppConfig;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.function.IntConsumer;
import org.joda.time.DateTime;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public class UnitRecord implements Serializable
{
    // <editor-fold defaultstate="collapsed" desc=">>> constructors <<<">

    /**
     * Generates an instance of UnitRecord class.
     */
    public UnitRecord()
    {
        initialize();
    }

    /**
     * Generates an instance of UnitRecord class which specified the data source.
     * @param dataSource The data source of a generated instance.
     */
    public UnitRecord( KinesisRecord dataSource )
    {
        this.dataSource = dataSource;
        initialize();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=">>> properties <<<">
    
    
    private KinesisRecord dataSource = null;

    public final void setDataSource( KinesisRecord source )
    {
        this.dataSource = source;
        update();
    }

    public KinesisRecord getDataSource()
    {
        return this.dataSource;
    }

    private int unitId;

    /**
     * Get the value of unitId
     *
     * @return the value of unitId
     */
    public int getUnitId()
    {
        return unitId;
    }

    /**
     * Set the value of unitId
     *
     * @param unitId new value of unitId
     */
    public void setUnitId( int unitId )
    {
        this.unitId = unitId;
    }

    private long safe;

    /**
     * Get the value of safe
     *
     * @return the value of safe
     */
    public long getSafe()
    {
        return safe;
    }

    /**
     * Set the value of safe
     *
     * @param safe new value of safe
     */
    public void setSafe( long safe )
    {
        this.safe = safe;
    }

    private long out;

    /**
     * Get the value of out
     *
     * @return the value of out
     */
    public long getOut()
    {
        return out;
    }

    /**
     * Set the value of out
     *
     * @param out new value of out
     */
    public void setOut( long out )
    {
        this.out = out;
    }

    private long prize1;

    /**
     * Get the value of prize1
     *
     * @return the value of prize1
     */
    public long getPrize1()
    {
        return prize1;
    }

    /**
     * Set the value of prize1
     *
     * @param prize1 new value of prize1
     */
    public void setPrize1( long prize1 )
    {
        this.prize1 = prize1;
    }

    private long start;

    /**
     * Get the value of start
     *
     * @return the value of start
     */
    public long getStart()
    {
        return start;
    }

    /**
     * Set the value of start
     *
     * @param start new value of start
     */
    public void setStart( long start )
    {
        this.start = start;
    }

    private long prize2;

    /**
     * Get the value of prize2
     *
     * @return the value of prize2
     */
    public long getPrize2()
    {
        return prize2;
    }

    /**
     * Set the value of prize2
     *
     * @param prize2 new value of prize2
     */
    public void setPrize2( long prize2 )
    {
        this.prize2 = prize2;
    }

    private long prize3;

    /**
     * Get the value of prize3
     *
     * @return the value of prize3
     */
    public long getPrize3()
    {
        return prize3;
    }

    /**
     * Set the value of prize3
     *
     * @param prize3 new value of prize3
     */
    public void setPrize3( long prize3 )
    {
        this.prize3 = prize3;
    }

    private long input1;

    /**
     * Get the value of input1
     *
     * @return the value of input1
     */
    public long getInput1()
    {
        return input1;
    }

    /**
     * Set the value of input1
     *
     * @param input1 new value of input1
     */
    public void setInput1( long input1 )
    {
        this.input1 = input1;
    }

    private long input2;

    /**
     * Get the value of input2
     *
     * @return the value of input2
     */
    public long getInput2()
    {
        return input2;
    }

    /**
     * Set the value of input2
     *
     * @param input2 new value of input2
     */
    public void setInput2( long input2 )
    {
        this.input2 = input2;
    }

    private long cheat1;

    /**
     * Get the value of cheat1
     *
     * @return the value of cheat1
     */
    public long getCheat1()
    {
        return cheat1;
    }

    /**
     * Set the value of cheat1
     *
     * @param cheat1 new value of cheat1
     */
    public void setCheat1( long cheat1 )
    {
        this.cheat1 = cheat1;
    }

    private long cheat2;

    /**
     * Get the value of cheat2
     *
     * @return the value of cheat2
     */
    public long getCheat2()
    {
        return cheat2;
    }

    /**
     * Set the value of cheat2
     *
     * @param cheat2 new value of cheat2
     */
    public void setCheat2( long cheat2 )
    {
        this.cheat2 = cheat2;
    }

    private long cheat3;

    /**
     * Get the value of cheat3
     *
     * @return the value of cheat3
     */
    public long getCheat3()
    {
        return cheat3;
    }

    /**
     * Set the value of cheat3
     *
     * @param cheat3 new value of cheat3
     */
    public void setCheat3( long cheat3 )
    {
        this.cheat3 = cheat3;
    }

    private long cheat4;

    /**
     * Get the value of cheat4
     *
     * @return the value of cheat4
     */
    public long getCheat4()
    {
        return cheat4;
    }

    /**
     * Set the value of cheat4
     *
     * @param cheat4 new value of cheat4
     */
    public void setCheat4( long cheat4 )
    {
        this.cheat4 = cheat4;
    }

    private long emptyDish;

    /**
     * Get the value of emptyDish
     *
     * @return the value of emptyDish
     */
    public long getEmptyDish()
    {
        return emptyDish;
    }

    /**
     * Set the value of emptyDish
     *
     * @param emptyDish new value of emptyDish
     */
    public void setEmptyDish( long emptyDish )
    {
        this.emptyDish = emptyDish;
    }

    private long sales1;

    /**
     * Get the value of sales1
     *
     * @return the value of sales1
     */
    public long getSales1()
    {
        return sales1;
    }

    /**
     * Set the value of sales1
     *
     * @param sales1 new value of sales1
     */
    public void setSales1( long sales1 )
    {
        this.sales1 = sales1;
    }

    private long sales2;

    /**
     * Get the value of sales2
     *
     * @return the value of sales2
     */
    public long getSales2()
    {
        return sales2;
    }

    /**
     * Set the value of sales2
     *
     * @param sales2 new value of sales2
     */
    public void setSales2( long sales2 )
    {
        this.sales2 = sales2;
    }

    private long sales3;

    /**
     * Get the value of sales3
     *
     * @return the value of sales3
     */
    public long getSales3()
    {
        return sales3;
    }

    /**
     * Set the value of sales3
     *
     * @param sales3 new value of sales3
     */
    public void setSales3( long sales3 )
    {
        this.sales3 = sales3;
    }

    private long sales4;

    /**
     * Get the value of sales4
     *
     * @return the value of sales4
     */
    public long getSales4()
    {
        return sales4;
    }

    /**
     * Set the value of sales4
     *
     * @param sales4 new value of sales4
     */
    public void setSales4( long sales4 )
    {
        this.sales4 = sales4;
    }

    private long disconnectionSales1;

    /**
     * Get the value of disconnectionSales1
     *
     * @return the value of disconnectionSales1
     */
    public long getDisconnectionSales1()
    {
        return disconnectionSales1;
    }

    /**
     * Set the value of disconnectionSales1
     *
     * @param disconnectionSales1 new value of disconnectionSales1
     */
    public void setDisconnectionSales1( long disconnectionSales1 )
    {
        this.disconnectionSales1 = disconnectionSales1;
    }

    private long disconnectionSales2;

    /**
     * Get the value of disconnectionSales2
     *
     * @return the value of disconnectionSales2
     */
    public long getDisconnectionSales2()
    {
        return disconnectionSales2;
    }

    /**
     * Set the value of disconnectionSales2
     *
     * @param disconnectionSales2 new value of disconnectionSales2
     */
    public void setDisconnectionSales2( long disconnectionSales2 )
    {
        this.disconnectionSales2 = disconnectionSales2;
    }

    private long disconnectionSales3;

    /**
     * Get the value of disconnectionSales3
     *
     * @return the value of disconnectionSales3
     */
    public long getDisconnectionSales3()
    {
        return disconnectionSales3;
    }

    /**
     * Set the value of disconnectionSales3
     *
     * @param disconnectionSales3 new value of disconnectionSales3
     */
    public void setDisconnectionSales3( long disconnectionSales3 )
    {
        this.disconnectionSales3 = disconnectionSales3;
    }

    private long disconnectionSales4;

    /**
     * Get the value of disconnectionSales4
     *
     * @return the value of disconnectionSales4
     */
    public long getDisconnectionSales4()
    {
        return disconnectionSales4;
    }

    /**
     * Set the value of disconnectionSales4
     *
     * @param disconnectionSales4 new value of disconnectionSales4
     */
    public void setDisconnectionSales4( long disconnectionSales4 )
    {
        this.disconnectionSales4 = disconnectionSales4;
    }

    private long warningSales1;

    /**
     * Get the value of warningSales1
     *
     * @return the value of warningSales1
     */
    public long getWarningSales1()
    {
        return warningSales1;
    }

    /**
     * Set the value of warningSales1
     *
     * @param warningSales1 new value of warningSales1
     */
    public void setWarningSales1( long warningSales1 )
    {
        this.warningSales1 = warningSales1;
    }

    private long warningSales2;

    /**
     * Get the value of warningSales2
     *
     * @return the value of warningSales2
     */
    public long getWarningSales2()
    {
        return warningSales2;
    }

    /**
     * Set the value of warningSales2
     *
     * @param warningSales2 new value of warningSales2
     */
    public void setWarningSales2( long warningSales2 )
    {
        this.warningSales2 = warningSales2;
    }

    private long warningSales3;

    /**
     * Get the value of warningSales3
     *
     * @return the value of warningSales3
     */
    public long getWarningSales3()
    {
        return warningSales3;
    }

    /**
     * Set the value of warningSales3
     *
     * @param warningSales3 new value of warningSales3
     */
    public void setWarningSales3( long warningSales3 )
    {
        this.warningSales3 = warningSales3;
    }

    private long warningSales4;

    /**
     * Get the value of warningSales4
     *
     * @return the value of warningSales4
     */
    public long getWarningSales4()
    {
        return warningSales4;
    }

    /**
     * Set the value of warningSales4
     *
     * @param warningSales4 new value of warningSales4
     */
    public void setWarningSales4( long warningSales4 )
    {
        this.warningSales4 = warningSales4;
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

    private final EnumSet<PlayState1> playState1Flag 
            = EnumSet.noneOf(PlayState1.class);
    
    public EnumSet<PlayState1> getPlayState1Flag()
    {
        return this.playState1Flag;
    }

    private final byte[] pulseState = new byte[4];
    
    private final HashMap<Integer, IntConsumer> mappingTable = new HashMap<>();
    
    private final EnumMap<UnitRecordItem, Long> advancedDataTable
            = new EnumMap<>(UnitRecordItem.class);
    
    public EnumMap<UnitRecordItem, Long> getAdvancedDataTable()
    {
        return advancedDataTable;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=">>> private methods <<<">
    
    
    /**
     * Updates each properties based on the data source.
     */
    private void update()
    {
        // First, updates base data like out, safe, sales.
        updateBaseData();
        
        // Secondly, updates advanced data like out_while_normal_state.
        updateAdvancedData();
    }

    private void updateBaseData()
    {
        if(dataSource == null)
        {    
            throw new IllegalStateException(
                    "Not supported when no specific the 'dataSource' value.");
        }
        this.unitId = dataSource.getUnitId();
        this.time = dataSource.getTime();

        ByteArrayInputStream bs = new ByteArrayInputStream(this.dataSource.getPulseData());

        for ( int i = 0; i < 0x20; i++ )
        {
            // <editor-fold defaultstate="collapsed" desc="DELETED">
//            if ( this.mappingTable.containsKey(i) )
//            {
//                // Reads a byte of the pulse data of the data source,
//                // and calls setter methods associated with the byte.
//                this.mappingTable.get(i).accept(bs.read());
//            }
            // </editor-fold>
        }
        
        // <editor-fold defaultstate="collapsed" desc="PSEUDO CODE">
        setSafe(bs.read());   //0x00
        setOut(bs.read());    //0x01
        setPrize1(bs.read()); //0x02
        setStart(bs.read());  //0x03
        setPrize2(bs.read()); //0x04
        setPrize3(bs.read()); //0x05
        setInput1(bs.read()); //0x06
        setInput2(bs.read()); //0x07
        setCheat1(bs.read()); //0x08
        setCheat2(bs.read()); //0x09
        setCheat3(bs.read()); //0x0A
        setCheat4(bs.read()); //0x0B
        bs.read(); // 0x0C
        bs.read(); // 0x0D
        bs.read(); // 0x0E
        bs.read(); // 0x0F
        bs.read(); // 0x10
        bs.read(); // 0x11
        bs.read(); // 0x12
        setEmptyDish(bs.read()); //0x13
        setSales1(bs.read());    //0x14
        setSales2(bs.read());    //0x15
        setSales3(bs.read());    //0x16
        setSales4(bs.read());    //0x17
        setDisconnectionSales1(bs.read()); //0x18
        setDisconnectionSales2(bs.read()); //0x19
        setDisconnectionSales3(bs.read()); //0x1A
        setDisconnectionSales4(bs.read()); //0x1B
        setWarningSales1(bs.read());       //0x1C
        setWarningSales2(bs.read());       //0x1D
        setWarningSales3(bs.read());       //0x1E
        setWarningSales4(bs.read());       //0x1F
        
        // </editor-fold>

        // The bytes between 0x20 and 0x23 represent states of pulse,
        // so that copy them to pulseState.
        bs.read(pulseState, 0, 4);
    }
    
    private void updateAdvancedData()
    {
        if(dataSource == null || pulseState == null)
        {    
            throw new IllegalStateException(
                    "Not supported when no specific the 'dataSource' value.");
        }
        
        // Represents states of pulses.
        int state;
        
        // Convert byte array to integer. 
        try
        {
            ByteBuffer stateBuff = ByteBuffer.wrap(pulseState);
            state = stateBuff.getInt();
        }
        catch ( BufferUnderflowException e )
        {
            AppConfig.getLogger().severe(e.getMessage());
            throw e;
        }
        
        // Represents whether or not each pluses are on.
        EnumSet<PulseKind> flag = EnumSet.noneOf(PulseKind.class);
        
        for( PulseKind k : PulseKind.values())
        {
            // Sets a flag if the pulse state is on.
            if( (state & k.getOrder()) == k.getOrder() )
            {
                flag.add(k);
            }
        }
        
        // Sets play-status flag 1.
        // Is prize1.
        if( flag.contains(PulseKind.PRIZE1) )
        {
            playState1Flag.add(PlayState1.ISPRIZE1);
        }
        // Is prize2.
        else if(flag.contains(PulseKind.PRIZE2))
        {
            playState1Flag.add(PlayState1.ISPRIZE2); 
        }
        // Is prize3.
        else if(flag.contains(PulseKind.PRIZE3))
        {
            playState1Flag.add(PlayState1.ISPRIZE3);         
        }
        // Is normal state.
        else
        {
            playState1Flag.add(PlayState1.ISNORMAL); 
        }
        
        // Updates advanced data.
        for( UnitRecordItem item : UnitRecordItem.values() )
        {
               if( playState1Flag.contains(item.getItemType()) )
               {
                   switch( item.getPulseType() )
                   {
                       case OUT:
                           advancedDataTable.put(item, getOut());
                       
                       case SAFE:
                           advancedDataTable.put(item, getSafe());
                   }
               }
        }
    }
    
    private void initialize()
    {
        // Maps setter methods to the byte order.
        // <editor-fold defaultstate="collapsed" desc="DELETED">
//        this.mappingTable.put(0, (x)->setSafe(x));
//        this.mappingTable.put(1, (x)->setOut(x));
//        this.mappingTable.put(2, (x)->setPrize1(x));
//        this.mappingTable.put(3, (x)->setStart(x));
//        this.mappingTable.put(4, (x)->setPrize2(x));
//        this.mappingTable.put(5, (x)->setPrize3(x));
//        this.mappingTable.put(6, (x)->setInput1(x));
//        this.mappingTable.put(7, (x)->setInput2(x));
//        this.mappingTable.put(8, (x)->setCheat1(x));
//        this.mappingTable.put(9, (x)->setCheat2(x));
//        this.mappingTable.put(10, (x)->setCheat3(x));
//        this.mappingTable.put(11, (x)->setCheat4(x));
//        this.mappingTable.put(19, (x)->setEmptyDish(x));
//        this.mappingTable.put(20, (x)->setSales1(x));
//        this.mappingTable.put(21, (x)->setSales2(x));
//        this.mappingTable.put(22, (x)->setSales3(x));
//        this.mappingTable.put(23, (x)->setSales4(x));
//        this.mappingTable.put(24, (x)->setDisconnectionSales1(x));
//        this.mappingTable.put(25, (x)->setDisconnectionSales2(x));
//        this.mappingTable.put(26, (x)->setDisconnectionSales3(x));
//        this.mappingTable.put(27, (x)->setDisconnectionSales4(x));
//        this.mappingTable.put(28, (x)->setWarningSales1(x));
//        this.mappingTable.put(29, (x)->setWarningSales2(x));
//        this.mappingTable.put(30, (x)->setWarningSales3(x));
//        this.mappingTable.put(31, (x)->setWarningSales4(x));      
        // </editor-fold>
        
        // Updates data if the data source is specified. 
        if( this.dataSource != null )
        {
            update();
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=">>>public methods <<<">
    /**
     * Reduces two UnitRecord objects to one.
     * @param x One of combined object.
     * @param y The other. 
     * @return A UnitRecord object that is combined.
     */
    public static UnitRecord reduce( UnitRecord x, UnitRecord y )
    {
        if(x.getUnitId() != y.getUnitId())
        {
            throw new IllegalArgumentException(
                    "UnitRecord x and y must have same unit ID.");
        }
        
        UnitRecord result = new UnitRecord();
        
        result.setUnitId(y.getUnitId());
        
        // Set a time property whichever steps forward.
        if( x.getTime().isAfter(y.getTime()))
        {
            result.setTime(x.getTime());
        }
        else
        {
            result.setTime(y.getTime());
        }
        
        
        // <editor-fold defaultstate="collapsed" desc="Set basic properties.">
        result.setCheat1(x.getCheat1()+y.getCheat1());
        result.setCheat2(x.getCheat2()+y.getCheat2());
        result.setCheat3(x.getCheat3()+y.getCheat3());
        result.setCheat4(x.getCheat4()+y.getCheat4());
        result.setDisconnectionSales1(
                x.getDisconnectionSales1()+y.getDisconnectionSales1());
        result.setDisconnectionSales2(
                x.getDisconnectionSales2()+y.getDisconnectionSales2());
        result.setDisconnectionSales1(
                x.getDisconnectionSales3()+y.getDisconnectionSales3());
        result.setDisconnectionSales2(
                x.getDisconnectionSales4()+y.getDisconnectionSales4());
        result.setEmptyDish(x.getEmptyDish()+y.getEmptyDish());
        result.setInput1(x.getInput1()+y.getInput2());
        result.setOut(x.getOut()+y.getOut());
        result.setPrize1(x.getPrize1()+y.getPrize1());
        result.setPrize2(x.getPrize2()+y.getPrize2());
        result.setPrize3(x.getPrize3()+y.getPrize3());
        result.setSafe(x.getSafe()+y.getSafe());
        result.setSales1(x.getSales1()+y.getSales1());
        result.setSales2(x.getSales2()+y.getSales2());
        result.setSales3(x.getSales3()+y.getSales3());
        result.setSales4(x.getSales4()+y.getSales4());
        result.setStart(x.getStart()+y.getStart());
        result.setWarningSales1(x.getWarningSales1()+y.getWarningSales1());
        result.setWarningSales2(x.getWarningSales2()+y.getWarningSales2());
        result.setWarningSales3(x.getWarningSales3()+y.getWarningSales3());
        result.setWarningSales4(x.getWarningSales4()+y.getWarningSales4());
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Set advanced data.">
        for(UnitRecordItem item : UnitRecordItem.values())
        {
            boolean xBool = x.getAdvancedDataTable().containsKey(item); 
            boolean yBool = y.getAdvancedDataTable().containsKey(item);
            
            if(xBool && yBool)
            {
                result.getAdvancedDataTable().put(
                        item, item.getOperator().apply(
                                x.getAdvancedDataTable().get(item)
                                , y.getAdvancedDataTable().get(item)));
            }
            else if(xBool)
            {
                result.getAdvancedDataTable().put(
                        item, x.getAdvancedDataTable().get(item));
            }
            else if(yBool)
            {
                result.getAdvancedDataTable().put(
                        item, y.getAdvancedDataTable().get(item));
            }
        }
        // </editor-fold>
        
        return result;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("unitid:%1$s", getUnitId()));
        sb.append(String.format("out:%1$s", getOut()));
        sb.append(String.format("safe:%1$s", getSafe()));

        return sb.toString();
    }
    // </editor-fold>
}
