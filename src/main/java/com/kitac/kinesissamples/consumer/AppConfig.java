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
package com.kitac.kinesissamples.consumer;

import java.util.HashMap;
import java.util.function.BinaryOperator;
import java.util.logging.Logger;

/**
 *
 * @author ykitac <y-urano@kitadenshi.co.jp>
 */
public final class AppConfig
{
    // <editor-fold defaultstate="collapsed" desc=">>> Application Config <<<">

    // MUST satisfy regular expression pattern: [a-zA-Z0-9_.-]+
    // This name uses as the table name of Amazon DynamoDB.
    private static final String APPLICATION_NAME = "KinesisConsumerTest";

    public static String getApplicationName()
    {
        return APPLICATION_NAME;
    }

    private static final long DURATION = 1000;

    public static long getDuration()
    {
        return DURATION;
    }

    private static final Logger LOG = Logger.getLogger(AppConfig.class.getName());

    public static Logger getLogger()
    {
        return LOG;
    }

    private static final HashMap<String, BinaryOperator<Long>> UNIT_DATA_MAP = new HashMap<>();

    public static HashMap<String, BinaryOperator<Long>> getUnitDataMap()
    {
        return UNIT_DATA_MAP;
    }
    
    // </editor-fold>
}
