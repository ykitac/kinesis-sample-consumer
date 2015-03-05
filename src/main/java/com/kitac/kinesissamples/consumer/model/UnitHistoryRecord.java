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


/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public class UnitHistoryRecord extends UnitRecord {

// <editor-fold defaultstate="collapsed" desc=">>> enums <<< ">
    
    public enum HistoryType
    {
        OPERATING("001"),
        PLAYING("002"),
        PRIZE1("004"),
        PRIZE2("005"),
        PRIZE3("006"),
        CHANGESALES1("017"),
        CHANGESALES2("018"),
        CHANGESALES3("019"),
        CHANGESALES4("020"),
        TIMER("022"),
        PERIODIC("023"),;
        
        private final String typeCode;

        private HistoryType(String typeCode) {
            this.typeCode = typeCode;
        }
        
        public String getTypeCode()
        {
            return typeCode;
        }
    }

// </editor-fold>

//<editor-fold defaultstate="collapsed" desc=">>> constructors <<<">

    public UnitHistoryRecord() 
    {
        super();
    }

    public UnitHistoryRecord( KinesisRecord dataSource )
    {
        super(dataSource);
    }
    
//</editor-fold>
    
// <editor-fold defaultstate="collapsed" desc=">>> properties <<<">
    
    private boolean isBeginning;

    /**
     * Get the value of isBeginning
     *
     * @return the value of isBeginning
     */
    public boolean getIsBeginning() {
        return isBeginning;
    }

    /**
     * Set the value of isBeginning
     *
     * @param isBeginning new value of isBeginning
     */
    public void setIsBeginning(boolean isBeginning) {
        this.isBeginning = isBeginning;
    }

    private HistoryType historyType;

    /**
     * Get the value of historyType
     *
     * @return the value of historyType
     */
    public HistoryType getHistoryType() {
        return historyType;
    }

    /**
     * Set the value of historyType
     *
     * @param historyType new value of historyType
     */
    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }

// </editor-fold>    
}
