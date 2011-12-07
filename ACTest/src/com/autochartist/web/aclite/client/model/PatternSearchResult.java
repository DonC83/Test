package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.Date;
//import com.smartgwt.client.widgets.grid.ListGridRecord;

public abstract class PatternSearchResult implements Serializable {

	public long resultuid;
    public int relevant;
    		
	protected int granularity;
	protected String fileName;
    protected String longName;
    protected String shortName;
    protected String patternEndTime;
    protected Date patternEnd;
    protected String patternStartTime;
    protected int direction;
    protected String qualityImage;
    protected boolean isNew;
    protected long symbolid;
    protected String symbol;
    protected String exchange;
    protected boolean complete;
    protected int patternid;


    public PatternSearchResult() {
		super();
	}

    public abstract String getPattern();

    public abstract int getLength();

    public abstract double getQuality();

	
	public long getResultuid() {
		return resultuid;
	}
	
	public void setResultuid(long resultuid) {
		this.resultuid = resultuid;
	}
	
	public int getGranularity() {
		return granularity;
	}
	public void setGranularity(int granularity) {
		this.granularity = granularity;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPatternEndTime() {
        return patternEndTime;
    }

    public void setPatternEndTime(String patternEndTime) {
        this.patternEndTime = patternEndTime;
    }

    public Date getPatternEnd() {
        return patternEnd;
    }

    public void setPatternEnd(Date patternEnd) {
        this.patternEnd = patternEnd;
    }

    public String getPatternStartTime() {
        return patternStartTime;
    }

    public void setPatternStartTime(String patternStartTime) {
        this.patternStartTime = patternStartTime;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getQualityImage() {
        return qualityImage;
    }

    public void setQualityImage(String qualityImage) {
        this.qualityImage = qualityImage;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public long getSymbolid() {
        return symbolid;
    }

    public void setSymbolid(long symbolid) {
        this.symbolid = symbolid;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getPatternid() {
        return patternid;
    }

    public void setPatternid(int patternid) {
        this.patternid = patternid;
    }

    public Date getPatternEndTimeAsDate() {
		return patternEnd;
	}

	public void setPatternEndTimeAsDate(Date patternEnd) {
		this.patternEnd = patternEnd;
	}

	/**
	 * @param relevant value to set (0/1)
	 */
	public void setRelevant(int relevant) {
		this.relevant = relevant;
	}

	/**
	 * @return relevant (0/1)
	 */
	public int getRelevant() {
		return relevant;
	}

}
