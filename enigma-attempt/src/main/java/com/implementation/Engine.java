package com.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class helps in initializing the Rotor instances and support their shifting.
 * @author chitesh
 *
 */
public class Engine {


    boolean indicateShiftOfNextRotor = false;

    /**
     * Rotor one (Left Rotor initialization)
     * @return - instanse of Rotor one
     */
    public Rotor initializeRotorOne(){

        final int NOTCH_POSITION = 22;
        final String[] CHAR_CODES = {"KX", "LV", "MZ", "NN", "OY", "PE", "QI", "RW", "SG", "TA", "UK", "VM",
                "WU", "XS", "YQ", "ZO", "AB", "BD", "CF", "DH", "EJ", "FL", "GC", "HP", "IR", "JT"};

        List<String> codes = new ArrayList<>(CHAR_CODES.length);
        Collections.addAll(codes,CHAR_CODES);

        Rotor rotor = new Rotor(codes,NOTCH_POSITION);
        return rotor;


    }

    /**
     * Rotor two initialization (Center Rotor)
     * @return - instance of Rotor
     */
    public Rotor initializeRotorTwo(){

        final int NOTCH_POSITION = 5;
        final String [] CHAR_CODES = {"CD", "DK", "ES", "FI", "GR", "HU", "IX", "JB", "KL",
                "LH", "MW", "NT", "OM", "PC", "QQ", "RG", "SZ", "TN", "UP", "VY", "WF", "XV", "YO", "ZE", "AA", "BJ"};


        List<String> codes = new ArrayList<>(CHAR_CODES.length);
        Collections.addAll(codes,CHAR_CODES);
        Rotor rotor = new Rotor(codes,NOTCH_POSITION);
        return rotor;
    }

    /**
     * Rotor three initialization (Right rotor)
     * @return
     */
    public Rotor initializeRotorThree(){

        final int NOTCH_POSITION = 17;
        final String [] CHAR_CODES = {"MO", "NW", "OY", "PH", "QX", "RU", "SS", "TP", "UA", "VI",
                "WB", "XR", "YC", "ZJ", "AE", "BK", "CM", "DF", "EL", "FG", "GD", "HQ", "IV", "JZ", "KN", "LT"};


        List<String> codes = new ArrayList<>(CHAR_CODES.length);
        Collections.addAll(codes,CHAR_CODES);
        Rotor rotor = new Rotor(codes,NOTCH_POSITION);
        return rotor;
    }

    /**
     * Method provides implementation of shifting rotors
     * @param rotor - instance of rotor
     * @return - shifted rotor instance
     */
    public Rotor shiftRotorUp(Rotor rotor){

        int notchPosition = rotor.getNotchPosition();

        if(notchPosition == 1){
            indicateShiftOfNextRotor = true;
            rotor.setNotchPosition(26);
        }
        else{
            rotor.setNotchPosition(notchPosition -1);
        }


        String temp = rotor.getCodes().get(0);
        rotor.getCodes().remove(0);
        rotor.getCodes().add(temp);

        return rotor;
    }




}
