package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class CPPattern implements Serializable {
	public int PatternID;
	public String PatternName;
	
	
	public CPPattern() {
		super();
	}


	public CPPattern(int patternid, String patternname) {
		PatternID = patternid;
		PatternName = patternname;
	}
	

	
}
