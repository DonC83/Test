package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.ACConstants;

import java.io.Serializable;
import java.util.TreeMap;

public class TimeGranularityMap extends TreeMap<Integer, String> implements Serializable {
	
	public TimeGranularityMap(ACConstants constants) {
		super();				
		put(0, constants.Intraday()); // This actually returns all results, 
								      // we should get translations for the word "All" 
		                              // and then change it  
		put(15, "15 " + constants.Min());
		put(30, "30 " + constants.Min());
		put(60, "60 " + constants.Min());
		put(240, "240 " + constants.Min());
		put(1440, constants.Daily());
	}
}
