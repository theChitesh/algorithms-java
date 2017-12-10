package com.implementation;

import com.utilities.EnigmaConstants;
import com.utilities.EnigmaImplementationNotSupported;

/**
 * Class provides Reflector implementation of Engima Engine
 * @author chitesh
 *
 */
public class Reflector {


   private final char[] elements;

    public Reflector(){
        this.elements = EnigmaConstants.REFLECTOR_CHAR_ARRAY;
    }


    /**
     * Method provides the index of reflected character on Reflector
     * @param index - look up character
     * @return - index of reflected character
     * @throws EnigmaImplementationNotSupported - custom exception
     */
    public int getCharAtIndexFromRotor(final int index) throws EnigmaImplementationNotSupported{
    	
    	int outIndex = -1 ;
        char element = elements[index];
        for(int i = 0 ; i < elements.length ; i++){
            if(elements[i] == element && i != index){
            	outIndex = i;;
            }
        }
        if(outIndex < 0) {
        	throw new EnigmaImplementationNotSupported("Index of look up character not found on Reflector");
        }

        return outIndex;
    }

}
