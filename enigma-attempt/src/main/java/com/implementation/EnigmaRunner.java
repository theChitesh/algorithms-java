package com.implementation;

import com.exception.EnigmaImplementationNotSupported;

/**
 * Class implements the Enigma algorithm for encoding and decoding.
 * @author chitesh
 *
 */
public class EnigmaRunner {


    final static char [] INPUT_OUTPUT = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    private Engine engine;
    private Rotor rotorOne ;
    private Rotor rotorTwo ;
    private Rotor rotorThree;
    private Reflector reflector;

    private final int INDEX_ONE = 1;
    
    public EnigmaRunner() {
    	
    	engine = new Engine();
        rotorOne = engine.initializeRotorOne();
        rotorTwo = engine.initializeRotorTwo();
        rotorThree = engine.initializeRotorThree();
        reflector = new Reflector();

    	
    }
    

	/**
	 * Runner method needed for execution
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String encodedValue = "QMJIDO MZWZJFJR";
		
		EnigmaRunner runner = new EnigmaRunner();
		String[] array = encodedValue.split(" ");
		String decodedValue = "";

		for (int counter = 0; counter < array.length; counter++) {
			decodedValue += runner.decode(array[counter].toCharArray()) + " ";
		}

		System.out.print(decodedValue);
	}
	
	/**
	 * Method implements decoding of encoded string
	 * 
	 * @param charArray - encoded char array
	 * @return - decoded String
	 * @throws Exception 
	 */
	public String decode(char[] charArray) {

		String tempStore = "";
		try {
			for (char c : charArray) {

				adjustRotors();

				int i = rotorOne.getIndexAdjacentLetter(indexOfInputOutput(c), "toLeft");
				int j = rotorTwo.getIndexAdjacentLetter(i, "toLeft");
				int k = rotorThree.getIndexAdjacentLetter(j, "toLeft");
				int l = reflector.getCharAtIndexFromRotor(k);
				int m = rotorThree.getIndexAdjacentLetter(l, "toRight");
				int n = rotorTwo.getIndexAdjacentLetter(m, "toRight");
				int o = rotorOne.getIndexAdjacentLetter(n, "toRight");

				tempStore += INPUT_OUTPUT[o];

			}
		} catch (EnigmaImplementationNotSupported e) {
			e.printStackTrace();
		}
		return tempStore;

	}	
	

    /**
     * Method used to adjust rotors for every input character
     */
    private void adjustRotors() {
    	
        if (rotorOne.getNotchPosition() == INDEX_ONE && rotorTwo.getNotchPosition() == INDEX_ONE) {
            rotorTwo = engine.shiftRotorUp(rotorTwo);
            rotorThree = engine.shiftRotorUp(rotorThree);
        } else if (rotorOne.getNotchPosition() == INDEX_ONE) {
            rotorTwo = engine.shiftRotorUp(rotorTwo);

        }
        rotorOne = engine.shiftRotorUp(rotorOne);

    }

    /**
     * Method gives the index of input character
     * @param input - character value
     * @return - index from static char array
     * @throws EnigmaImplementationNotSupported 
     */
    private int indexOfInputOutput(char input) throws EnigmaImplementationNotSupported{

    	int index = -1;
        for(int i = 0 ; i < INPUT_OUTPUT.length ; i ++){
            if(input == INPUT_OUTPUT[i]){
                index = i;
            }
        }
        if(index < 0) {
        	throw new EnigmaImplementationNotSupported("Input Character Not found");
        }
       
        return index;
    }

}
