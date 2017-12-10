package com.implementation;

import com.utilities.EnigmaConstants;
import com.utilities.EnigmaImplementationNotSupported;

/**
 * Class implements the Enigma algorithm for encoding and decoding.
 * @author chitesh
 *
 */
public class EnigmaRunner {


    private Engine engine;
    private Rotor rotorOne ;
    private Rotor rotorTwo ;
    private Rotor rotorThree;
    private Reflector reflector;

    /**
     * Constructor
     */
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
		String[] array = encodedValue.split(EnigmaConstants.STRING_SEPERATOR);
		
		String decodedValue = "";

		for (int counter = 0; counter < array.length; counter++) {
			decodedValue += runner.decode(array[counter].toCharArray()) + EnigmaConstants.STRING_SEPERATOR;
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
	public String decode(final char[] charArray) {

		String tempStore = "";
		try {
			for (char c : charArray) {

				adjustRotors();

				int i = rotorOne.getIndexAdjacentLetter(indexOfInputOutput(c), EnigmaConstants.TOWARDS_LEFT_OF_ROTOR);
				int j = rotorTwo.getIndexAdjacentLetter(i, EnigmaConstants.TOWARDS_LEFT_OF_ROTOR);
				int k = rotorThree.getIndexAdjacentLetter(j, EnigmaConstants.TOWARDS_LEFT_OF_ROTOR);
				int l = reflector.getCharAtIndexFromRotor(k);
				int m = rotorThree.getIndexAdjacentLetter(l, EnigmaConstants.TOWARDS_RIGHT_OF_ROTOR);
				int n = rotorTwo.getIndexAdjacentLetter(m, EnigmaConstants.TOWARDS_RIGHT_OF_ROTOR);
				int o = rotorOne.getIndexAdjacentLetter(n, EnigmaConstants.TOWARDS_RIGHT_OF_ROTOR);

				tempStore += EnigmaConstants.INPUT_OUTPUT[o];

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

		if (rotorOne.getNotchPosition() == EnigmaConstants.FIRST_POSITION
				&& rotorTwo.getNotchPosition() == EnigmaConstants.FIRST_POSITION) {
			
			rotorTwo = engine.shiftRotorUp(rotorTwo);
			rotorThree = engine.shiftRotorUp(rotorThree);
		} else if (rotorOne.getNotchPosition() == EnigmaConstants.FIRST_POSITION) {
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
    private int indexOfInputOutput(final char input) throws EnigmaImplementationNotSupported{

    	int index = -1;
        for(int i = 0 ; i < EnigmaConstants.INPUT_OUTPUT.length ; i ++){
            if(input == EnigmaConstants.INPUT_OUTPUT[i]){
                index = i;
            }
        }
        if(index < 0) {
        	throw new EnigmaImplementationNotSupported("Input Character Not found");
        }
       
        return index;
    }

}
