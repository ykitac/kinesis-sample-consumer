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
public enum PlayState1
{
    CARDINSERTED(1),
    ISMEMBER(1 << 0x01),
    ISRUNNING(1 << 0x02),
    ISNORMAL(1 << 0x03),
    ISPRIZE(1 << 0x04),
    ISPRIZE1(1 << 0x05),
    ISPRIZE2(1 << 0x06),
    ISPRIZE3(1 << 0x07),
    ISPRIZE4(1 << 0x08),
    ISPRIZE5(1 << 0x09),
    SBFLAG(1 << 0x0A),
    ISSTOPPED(1 << 0x0C),
    ISAUTOSTOPPED(1 << 0x0D),
    ISDISHEMPTY(1 << 0x0E),
    ISCALLED(1 << 0x0F),;
    
    private PlayState1(int value)
    {
        order = value;
    }
    
    private final int order;

    /**
     * Get the value of order
     *
     * @return the value of order
     */
    public int getOrder()
    {
        return order;
    }

}
