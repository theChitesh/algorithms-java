package com.test.attempt;

import java.util.List;

public class Rotor {

     List<String> codes;
     int notchPosition;


     public Rotor(List<String> codes, int notchPosition){
         this.codes = codes;
         this.notchPosition = notchPosition;
     }


    public int getIndexAdjacentLetter(int positionOfElement, String direction){

        int charPosition = 0;

        if(direction.equals("toLeft")){
//            System.out.println("to Left codes "+codes.get(positionOfElement));
            String indexValueOfRotor = codes.get(positionOfElement);
            char rightCharValue = indexValueOfRotor.charAt(1);
           // System.out.println(rightCharValue);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(0) == rightCharValue){
                    charPosition = i;
                    break;
                }
            }

        }
        else{
            positionOfElement = positionOfElement;
            String indexValueAtRotor = codes.get(positionOfElement);
//            System.out.println("to right codes "+codes.get(positionOfElement));
            char leftCharValue = indexValueAtRotor.charAt(0);

            for(int i = 0; i < codes.size() ; i++){
                if(codes.get(i).charAt(1) == leftCharValue){

                    charPosition = i;
                    break;
                }
            }
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


