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

import java.util.function.BinaryOperator;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public enum UnitRecordItem
{
    OUT_WHILE_NORMAL_STATE(PlayState1.ISNORMAL, PulseKind.OUT, (x, y)->x + y),
    OUT_WHILE_PRIZE1_STATE(PlayState1.ISPRIZE1, PulseKind.OUT, (x, y)->x + y),
    OUT_WHILE_PRIZE2_STATE(PlayState1.ISPRIZE2, PulseKind.OUT, (x, y)->x + y),
    OUT_WHILE_PRIZE3_STATE(PlayState1.ISPRIZE3, PulseKind.OUT, (x, y)->x + y),
    SAFE_WHILE_NORMAL_STATE(PlayState1.ISNORMAL, PulseKind.SAFE, (x, y)->x + y),
    SAFE_WHILE_PRIZE1_STATE(PlayState1.ISPRIZE1, PulseKind.SAFE, (x, y)->x + y),
    SAFE_WHILE_PRIZE2_STATE(PlayState1.ISPRIZE2, PulseKind.SAFE, (x, y)->x + y),
    SAFE_WHILE_PRIZE3_STATE(PlayState1.ISPRIZE3, PulseKind.SAFE, (x, y)->x + y),;
     
    
    // <editor-fold defaultstate="collapsed" desc=">>> constructors <<<">
    
    private UnitRecordItem(
            PlayState1 state, PulseKind kind, BinaryOperator<Long> ope )
    {
        this.itemType = state;
        this.pulseType = kind;
        this.operator = ope;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=">>> properties <<<">
    
    private final BinaryOperator<Long> operator;
    
    public BinaryOperator<Long> getOperator()
    {
        return operator;
    }
    
    private final PlayState1 itemType;

    /**
     * Get the value of itemType
     *
     * @return the value of itemType
     */
    public PlayState1 getItemType()
    {
        return itemType;
    }
    
    private final PulseKind pulseType;

    /**
     * Get the value of pulseType
     *
     * @return the value of pulseType
     */
    public PulseKind getPulseType()
    {
        return pulseType;
    }

    
    // </editor-fold>
}
