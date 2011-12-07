package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class Legend implements Serializable {

	private String Color;
	private String Description;
	
	
	
	public Legend() {
		super();
	}
	
	public Legend(String color, String description) {
		Color = color;
		Description = description;
	}
	
	public String getColor() {
		return Color;
	}
	
	public String getDescription() {
		return Description;
	}
	
	
}
