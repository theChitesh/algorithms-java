package com.implementation;

import org.apache.log4j.Logger;

import com.utils.EnigmaConstants;
import com.utils.EnigmaImplementationNotSupported;
import com.utils.FlowDirection;
import com.utils.MessageKeys;

/**
 * Class implements the Enigma algorithm for encoding and decoding. This
 * implementation of Engima only support encryption and decryption of alphabets.
 * 
 * Numbers and special characters are not supported.
 * 
 * @author chitesh
 *
 */
public class EnigmaRunner {

	final static Logger logger = Logger.getLogger(EnigmaRunner.class);

	private Engine engine;
	private Rotor rotorOne;
	private Rotor rotorTwo;
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
	public static void main(String[] args) {

		String encodedValue = "QMJIDO MZWZJFJR";
		EnigmaRunner runner = new EnigmaRunner();
		String[] array = encodedValue.split(EnigmaConstants.STRING_SEPERATOR);
		String decodedValue = "";

		try {

			for (int counter = 0; counter < array.length; counter++) {
				decodedValue += runner.decode(array[counter].toCharArray()) + EnigmaConstants.STRING_SEPERATOR;
			}
			System.out.print("Decoded Value: " + decodedValue);
		} catch (EnigmaImplementationNotSupported enigmaException) {
			logger.error("Error : " + enigmaException.getMessage());

		}

	}

	/**
	 * Method implements decoding of encoded string
	 * 
	 * @param charArray
	 *            - encoded char array
	 * @return - decoded String
	 * @throws EnigmaImplementationNotSupported
	 * @throws Exception
	 */
	public String decode(final char[] charArray) throws EnigmaImplementationNotSupported {

		String decodedChars = "";
		for (char c : charArray) {

			adjustRotors();
			decodedChars += getDecodedCharacter(c);
		}

		return decodedChars;

	}

	/**
	 * Method helps in decrypting the encoded character
	 * 
	 * @param c
	 *            - encoded character
	 * @return - decoded character
	 * @throws EnigmaImplementationNotSupported
	 *             - enigma exception
	 */
	private char getDecodedCharacter(char c) throws EnigmaImplementationNotSupported {

		int i = rotorOne.getIndexAdjacentLetter(indexOfInputOutput(c), FlowDirection.TO_LEFT);
		int j = rotorTwo.getIndexAdjacentLetter(i, FlowDirection.TO_LEFT);
		int k = rotorThree.getIndexAdjacentLetter(j, FlowDirection.TO_LEFT);
		int l = reflector.getCharAtIndexFromRotor(k);
		int m = rotorThree.getIndexAdjacentLetter(l, FlowDirection.TO_RIGHT);
		int n = rotorTwo.getIndexAdjacentLetter(m, FlowDirection.TO_RIGHT);
		int o = rotorOne.getIndexAdjacentLetter(n, FlowDirection.TO_RIGHT);
		return EnigmaConstants.INPUT_OUTPUT[o];
	}

	/**
	 * Method used to adjust rotors for every input character
	 */
	private void adjustRotors() {

		if (rotorOne.getNotchPosition() == EnigmaConstants.FIRST_INDEX
				&& rotorTwo.getNotchPosition() == EnigmaConstants.FIRST_INDEX) {
			engine.shiftRotorUp(rotorTwo);
			engine.shiftRotorUp(rotorThree);
		} else if (rotorOne.getNotchPosition() == EnigmaConstants.FIRST_INDEX) {
			engine.shiftRotorUp(rotorTwo);

		}
		engine.shiftRotorUp(rotorOne);

	}

	/**
	 * Method gives the index of input character
	 * 
	 * @param input
	 *            - character value
	 * @return - index from static char array
	 * @throws EnigmaImplementationNotSupported
	 */
	private int indexOfInputOutput(final char input) throws EnigmaImplementationNotSupported {

		int index = -1;
		for (int i = 0; i < EnigmaConstants.INPUT_OUTPUT.length; i++) {
			if (input == EnigmaConstants.INPUT_OUTPUT[i]) {
				index = i;
			}
		}
		if (index < 0) {
			throw new EnigmaImplementationNotSupported(MessageKeys.INPUT_CHARACTER_NOT_SUPPORTED);
		}

		return index;
	}

	public Rotor getRotorOne() {
		return rotorOne;
	}

	public void setRotorOne(Rotor rotorOne) {
		this.rotorOne = rotorOne;
	}

}
