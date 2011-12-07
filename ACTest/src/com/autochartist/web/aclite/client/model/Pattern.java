package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class Pattern implements Serializable {
	public static int GENERIC_PATTERN_TYPE = -1;
	public static int CHART_PATTERN_TYPE = 0;
	public static int FIBONACCI_PATTERN_TYPE = 1;
	public static int HRS_PATTERN_TYPE = 2;
	
	private int type = CHART_PATTERN_TYPE;
	public int PatternID;
	public String PatternName;
	
	
	public Pattern() {
		super();
	}


	public Pattern(int patternid, String patternname) {
		PatternID = patternid;
		PatternName = patternname;
	}
	
	
	public Pattern(int type, int patternID, String patternName) {
		super();
		this.type = type;
		PatternID = patternID;
		PatternName = patternName;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	
	

	
}
