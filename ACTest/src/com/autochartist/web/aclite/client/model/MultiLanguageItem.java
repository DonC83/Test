package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

public class MultiLanguageItem implements Serializable {
	
	private String prefix;
	private String description;
	private String localeCode;
	private String flagImageLocation;
	
	public MultiLanguageItem() {
		super();
	}

	public MultiLanguageItem(String prefix, String description, String localeCode,
			String flagImageLocation) {
		super();
		this.prefix = prefix;
		this.description = description;
		this.localeCode = localeCode;
		this.flagImageLocation = flagImageLocation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String sescription) {
		this.description = sescription;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public String getFlagImageLocation() {
		return flagImageLocation;
	}

	public void setFlagImageLocation(String flagImageLocation) {
		this.flagImageLocation = flagImageLocation;
	}
	
	public String getURL(int userBrokerID) {
		if (userBrokerID > 0) {
			return "<a href='" + prefix + "/ACLite.html?locale=" + localeCode
					+ "&broker=" + userBrokerID + "'><img src='" + prefix
					+ flagImageLocation + "' border='0'/></a><img src='"
					+ prefix + "/icons/spacer.gif"
					+ "' border='0' width='3px' height='13px' />";
		} else {
			return "<a href='" + prefix + "/ACLite.html?locale=" + localeCode
			+ "'><img src='" + prefix
			+ flagImageLocation + "' border='0'/></a><img src='"
			+ prefix + "/icons/spacer.gif"
			+ "' border='0' width='3px' height='13px' />";
		}
	}
	

}
