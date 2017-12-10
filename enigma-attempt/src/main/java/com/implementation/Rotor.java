package com.implementation;

import java.util.List;

import com.utilities.EnigmaConstants;
import com.utilities.EnigmaImplementationNotSupported;

/**
 * Rotor implemention of Enigma Engine
 * @author chitesh
 *
 */
public class Rotor {

     private List<String> codes;
     
     private int notchPosition;
   
     /**
      * Constructor
      * @param codes - codes available on rotor
      * @param notchPosition - position of notch from top/window row.
      */
     public Rotor(List<String> codes, int notchPosition){
         this.codes = codes;
         this.notchPosition = notchPosition;
     }

    /**
     * Method provides index of adjacent character from the connecting row. 
     * 
     * @param positionOfElement - position of look up element
     * @param direction - indicates the direction of flow of lookup
     * @return - index of character
     * @throws EnigmaImplementationNotSupported - custom exception 
     */
     public int getIndexAdjacentLetter(int positionOfElement, String direction) throws EnigmaImplementationNotSupported{

        int charPosition = -1;

        if(direction.equals(EnigmaConstants.TOWARDS_LEFT_OF_ROTOR)){
            String indexValueOfRotor = codes.get(positionOfElement);
            char rightCharValue = indexValueOfRotor.charAt(1);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(0) == rightCharValue){
                    charPosition = i;
                    break;
                }
            }

        }
        else{

            String indexValueAtRotor = codes.get(positionOfElement);
            char leftCharValue = indexValueAtRotor.charAt(0);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(1) == leftCharValue){

                    charPosition = i;
                    break;
                }
            }
        }
        if(charPosition < 0) {
        	throw new EnigmaImplementationNotSupported("Index of character not found on Rotor");
        }

         return charPosition;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }


    public int getNotchPosition() {
        return notchPosition;
    }

    public void setNotchPosition(int notchPosition) {
        this.notchPosition = notchPosition;
    }
}


