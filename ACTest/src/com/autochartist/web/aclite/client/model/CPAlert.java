package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class CPAlert implements Serializable {

	public long SearchID;
	public String Description;
	public int Complete;
	public int Emerging;
	public int Approaching;
	public int type;
	public static final int CP_TYPE = 0;
	public static final int FIB_TYPE = 1;
	public static final int HRS_TYPE = 2;
	
	public CPAlert() {
		super();	
	}

	public CPAlert(long searchid, String descr, int complete, int emerging, int approaching, int type) {
		
		SearchID = searchid;
		Description = descr;
		Complete = complete;
		Emerging = emerging;
		Approaching = approaching;
		this.type = type;
		
	}
	
}
