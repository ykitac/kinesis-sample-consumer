/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kitac.kinesissamples.consumer;

import java.io.Serializable;
import org.apache.log4j.*;

/**
 *
 * @author ykitac
 */
public final class Main implements Serializable {
    private static final Logger log = Logger.getLogger( Main.class );
    
    // Represents the internal state of the application.
    private static Consumer context;

    /* Make the constructor private to enforce singleton */
    private Main()
    {
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /* Check that all required args were passed in. */
        if (args.length < 2) {
          System.err.println(
              "Usage: kinesis-sample-consumer <stream-name> <endpoint-url>\n" +
              "    <stream-name> is the name of the Kinesis stream\n" +
              "    <endpoint-url> is the endpoint of the Kinesis service\n" +
              "                   (e.g. https://kinesis.us-east-1.amazonaws.com)\n");
          System.exit(1);
        }
        
        /* Populate the appropriate variables from the given args */
        String streamName = args[0];
        String endpointUrl = args[1];
        
//        // TODO code application logic here
        context = new Consumer( streamName, endpointUrl );
        context.consume();
        
        
    }
}
