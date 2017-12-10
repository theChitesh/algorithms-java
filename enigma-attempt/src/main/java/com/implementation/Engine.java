package com.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.utilities.EnigmaConstants;

/**
 * Class helps in initializing the Rotor instances and support their shifting.
 * @author chitesh
 *
 */
public class Engine {


    /**
     * Rotor one (Left Rotor initialization)
     * @return - instanse of Rotor one
     */
    public Rotor initializeRotorOne(){
        
        List<String> codes = new ArrayList<>(EnigmaConstants.ROTOR_ONE_CODES.length);
        Collections.addAll(codes,EnigmaConstants.ROTOR_ONE_CODES);

        Rotor rotor = new Rotor(codes,EnigmaConstants.ROTOR_ONE_INITIAL_NOTCH_POSITION);
        return rotor;


    }

    /**
     * Rotor two initialization (Center Rotor)
     * @return - instance of Rotor
     */
    public Rotor initializeRotorTwo(){

        List<String> codes = new ArrayList<>(EnigmaConstants.ROTOR_TWO_CODES.length);
        Collections.addAll(codes,EnigmaConstants.ROTOR_TWO_CODES);
        Rotor rotor = new Rotor(codes,EnigmaConstants.ROTOR_TWO_INITIAL_NOTCH_POSITION);
        return rotor;
    }

    /**
     * Rotor three initialization (Right rotor)
     * @return
     */
    public Rotor initializeRotorThree(){

        List<String> codes = new ArrayList<>(EnigmaConstants.ROTOR_THREE_CODES.length);
        Collections.addAll(codes,EnigmaConstants.ROTOR_THREE_CODES);
        Rotor rotor = new Rotor(codes,EnigmaConstants.ROTOR_THREE_INITIAL_NOTCH_POSITION);
        return rotor;
    }

    /**
     * Method provides implementation of shifting rotors
     * @param rotor - instance of rotor
     * @return - shifted rotor instance
     */
    public Rotor shiftRotorUp(Rotor rotor){

        int notchPosition = rotor.getNotchPosition();

        if(notchPosition == EnigmaConstants.FIRST_POSITION){
            rotor.setNotchPosition(EnigmaConstants.LAST_NOTCH_POSITION);
        }
        else{
            rotor.setNotchPosition(notchPosition - 1);
        }


        String temp = rotor.getCodes().get(EnigmaConstants.FIRST_INDEX_IN_ARRAY);
        rotor.getCodes().remove(EnigmaConstants.FIRST_INDEX_IN_ARRAY);
        rotor.getCodes().add(temp);

        return rotor;
    }




}
