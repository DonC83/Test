package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.Date;

public class HRSPatternSearchResult extends PatternSearchResult implements Serializable {


    private double Bandwidth;

    private int Direction;
    private String patternName;

    private double PatternPrice;
    private double PredictionPriceFrom;
    private double PredictionPriceTo;

    private int QtyTP;
    private double priceE;
    private String timeE;

    private String averageQualityString;
    private int PatternLengthBars;
    private boolean TemporaryPattern;


    private long ResultUID;


    private String qualityImage;
    private String directionImage;

    private String PatternApproachTime;
    private Date PatternApproach;

    private int barsE;

    private String PatternIdentifiedTime;
    private Date PatternIdentifiedTimeAsDate;


    public HRSPatternSearchResult() {
        super();
    }

    public HRSPatternSearchResult(long resultuid, boolean complete,
			double bandwidth, int patternID, int direction, String patternName,
			String patternStartTime, String patternEndTime,
			double patternPrice, int qtyTP,
			double priceE, int barsE,
			int patternLengthBars, boolean temporaryPattern,
			long symbolID, long resultUID2,
			String symbol, String longName, String shortName, String exchange, int timeGranularity, String qualityImage,
			String directionImage, boolean isNew, double PredictionPriceFrom, double PredictionPriceTo) {

        super();
        this.resultuid = resultuid;
        this.complete = complete;
        Bandwidth = bandwidth;
        patternid = patternID;
        Direction = direction;
        this.patternName = patternName;
        this.patternStartTime = patternStartTime;
        this.patternEndTime = patternEndTime;
        PatternPrice = patternPrice;
        QtyTP = qtyTP;
        this.priceE = priceE;
//        this.timeE = timeE;
        this.barsE = barsE;
        PatternLengthBars = patternLengthBars;
        TemporaryPattern = temporaryPattern;
        this.symbolid = symbolID;
        ResultUID = resultUID2;
        this.symbol = symbol;
        this.longName = longName;
        this.shortName = shortName;
        this.exchange = exchange;
        this.granularity = timeGranularity;
        this.qualityImage = qualityImage;
        this.directionImage = directionImage;
        this.isNew = isNew;
        this.PredictionPriceFrom = PredictionPriceFrom;
        this.PredictionPriceTo = PredictionPriceTo;
    }

    @Deprecated
    public HRSPatternSearchResult(long resultuid, boolean complete,
                                  double bandwidth, int patternID, int direction, String patternName,
                                  String patternStartTime, String patternEndTime,
                                  double patternPrice, int qtyTP,
                                  double priceE, String timeE,
                                  int patternLengthBars, boolean temporaryPattern,
                                  long symbolID, long resultUID2,
                                  String symbol, String longName, String shortName, String exchange, int timeGranularity, String qualityImage,
                                  String directionImage, boolean isNew) {
        super();
        this.resultuid = resultuid;
        this.complete = complete;
        Bandwidth = bandwidth;
        patternid = patternID;
        Direction = direction;
        this.patternName = patternName;
        this.patternStartTime = patternStartTime;
        this.patternEndTime = patternEndTime;
        PatternPrice = patternPrice;
        QtyTP = qtyTP;
        this.priceE = priceE;
        this.timeE = timeE;
        PatternLengthBars = patternLengthBars;
        TemporaryPattern = temporaryPattern;
        this.symbolid = symbolID;
        ResultUID = resultUID2;
        this.symbol = symbol;
        this.longName = longName;
        this.shortName = shortName;
        this.exchange = exchange;
        this.granularity = timeGranularity;
        this.qualityImage = qualityImage;
        this.directionImage = directionImage;
        this.isNew = isNew;
    }


    public String GenerateStrengthFilename(String prefix, double Strength) {

        String filename = prefix;

        if (Strength <= 0.0)
            filename = filename + "1.PNG";
        else if (Strength <= 0.1)
            filename = filename + "1.PNG";
        else if (Strength <= 0.2)
            filename = filename + "2.PNG";
        else if (Strength <= 0.3)
            filename = filename + "3.PNG";
        else if (Strength <= 0.4)
            filename = filename + "4.PNG";
        else if (Strength <= 0.5)
            filename = filename + "5.PNG";
        else if (Strength <= 0.6)
            filename = filename + "6.PNG";
        else if (Strength <= 0.7)
            filename = filename + "7.PNG";
        else if (Strength <= 0.8)
            filename = filename + "8.PNG";
        else if (Strength <= 0.9)
            filename = filename + "9.PNG";
        else
            filename = filename + "10.PNG";

        return filename;

    }

