package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.ArrayList;


public class DisplayPage implements Serializable {
	
	public final static int displayNone = 0;
	public final static int displaySymbolList = 1; 
	public final static int displayHourList = 2; 
	public final static int displayWeekdayList = 4; 
	public final static int displayIntervalList = 8; 
	public final static int displayBarList = 16; 
	
	private String PageCode;
	private String DisplayName;
	private int Display;
	private ArrayList<Legend> Legends;
	private ArrayList<DisplayPage> SubPages;
	private DisplayPage Parent;
	
	
	
	public DisplayPage() {
		super();
	}

	public DisplayPage(DisplayPage parent, String pageCode, String displayName, int display) {
		PageCode = pageCode;
		DisplayName = displayName;
		Display = display;
		Legends = new ArrayList<Legend>();
		SubPages = new ArrayList<DisplayPage>();
		Parent = parent;
	}

	public boolean hasSubPages() {
		return SubPages.size() > 0;
	}
	
	public ArrayList<DisplayPage> getSubPages() {
		return SubPages;
	}
	
	public void addSubPage(DisplayPage p) {
		SubPages.add(p);
	}

	public DisplayPage getParent() {
		return Parent;
	}
	
	public String getPageCode() {
		return PageCode;
	}
	
	public String getDisplayName() {
		return DisplayName;
	}

	public boolean getDisplayBarList() {
		return (Display & displayBarList) > 0;
	}
	
	public boolean getDisplayIntervalList() {
		return (Display & displayIntervalList) > 0;
	}
	
	public boolean getDisplaySymbolList() {
		return (Display & displaySymbolList) > 0;
	}
	
	public boolean getDisplayHourList() {
		return (Display & displayHourList) > 0;
	}
	
	public boolean getDisplayWeekdayList() {
		return (Display & displayWeekdayList) > 0;
	}
	
	public ArrayList<Legend> getLegends() {
		return Legends;
	}

	public void addLegend(Legend l) {
		Legends.add(l);
	}
	
	public String getDescriptionVM() {
		return getPageCode()+".vm";
	}
}
