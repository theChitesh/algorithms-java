package com.test.attempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engine {


    boolean indicateShiftOfNextRotor = false;

    public Rotor initializeRotorOne(){

        int notchPosition = 22;
        String[] charCodes = {"KX", "LV", "MZ", "NN", "OY", "PE", "QI", "RW", "SG", "TA", "UK", "VM",
                "WU", "XS", "YQ", "ZO", "AB", "BD", "CF", "DH", "EJ", "FL", "GC", "HP", "IR", "JT"};

        List<String> codes = new ArrayList<>(charCodes.length);
        Collections.addAll(codes,charCodes);

        Rotor rotor = new Rotor(codes,notchPosition);
        return rotor;


    }

    public Rotor initializeRotorTwo(){

        int notchPosition = 5;
        String [] charCodes2 = {"CD", "DK", "ES", "FI", "GR", "HU", "IX", "JB", "KL",
                "LH", "MW", "NT", "OM", "PC", "QQ", "RG", "SZ", "TN", "UP", "VY", "WF", "XV", "YO", "ZE", "AA", "BJ"};


        List<String> codes = new ArrayList<>(charCodes2.length);
        Collections.addAll(codes,charCodes2);
        Rotor rotor = new Rotor(codes,notchPosition);
        return rotor;
    }

    public Rotor initializeRotorThree(){

        int notchPosition = 17;
        String [] charCodes2 = {"MO", "NW", "OY", "PH", "QX", "RU", "SS", "TP", "UA", "VI",
                "WB", "XR", "YC", "ZJ", "AE", "BK", "CM", "DF", "EL", "FG", "GD", "HQ", "IV", "JZ", "KN", "LT"};


        List<String> codes = new ArrayList<>(charCodes2.length);
        Collections.addAll(codes,charCodes2);
        Rotor rotor = new Rotor(codes,notchPosition);
        return rotor;
    }

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
