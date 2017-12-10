package com.utils;

/**
 * Class helps in restriction of choosing the flow direction
 * while encoding and decoding
 * @author chitesh
 *
 */
public enum FlowDirection {
	
	TO_LEFT("toLeft"),
	TO_RIGHT("toRight");
	
	private String value;
	
	private FlowDirection(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
