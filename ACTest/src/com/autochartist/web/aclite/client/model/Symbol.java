package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;

import java.io.Serializable;

public class Symbol implements Serializable {

	private String symbol;
	private String timeGranularity;
	private int symbolId;
	private String longName;
	private Group group;

	public Symbol() {
		super();
	}

	public Symbol(String symbol, String timeGranularity) {
		super();
		this.symbol = symbol;
		this.timeGranularity = timeGranularity;
	}

	public Symbol(int symbolId, String symbol, String longName, Group group) {
		super();
		this.symbol = symbol;
		this.symbolId = symbolId;
		this.longName = longName;
		this.group = group;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTimeGranularity() {
		return timeGranularity;
	}

	public void setTimeGranularity(String timeGranularity) {
		this.timeGranularity = timeGranularity;
	}

	public int getSymbolId() {
		return symbolId;
	}

	public void setSymbolId(int symbolId) {
		this.symbolId = symbolId;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getSearchDisplayName(int brokerId) {
		if (brokerId == GlobalSettings.BROKER_MFGLOBAL_AUS || brokerId == GlobalSettings.BROKER_MFFUTURESSINGAPORE 
				|| brokerId == GlobalSettings.BROKER_CIMB_INDON
				|| brokerId == GlobalSettings.BROKER_EXCHANGEDEMO
				|| brokerId == GlobalSettings.BROKER_DEMO2012) {
			return group.getGroupName() + " | " + symbol + " | " + longName;
		} else if (brokerId == GlobalSettings.BROKER_IG) {
			return longName;
		} else {
			return symbol;
		}
	}

	public String getTreeDisplayName(int brokerId) {
		if (brokerId == GlobalSettings.BROKER_MFGLOBAL_AUS || brokerId == GlobalSettings.BROKER_MFFUTURESSINGAPORE
				|| brokerId == GlobalSettings.BROKER_CIMB_INDON
				|| brokerId == GlobalSettings.BROKER_EXCHANGEDEMO
				|| brokerId == GlobalSettings.BROKER_DEMO2012) {
			return symbol + ", " + longName;
		} else if (brokerId == GlobalSettings.BROKER_IG) {
			return longName;
		} else {
			return symbol;
		}
	}

}
