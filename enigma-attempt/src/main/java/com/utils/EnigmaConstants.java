package com.utils;

public final class EnigmaConstants {

	/**
	 * character array to be used to pick input character to encode and corresponding output code
	 */
	public static final char[] INPUT_OUTPUT = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * character array distributed over reflector, returns the common reflected output point
	 */
	public static final char[] REFLECTOR_CHAR_ARRAY = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'D', 'I', 'J',
			'K', 'G', 'M', 'K', 'M', 'I', 'E', 'B', 'F', 'T', 'C', 'V', 'V', 'J', 'A', 'T' };

	/**
	 * List of codes defines the initial position of Rotor One (Left Rotor)
	 */
	public static final String[] ROTOR_ONE_CODES = { "KX", "LV", "MZ", "NN", "OY", "PE", "QI", "RW", "SG", "TA", "UK",
			"VM", "WU", "XS", "YQ", "ZO", "AB", "BD", "CF", "DH", "EJ", "FL", "GC", "HP", "IR", "JT" };

	/**
	 * Initial position of Notch for Rotor One
	 */
	public static final int ROTOR_ONE_INITIAL_NOTCH_POSITION = 22;

	/**
	 * List of codes defines the initial position of Rotor two (Center Rotor)
	 */
	public static final String[] ROTOR_TWO_CODES = { "CD", "DK", "ES", "FI", "GR", "HU", "IX", "JB", "KL", "LH", "MW",
			"NT", "OM", "PC", "QQ", "RG", "SZ", "TN", "UP", "VY", "WF", "XV", "YO", "ZE", "AA", "BJ" };

	/**
	 * Initial Notch Position of Rotor two
	 */
	public static final int ROTOR_TWO_INITIAL_NOTCH_POSITION = 5;

	/**
	 * List of codes defines the initial position of Rotor three (Right Rotor)
	 */
	public static final String[] ROTOR_THREE_CODES = { "MO", "NW", "OY", "PH", "QX", "RU", "SS", "TP", "UA", "VI", "WB",
			"XR", "YC", "ZJ", "AE", "BK", "CM", "DF", "EL", "FG", "GD", "HQ", "IV", "JZ", "KN", "LT" };

	/**
	 * Initial position of notch on Rotor three
	 */
	public static final int ROTOR_THREE_INITIAL_NOTCH_POSITION = 17;

	/**
	 * indicates the left direction during encoding i.e. encoding is happening from right to left 
	 */
	public static final String TOWARDS_LEFT = "toLeft";
	
	/**
	 * indicates the right direction during encoding i.e. encoding is happening from right to left 
	 */
	public static final String TOWARDS_RIGHT = "toRight";


	/**
	 * indicates last position of notch on rotor
	 */
	public static final int LAST_NOTCH_POSITION = 26;

	/**
	 * indicates the first position 
	 */
	public static final int FIRST_INDEX = 1;

	/**
	 * used for splitting multiple space separated words
	 */
	public static final String STRING_SEPERATOR = " ";
	
	/**
	 * first index
	 */
	public static final int ZERO_INDEX = 0;

}
