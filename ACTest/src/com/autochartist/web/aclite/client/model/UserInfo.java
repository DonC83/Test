package com.autochartist.web.aclite.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable, IsSerializable {
	
	private static final long serialVersionUID = -9096294944746238547L;
	private String userName;
	private String encryptedPassword;
	private BrokerInfo brokerInfo;
	private String siteIdFromIG = "";
	private String locale;
	private Date disclaimerAcknowledgeDate;
	private Float timezoneoffset = new Float(1000f);
	private String timezone;
	public Boolean inDayLightSavingsTime;

	private Filter filter;
	
	public UserInfo() {
		super();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public BrokerInfo getBrokerInfo() {
		return brokerInfo;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getLocale() {
		return locale;
	}


	public void setBrokerInfo(BrokerInfo brokerInfo) {
		this.brokerInfo = brokerInfo;
	}


	public String getSiteIdFromIG() {
		return siteIdFromIG;
	}


	public void setSiteIdFromIG(String siteIdFromIG) {
		this.siteIdFromIG = siteIdFromIG;
	}


	public Date getDisclaimerAcknowledgeDate() {
		return disclaimerAcknowledgeDate;
	}


	public void setDisclaimerAcknowledgeDate(Date disclaimerAcknowledgeDate) {
		this.disclaimerAcknowledgeDate = disclaimerAcknowledgeDate;
	}
	
	public Float getTimeZoneOffSet() {
		return this.timezoneoffset; 
	}
	
	public void setTimeZoneOffSet(float timezone) {
		this.timezoneoffset = new Float(timezone); 
	}
	
	public String getTimeZone() {
		return this.timezone; 
	}
	
	public void setTimeZone(String timezone) {
		this.timezone = timezone;
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String password) {
		this.encryptedPassword = password;
	}

	public String toString() {
		return /*disclaimerAcknowledgeDate + "," + */inDayLightSavingsTime
				+ "," + locale + "," + siteIdFromIG + "," + timezone + ","
				+ timezoneoffset + "," + userName + "," + encryptedPassword + "," + brokerInfo.toString() ;
	}

	public static UserInfo create(String userInfoString) {
		//userInfoString = URL.decode(userInfoString);

		int indexOfComma = userInfoString.indexOf(",");
		String inDaylightSavingsString = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String localeString = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String siteIdFromIgString = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String timezoneString = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String timezoneOffsetString = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String userNameStr = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		indexOfComma = userInfoString.indexOf(",");
		String passwdStr = userInfoString.substring(0, indexOfComma);
		userInfoString = userInfoString.substring(indexOfComma + 1, userInfoString.length());

		BrokerInfo brokerInfo = BrokerInfo.create(userInfoString);

		UserInfo userInfo = new UserInfo();
		userInfo.setLocale(localeString);
		userInfo.setSiteIdFromIG(siteIdFromIgString);
		userInfo.setTimeZone(timezoneString);
		userInfo.setTimeZoneOffSet(Float.parseFloat(timezoneOffsetString));
		userInfo.setUserName(userNameStr);
		userInfo.setBrokerInfo(brokerInfo);
		userInfo.setEncryptedPassword(passwdStr);
		
		return userInfo;
		
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(create("false%2Cen_GB%2C%2Cdefault%2C1000%2C800033%2Cnull%2C62%2C%2Fjsp%2FHYInvestmentLogin.jsp%2C%2FWebLogout%3FloginUrl%3D%2Fjsp%2FHYInvestmentLogin.jsp"));
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	/**
	 * @return the filter
	 */
	public Filter getFilter() {
		return filter;
	}
	
}