    public double getBandwidth() {
        return Bandwidth;
    }


    public void setBandwidth(double bandwidth) {
        Bandwidth = bandwidth;
    }


    public int getDirection() {
        return Direction;
    }


    public void setDirection(int direction) {
        Direction = direction;
    }


    public String getPattern() {
        return patternName;
    }

    public String getPatternName() {
        return patternName;
    }


    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }


    public double getPatternPrice() {
        return PatternPrice;
    }


    public void setPatternPrice(double patternPrice) {
        PatternPrice = patternPrice;
    }


    public int getQtyTP() {
        return QtyTP;
    }

    public double getQtyTPAsDouble() {
        Double qty = new Double(QtyTP);
        return qty.doubleValue();
    }

    public void setQtyTP(int qtyTP) {
        QtyTP = qtyTP;
    }


    public double getpriceE() {
        return priceE;
    }


    public void setpriceE(double priceE) {
        this.priceE = priceE;
    }


    public String gettimeE() {
        return timeE;
    }


    public void settimeE(String timeE) {
        this.timeE = timeE;
    }


    public int getPatternLengthBars() {
        return PatternLengthBars;
    }


    public void setPatternLengthBars(int patternLengthBars) {
        PatternLengthBars = patternLengthBars;
    }


    public boolean isTemporaryPattern() {
        return TemporaryPattern;
    }


    public void setTemporaryPattern(boolean temporaryPattern) {
        TemporaryPattern = temporaryPattern;
    }


    public long getResultUID() {
        return ResultUID;
    }


    public void setResultUID(long resultUID) {
        ResultUID = resultUID;
    }

    public String getQualityImage() {
        return qualityImage;
    }


    public void setQualityImage(String qualityImage) {
        this.qualityImage = qualityImage;
    }


    public String getDirectionImage() {
        return directionImage;
    }


    public void setDirectionImage(String directionImage) {
        this.directionImage = directionImage;
    }


    public String getAverageQualityString() {
        return averageQualityString;
    }


    public void setAverageQualityString(String averageQualityString) {
        this.averageQualityString = averageQualityString;
    }


    @Override
    public int getLength() {
        return getPatternLengthBars();
    }


    @Override
    public double getQuality() {
        return getQtyTPAsDouble() / 10;
    }


    public void setApproachTime(String approachTime) {
		PatternApproachTime = approachTime;
	}

	public String getApproachTime() {
		return PatternApproachTime;
	}

    public void setApproach(Date approachTime) {
		PatternApproach = approachTime;
	}

	public Date getApproachTimeAsDate() {
		return PatternApproach;
	}

    public int getBarsE() {
        return barsE;
    }

    public void setBarsE(int barsE) {
        this.barsE = barsE;
    }

    public String getPatternIdentifiedTime() {
        return PatternIdentifiedTime;
    }
    
    public String getPatternEndTime() {
    	if (!isComplete()) return PatternApproachTime;
    	else return PatternIdentifiedTime;
    		
    	//return patternEndTime;
    }

    public Date getPatternEndTimeAsDate() {
    	if (!isComplete()) return PatternApproach;
    	else return PatternIdentifiedTimeAsDate;
    		
    	//return patternEndTime;
    }    
    
    public void setPatternIdentifiedTime(String patternIdentifiedTime) {
        PatternIdentifiedTime = patternIdentifiedTime;
    }

    public Date getPatternIdentifiedTimeAsDate() {
        return PatternIdentifiedTimeAsDate;
    }

    public void setPatternIdentifiedTimeAsDate(Date patternIdentifiedTimeAsDate) {
        PatternIdentifiedTimeAsDate = patternIdentifiedTimeAsDate;
    }
    
    public double getPredictionPriceFrom() {
        return PredictionPriceFrom;
    }
    
    public double getPredictionPriceTo() {
        return PredictionPriceTo;
    }
}
