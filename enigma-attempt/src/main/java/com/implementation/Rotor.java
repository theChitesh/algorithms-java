package com.implementation;

import java.util.List;

import com.utils.EnigmaConstants;
import com.utils.EnigmaImplementationNotSupported;
import com.utils.FlowDirection;
import com.utils.MessageKeys;

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
     public Rotor(final List<String> codes, final int notchPosition){
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
	public int getIndexAdjacentLetter(final int positionOfElement, final FlowDirection direction)
			throws EnigmaImplementationNotSupported {

        int charPosition = -1;
        
        if(direction.getValue().equals(EnigmaConstants.TOWARDS_LEFT)){
            String indexValueOfRotor = codes.get(positionOfElement);
            char rightCharValue = indexValueOfRotor.charAt(EnigmaConstants.FIRST_INDEX);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(EnigmaConstants.ZERO_INDEX) == rightCharValue){
                    charPosition = i;
                    break; 
                }
            }

        }
        else{

            String indexValueAtRotor = codes.get(positionOfElement);
            char leftCharValue = indexValueAtRotor.charAt(EnigmaConstants.ZERO_INDEX);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(EnigmaConstants.FIRST_INDEX) == leftCharValue){

                    charPosition = i;
                    break;
                }
            }
        }
        if(charPosition < 0) {
        	throw new EnigmaImplementationNotSupported(MessageKeys.CHARACTER_INDEX_NOT_FOUND_ON_ROTOR);
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


