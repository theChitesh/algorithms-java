package com.test.attempt;


public class MainRunner {


    static char [] input_output = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public static void main(String[] args) {

        String encodeValue = "QMJIDO MZWZJFJR";

        String[] array = encodeValue.split(" ");

        Engine engine = new Engine();
        Rotor rotorOne = engine.initializeRotorOne();
        Rotor rotorTwo = engine.initializeRotorTwo();
        Rotor rotorThree = engine.initializeRotorThree();
        Reflector reflector = new Reflector();

        String decodedValue = "";

        for (int counter = 0; counter < array.length; counter++) {

            String tempStore = "";
            char[] charArray = array[counter].toCharArray();

            for (char c : charArray) {

                if (rotorOne.getNotchPosition() == 1 && rotorTwo.getNotchPosition() == 1) {
                    rotorTwo = engine.shiftRotorUp(rotorTwo);
                    rotorThree = engine.shiftRotorUp(rotorThree);
                } else if (rotorOne.getNotchPosition() == 1) {
                    rotorTwo = engine.shiftRotorUp(rotorTwo);

                }
                rotorOne = engine.shiftRotorUp(rotorOne);

                int i = rotorOne.getIndexAdjacentLetter(indexOfInputOutput(c), "toLeft");
                int j = rotorTwo.getIndexAdjacentLetter(i, "toLeft");
                int k = rotorThree.getIndexAdjacentLetter(j, "toLeft");
                int l = reflector.getCharAtIndexFromRotor(k);
                int m = rotorThree.getIndexAdjacentLetter(l, "toRight");
                int n = rotorTwo.getIndexAdjacentLetter(m, "toRight");
                int o = rotorOne.getIndexAdjacentLetter(n, "toRight");


                tempStore += input_output[o];
            }
            decodedValue += tempStore + " " ;

        }
        System.out.println(decodedValue);
    }




    private static int indexOfInputOutput(char input){

        for(int i =0 ; i < input_output.length ; i ++){
            if(input == input_output[i]){
                return i;
            }
        }
        return 0;
    }

}
