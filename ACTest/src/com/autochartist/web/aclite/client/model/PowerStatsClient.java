package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class PowerStatsClient implements Serializable {
	
	private String pageName;
	private String symbolName;
	
	private String fileNamePNG;
	private String fileNameCSV;
	
	private ArrayList<String> currencies;
	private String description;
	
	private String defaultsamplesize = "6 Months";
	private int defaultinterval = 1440;
	
	private String timeZone = "Eastern Standard Time (EST)";
	
	private int PowerStatsID;
	private Date ExecutionDateTime;
	private int BrokerID;
	private String SampleSize;
	
	private ArrayList<String> symbols;
	
	private String defaultSymbol;
	
	private ArrayList<DisplayPage> pages;
	
	private DisplayPage page;

	public PowerStatsClient() {
		super();
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getSymbolName() {
		return symbolName;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}

	public String getFileNamePNG() {
		return fileNamePNG;
	}

	public void setFileNamePNG(String fileNamePNG) {
		this.fileNamePNG = fileNamePNG;
	}

	public String getFileNameCSV() {
		return fileNameCSV;
	}

	public void setFileNameCSV(String fileNameCSV) {
		this.fileNameCSV = fileNameCSV;
	}

	public ArrayList<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(ArrayList<String> currencies) {
		this.currencies = currencies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefaultsamplesize() {
		return defaultsamplesize;
	}

	public void setDefaultsamplesize(String defaultsamplesize) {
		this.defaultsamplesize = defaultsamplesize;
	}

	public int getDefaultinterval() {
		return defaultinterval;
	}

	public void setDefaultinterval(int defaultinterval) {
		this.defaultinterval = defaultinterval;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getPowerStatsID() {
		return PowerStatsID;
	}

	public void setPowerStatsID(int powerStatsID) {
		PowerStatsID = powerStatsID;
	}

	public Date getExecutionDateTime() {
		return ExecutionDateTime;
	}

	public void setExecutionDateTime(Date executionDateTime) {
		ExecutionDateTime = executionDateTime;
	}

	public int getBrokerID() {
		return BrokerID;
	}

	public void setBrokerID(int brokerID) {
		BrokerID = brokerID;
	}

	public String getSampleSize() {
		return SampleSize;
	}

	public void setSampleSize(String sampleSize) {
		SampleSize = sampleSize;
	}

	public ArrayList<String> getSymbols() {
		return symbols;
	}

	public void setSymbols(ArrayList<String> symbols) {
		this.symbols = symbols;
	}

	public String getDefaultSymbol() {
		return defaultSymbol;
	}

	public void setDefaultSymbol(String defaultSymbol) {
		this.defaultSymbol = defaultSymbol;
	}

	public ArrayList<DisplayPage> getPages() {
		return pages;
	}

	public void setPages(ArrayList<DisplayPage> pages) {
		this.pages = pages;
	}

	public DisplayPage getPage() {
		return page;
	}

	public void setPage(DisplayPage page) {
		this.page = page;
	}
	
	
	
	
	
	
}
