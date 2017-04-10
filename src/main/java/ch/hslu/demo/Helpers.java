package ch.hslu.demo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reto.stadelmann
 */
public final class Helpers {
    public static void checkNullArgument(Object obj, String argumentName){
        if(obj == null){
            throw new IllegalArgumentException("Argument " + argumentName + " was null." );
        }
    }
}
