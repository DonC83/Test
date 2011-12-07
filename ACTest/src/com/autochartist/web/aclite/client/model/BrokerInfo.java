package com.autochartist.web.aclite.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class BrokerInfo implements Serializable, IsSerializable {
	
	private int brokerId;
	private String loginUrl;
	private String logoutUrl;	

	public BrokerInfo() {
		super();		
	}

	public BrokerInfo(int brokerId, String loginUrl, String logoutUrl) {
		super();
		this.brokerId = brokerId;
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;		
	}

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String toString() {
		return brokerId + "," + loginUrl + "," + logoutUrl;
	}
	
	public static BrokerInfo create(String brokerInfo) {		
		int indexOfComma = brokerInfo.indexOf(",");		
		String brokerId = brokerInfo.substring(0, indexOfComma);
		brokerInfo = brokerInfo.substring(indexOfComma + 1, brokerInfo.length());
		
		indexOfComma = brokerInfo.indexOf(",");
		String loginUrl = brokerInfo.substring(0, indexOfComma);
		brokerInfo = brokerInfo.substring(indexOfComma + 1, brokerInfo.length());
		
		String logoutUrl = brokerInfo;
		return new BrokerInfo(Integer.parseInt(brokerId), loginUrl, logoutUrl);
	}
	
	public static void main (String[] args) {
		BrokerInfo brokerInfo = new BrokerInfo(24,"in","out");
		System.out.println(BrokerInfo.create(brokerInfo.toString()).toString());
	}
}
