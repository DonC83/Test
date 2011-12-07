package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.Date;

public class FibonacciPatternSearchResult extends PatternSearchResult implements Serializable {


    private double Bandwidth;
    private int Direction;
    private String patternName;


    private double PatternStartPrice;
    private double PatternEndPrice;

    private int QtyTP;
    private double priceX;
    private String timeX;
    private double priceA;
    private String timeA;
    private double priceB;
    private String timeB;
    private double priceC;
    private String timeC;
    private double priceD;
    private String timeD;

    private double averageQuality;
    private String averageQualityString;
    private double timeQuality;
    private double ratioQuality;
    private double clarity;
    private int PatternLengthBars;
    private boolean TemporaryPattern;

    private double target10;
    private double target16;
    private double target06;
    private double target12;
    private double target07;
    private double target03;
    private double target05;


    private long ResultUID;


    private String qualityImage;
    private String timeSymmetryImage;
    private String priceSymmetryImage;
    private String clarityImage;
    private String directionImage;


    public FibonacciPatternSearchResult() {
        super();
    }

    public FibonacciPatternSearchResult(long resultuid, boolean complete,
			double bandwidth, int patternID, int direction, String patternName,
			String patternStartTime, String patternEndTime,
			double patternStartPrice, double patternEndPrice, int qtyTP,
			double priceX, String timeX, double priceA, String timeA,
			double priceB, String timeB, double priceC, String timeC,
			double priceD, String timeD, double averageQuality,
			double timeQuality, double ratioQuality, double clarity,
			int patternLengthBars, boolean temporaryPattern, double target10,
			double target16, double target06, double target12, double target07,
			double target03, double target05, long symbolID, long resultUID2,
			String symbol, String longName, String shortName, String exchange, int timeGranularity, String qualityImage,
			String timeSymmetryImage, String priceSymmetryImage,
			String clarityImage, String directionImage, boolean isNew) {

        super();
        this.resultuid = resultuid;
        this.complete = complete;
        Bandwidth = bandwidth;
        patternid = patternID;
        Direction = direction;
        this.patternName = patternName;
        this.patternStartTime = patternStartTime;
        this.patternEndTime = patternEndTime;
        PatternStartPrice = patternStartPrice;
        PatternEndPrice = patternEndPrice;
        QtyTP = qtyTP;
        this.priceX = priceX;
        this.timeX = timeX;
        this.priceA = priceA;
        this.timeA = timeA;
        this.priceB = priceB;
        this.timeB = timeB;
        this.priceC = priceC;
        this.timeC = timeC;
        this.priceD = priceD;
        this.timeD = timeD;
        this.averageQuality = averageQuality;
        this.timeQuality = timeQuality;
        this.ratioQuality = ratioQuality;
        this.clarity = clarity;
        PatternLengthBars = patternLengthBars;
        TemporaryPattern = temporaryPattern;
        this.target10 = target10;
        this.target16 = target16;
        this.target06 = target06;
        this.target12 = target12;
        this.target07 = target07;
        this.target03 = target03;
        this.target05 = target05;
        this.symbolid = symbolID;
        ResultUID = resultUID2;
        this.symbol = symbol;
        this.longName = longName;
        this.shortName = shortName;
        this.exchange = exchange;
        this.granularity = timeGranularity;
        this.qualityImage = qualityImage;
        this.timeSymmetryImage = timeSymmetryImage;
        this.priceSymmetryImage = priceSymmetryImage;
        this.clarityImage = clarityImage;
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


    public double getPatternStartPrice() {
        return PatternStartPrice;
    }


    public void setPatternStartPrice(double patternStartPrice) {
        PatternStartPrice = patternStartPrice;
    }


    public double getPatternEndPrice() {
        return PatternEndPrice;
    }


    public void setPatternEndPrice(double patternEndPrice) {
        PatternEndPrice = patternEndPrice;
    }


    public int getQtyTP() {
        return QtyTP;
    }


    public void setQtyTP(int qtyTP) {
        QtyTP = qtyTP;
    }


    public double getPriceX() {
        return priceX;
    }


    public void setPriceX(double priceX) {
        this.priceX = priceX;
    }


    public String getTimeX() {
        return timeX;
    }


    public void setTimeX(String timeX) {
        this.timeX = timeX;
    }


    public double getPriceA() {
        return priceA;
    }


    public void setPriceA(double priceA) {
        this.priceA = priceA;
    }


    public String getTimeA() {
        return timeA;
    }


    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }


    public double getPriceB() {
        return priceB;
    }


    public void setPriceB(double priceB) {
        this.priceB = priceB;
    }


    public String getTimeB() {
        return timeB;
    }


    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }


    public double getPriceC() {
        return priceC;
    }


    public void setPriceC(double priceC) {
        this.priceC = priceC;
    }


    public String getTimeC() {
        return timeC;
    }


    public void setTimeC(String timeC) {
        this.timeC = timeC;
    }


    public double getPriceD() {
        return priceD;
    }


    public void setPriceD(double priceD) {
        this.priceD = priceD;
    }


    public String getTimeD() {
        return timeD;
    }


    public void setTimeD(String timeD) {
        this.timeD = timeD;
    }


    public double getAverageQuality() {
        return averageQuality;
    }


    public void setAverageQuality(double averageQuality) {
        this.averageQuality = averageQuality;
    }


    public double getTimeQuality() {
        return timeQuality;
    }


    public void setTimeQuality(double timeQuality) {
        this.timeQuality = timeQuality;
    }


    public double getRatioQuality() {
        return ratioQuality;
    }


    public void setRatioQuality(double ratioQuality) {
        this.ratioQuality = ratioQuality;
    }


    public double getClarity() {
        return clarity;
    }


    public void setClarity(double clarity) {
        this.clarity = clarity;
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


    public double getTarget10() {
        return target10;
    }


    public void setTarget10(double target10) {
        this.target10 = target10;
    }


    public double getTarget16() {
        return target16;
    }


    public void setTarget16(double target16) {
        this.target16 = target16;
    }


    public double getTarget06() {
        return target06;
    }


    public void setTarget06(double target06) {
        this.target06 = target06;
    }


    public double getTarget12() {
        return target12;
    }


    public void setTarget12(double target12) {
        this.target12 = target12;
    }


    public double getTarget07() {
        return target07;
    }


    public void setTarget07(double target07) {
        this.target07 = target07;
    }


    public double getTarget03() {
        return target03;
    }


    public void setTarget03(double target03) {
        this.target03 = target03;
    }


    public double getTarget05() {
        return target05;
    }


    public void setTarget05(double target05) {
        this.target05 = target05;
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


    public String getTimeSymmetryImage() {
        return timeSymmetryImage;
    }


    public void setTimeSymmetryImage(String timeSymmetryImage) {
        this.timeSymmetryImage = timeSymmetryImage;
    }


    public String getPriceSymmetryImage() {
        return priceSymmetryImage;
    }


    public void setPriceSymmetryImage(String priceSymmetryImage) {
        this.priceSymmetryImage = priceSymmetryImage;
    }


    public String getClarityImage() {
        return clarityImage;
    }


    public void setClarityImage(String clarityImage) {
        this.clarityImage = clarityImage;
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
        return PatternLengthBars;
    }


    @Override
    public double getQuality() {
        return averageQuality;
    }



}
