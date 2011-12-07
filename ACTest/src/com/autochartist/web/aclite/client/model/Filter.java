package com.autochartist.web.aclite.client.model;

import java.io.Serializable;

// Filter object, to save client's selection of filters (completed/emerging, etc. on pattern types). - RL 27/10/2011

public class Filter implements Serializable {

	private long ID = -1;
	private String name;	
	private String clientId;
	private boolean showHistoricalPattern; 
	private boolean chartCompleted;
	private boolean chartEmerging;
	private boolean fibCompleted;
	private boolean fibEmerging;
	private boolean keyBreakout;
	private boolean keyApproach;		

	public Filter() {
		setName("Default");		
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}

	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param showHistoricalPattern the showHistoricalPattern to set
	 */
	public void setShowHistoricalPattern(boolean showHistoricalPattern) {
		this.showHistoricalPattern = showHistoricalPattern;
	}

	/**
	 * @return the showHistoricalPattern
	 */
	public boolean isShowHistoricalPattern() {
		return showHistoricalPattern;
	}

	/**
	 * @param chartCompleted the chartCompleted to set
	 */
	public void setChartCompleted(boolean chartCompleted) {
		this.chartCompleted = chartCompleted;
	}

	/**
	 * @return the chartCompleted
	 */
	public boolean isChartCompleted() {
		return chartCompleted;
	}

	/**
	 * @param chartEmerging the chartEmerging to set
	 */
	public void setChartEmerging(boolean chartEmerging) {
		this.chartEmerging = chartEmerging;
	}

	/**
	 * @return the chartEmerging
	 */
	public boolean isChartEmerging() {
		return chartEmerging;
	}

	/**
	 * @param fibCompleted the fibCompleted to set
	 */
	public void setFibCompleted(boolean fibCompleted) {
		this.fibCompleted = fibCompleted;
	}

	/**
	 * @return the fibCompleted
	 */
	public boolean isFibCompleted() {
		return fibCompleted;
	}

	/**
	 * @param fibEmerging the fibEmerging to set
	 */
	public void setFibEmerging(boolean fibEmerging) {
		this.fibEmerging = fibEmerging;
	}

	/**
	 * @return the fibEmerging
	 */
	public boolean isFibEmerging() {
		return fibEmerging;
	}

	/**
	 * @param keyBreakout the keyBreakout to set
	 */
	public void setKeyBreakout(boolean keyBreakout) {
		this.keyBreakout = keyBreakout;
	}

	/**
	 * @return the keyBreakout
	 */
	public boolean isKeyBreakout() {
		return keyBreakout;
	}

	/**
	 * @param keyApproach the keyApproach to set
	 */
	public void setKeyApproach(boolean keyApproach) {
		this.keyApproach = keyApproach;
	}

	/**
	 * @return the keyApproach
	 */
	public boolean isKeyApproach() {
		return keyApproach;
	}

	@Override
	public String toString() {
		return "Filter [ID = " + ID + ", clientId = " + clientId + ", name = " + name + ", showHistoricalPattern = " + showHistoricalPattern + ", " +
			"chartCompleted = " + chartCompleted + ", chartEmerging = " + chartEmerging + ", fibCompleted = " + fibCompleted + ", " +
			"fibEmerging = " + fibEmerging + ", keyBreakout = " + keyBreakout + ", keyApproach = " + keyApproach + "]";  				
	}
	
}


