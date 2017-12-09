package com.implementation;

import com.exception.EnigmaImplementationNotSupported;

/**
 * Class provides Reflector implementation of Engima Engine
 * @author chitesh
 *
 */
public class Reflector {


    char[] elements;

    public Reflector(){
        this.elements = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'D', 'I', 'J', 'K', 'G', 'M',
                'K', 'M', 'I', 'E', 'B', 'F', 'T', 'C', 'V', 'V', 'J', 'A', 'T'};
    }


    /**
     * Method provides the index of reflected character on Reflector
     * @param index - look up character
     * @return - index of reflected character
     * @throws EnigmaImplementationNotSupported - custom exception
     */
    public int getCharAtIndexFromRotor(int index) throws EnigmaImplementationNotSupported{
    	
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
