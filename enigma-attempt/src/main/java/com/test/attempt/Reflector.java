package com.test.attempt;


public class Reflector {


    char[] elements;

    public Reflector(){
        this.elements = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'D', 'I', 'J', 'K', 'G', 'M',
                'K', 'M', 'I', 'E', 'B', 'F', 'T', 'C', 'V', 'V', 'J', 'A', 'T'};
    }



    public int getCharAtIndexFromRotor(int index){

        char element = elements[index];
//        System.out.println(element);
        for(int i = 0 ; i < elements.length ; i++){
            if(elements[i] == element && i != index){
              return  i;
            }
        }

        return  0;
    }

}
