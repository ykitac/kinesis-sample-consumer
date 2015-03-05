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
public enum PulseKind
{
    OUT(1),
    SAFE(1 << 0x01),
    PRIZE1(1 << 0x02),
    PRIZE2(1 << 0x03),
    PRIZE3(1 << 0x04),
    SALES1(1 << 0x05),
    SALES2(1 << 0x06),
    SALES3(1 << 0x07),
    SALES4(1 << 0x08),
    START(1 << 0x09),
    INPUT1(1 << 0x0A),
    INPUT2(1 << 0x0B),
    CHEAT1(1 << 0x0C),
    CHEAT2(1 << 0x0D),
    CHEAT3(1 << 0x0E),
    CHEAT4(1 << 0x0F),
    EMPTYDISH(1 << 0x13),
    DISCONNECTIONSALES1(1 << 0x14),
    DISCONNECTIONSALES2(1 << 0x15),
    DISCONNECTIONSALES3(1 << 0x16),
    DISCONNECTIONSALES4(1 << 0x17),
    WARNINGSALES1(1 << 0x18),
    WARNINGSALES2(1 << 0x19),
    WARNINGSALES3(1 << 0x1A),
    WARNINGSALES4(1 << 0x1B),;
    
    private final int order;
    
    private PulseKind(int o)
    {
        order = o;
    }
    
    public int getOrder()
    {
        return order;
    }    
}
