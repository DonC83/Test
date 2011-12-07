package com.autochartist.web.aclite.client.model;

import java.io.Serializable;


public class ChartPatternSearchResult extends PatternSearchResult implements Serializable {

    private double resy0;
    private double resy1;
    private double supporty0;
    private double supporty1;
    private String predictionTimeTo;
    private String resx0;
    private String resx1;
    private String supportx0;
    private String supportx1;
    private String pattern;
    private String trendchange;
    private int length;
    private double quality;
    private String qualityString;
    private double initialtrend;
    private double volume;
    private double uniformity;
    private double predictionPriceFrom;
    private double predictionPriceTo;
    private double clarity;
    private double breakout;
    private String initialtrendImage;
    private String uniformityImage;
    private String clarityImage;
    private String volumeImage;
    private String breakoutImage;
    private String directionImage;


    public ChartPatternSearchResult() {
        super();
    }


    public ChartPatternSearchResult(int patternid, double resy0, double resy1,
                                    double supporty0, double supporty1, String predictionTimeTo,
                                    int symbolid, String symbol, String longName, String shortName, int granularity,
                                    String patternEndTime, String patternStartTime,
                                    String resx0, String resx1, String supportx0,
                                    String supportx1, String pattern, int direction,
                                    String trendchange, int length, double quality, long resultuid,
                                    boolean complete, double initialtrend, double volume,
                                    double uniformity, double predictionPriceFrom,
                                    double predictionPriceTo, double clarity, double breakout,
                                    String exchange, String qualityImage,
                                    String initialtrendImage, String uniformityImage,
                                    String clarityImage, String volumeImage, String breakoutImage,
                                    String directionImage, boolean isNew) {
        super();
        this.patternid = patternid;
        this.resy0 = resy0;
        this.resy1 = resy1;
        this.supporty0 = supporty0;
        this.supporty1 = supporty1;
        this.predictionTimeTo = predictionTimeTo;
        this.symbolid = symbolid;
        this.symbol = symbol;
        this.shortName = shortName;
        this.longName = longName;
        this.granularity = granularity;
        this.patternEndTime = patternEndTime;
        this.patternStartTime = patternStartTime;
        this.resx0 = resx0;
        this.resx1 = resx1;
        this.supportx0 = supportx0;
        this.supportx1 = supportx1;
        this.pattern = pattern;
        this.direction = direction;
        this.trendchange = trendchange;
        this.length = length;
        this.quality = quality;
        this.resultuid = resultuid;
        this.complete = complete;
        this.initialtrend = initialtrend;
        this.volume = volume;
        this.uniformity = uniformity;
        this.predictionPriceFrom = predictionPriceFrom;
        this.predictionPriceTo = predictionPriceTo;
        this.clarity = clarity;
        this.breakout = breakout;
        this.exchange = exchange;
        this.qualityImage = qualityImage;
        this.initialtrendImage = initialtrendImage;
        this.uniformityImage = uniformityImage;
        this.clarityImage = clarityImage;
        this.volumeImage = volumeImage;
        this.breakoutImage = breakoutImage;
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

    public double getResy0() {
        return resy0;
    }

    public void setResy0(double resy0) {
        this.resy0 = resy0;
    }

    public double getResy1() {
        return resy1;
    }

    public void setResy1(double resy1) {
        this.resy1 = resy1;
    }

    public double getSupporty0() {
        return supporty0;
    }

    public void setSupporty0(double supporty0) {
        this.supporty0 = supporty0;
    }

    public double getSupporty1() {
        return supporty1;
    }

    public void setSupporty1(double supporty1) {
        this.supporty1 = supporty1;
    }

    public String getPredictionTimeTo() {
        return predictionTimeTo;
    }

    public void setPredictionTimeTo(String predictionTimeTo) {
        this.predictionTimeTo = predictionTimeTo;
    }

    public String getResx0() {
        return resx0;
    }

    public void setResx0(String resx0) {
        this.resx0 = resx0;
    }

    public String getResx1() {
        return resx1;
    }

    public void setResx1(String resx1) {
        this.resx1 = resx1;
    }

    public String getSupportx0() {
        return supportx0;
    }

    public void setSupportx0(String supportx0) {
        this.supportx0 = supportx0;
    }

    public String getSupportx1() {
        return supportx1;
    }

    public void setSupportx1(String supportx1) {
        this.supportx1 = supportx1;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getTrendchange() {
        return trendchange;
    }

    public void setTrendchange(String trendchange) {
        this.trendchange = trendchange;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getInitialtrend() {
        return initialtrend;
    }

    public void setInitialtrend(double initialtrend) {
        this.initialtrend = initialtrend;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getUniformity() {
        return uniformity;
    }

    public void setUniformity(double uniformity) {
        this.uniformity = uniformity;
    }

    public double getPredictionPriceFrom() {
        return predictionPriceFrom;
    }

    public void setPredictionPriceFrom(double predictionPriceFrom) {
        this.predictionPriceFrom = predictionPriceFrom;
    }

    public double getPredictionPriceTo() {
        return predictionPriceTo;
    }

    public void setPredictionPriceTo(double predictionPriceTo) {
        this.predictionPriceTo = predictionPriceTo;
    }

    public double getClarity() {
        return clarity;
    }

    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    public double getBreakout() {
        return breakout;
    }

    public void setBreakout(double breakout) {
        this.breakout = breakout;
    }

    public String getInitialtrendImage() {
        return initialtrendImage;
    }

    public void setInitialtrendImage(String initialtrendImage) {
        this.initialtrendImage = initialtrendImage;
    }

    public String getUniformityImage() {
        return uniformityImage;
    }

    public void setUniformityImage(String uniformityImage) {
        this.uniformityImage = uniformityImage;
    }

    public String getClarityImage() {
        return clarityImage;
    }

    public void setClarityImage(String clarityImage) {
        this.clarityImage = clarityImage;
    }

    public String getVolumeImage() {
        return volumeImage;
    }

    public void setVolumeImage(String volumeImage) {
        this.volumeImage = volumeImage;
    }

    public String getBreakoutImage() {
        return breakoutImage;
    }

    public void setBreakoutImage(String breakoutImage) {
        this.breakoutImage = breakoutImage;
    }

    public String getDirectionImage() {
        return directionImage;
    }

    public void setDirectionImage(String directionImage) {
        this.directionImage = directionImage;
    }

    public String getQualityString() {
        return qualityString;
    }


    public void setQualityString(String qualityString) {
        this.qualityString = qualityString;
    }


}
