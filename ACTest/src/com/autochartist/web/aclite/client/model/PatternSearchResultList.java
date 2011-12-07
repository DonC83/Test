package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.HashMap;
//                                                 resultuid, result
public class PatternSearchResultList extends HashMap<Long, PatternSearchResult> implements Serializable {
	
	public static Integer EMERGING_TYPE = 0;
	public static Integer COMPLETED_TYPE = 1;
	public static Integer APPROACHING_TYPE = 2;

	private int type;
	
	private PatternSearch patternSearch;
	
	public PatternSearchResultList() {
		super();
	}

	public PatternSearchResultList(int type, PatternSearch patternSearch) {
		super();
		this.type = type;
		this.patternSearch = patternSearch;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public PatternSearch getPatternSearch() {
		return patternSearch;
	}

	public void setPatternSearch(PatternSearch patternSearch) {
		this.patternSearch = patternSearch;
	}	
}
