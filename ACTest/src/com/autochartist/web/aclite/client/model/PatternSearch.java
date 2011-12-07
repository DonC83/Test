package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatternSearch implements Serializable {

    public static Integer GENERIC_PATTERN_TYPE = -1; // Added GENERIC_PATTERN_TYPE to search all pattern types. - RL 8/10/2011
    public static Integer CHART_PATTERN_TYPE = 0;
    public static Integer FIBONACCI_PATTERN_TYPE = 1;
    public static Integer HRS_PATTERN_TYPE = 2;

    public static Integer GROUP_SEARCH_TYPE = 1;
    public static Integer SYMBOL_SEARCH_TYPE = 3;

    private Integer type;
    private Long id = -1l;
    private String description;
    private String searchString;
    private int rowInFlexTable;

    private int searchtype = -1;
    private int groupid = -1;
    private String symbol = "";
    private int direction;
    private int length;
    private long patternid;

    private int trendchange;
    private double clarity;
    private double uniformity;
    private double initialtrend;
    private double breakout;
    private double volume;
    private double quality;

    private double minTimeSymmetry;
    private double minPriceSymmetry;

    private double minPrice = -1;
    private double maxPrice = -1;
    
    private PatternSearch chartPatternSearch;
	private PatternSearch fibPatternSearch;
	private PatternSearch keyLevelsPatternSearch;

    public PatternSearch() {
        super();
    }

    public PatternSearch(int type, long id, String description) {
        super();
        this.type = type;
        this.id = id;
        this.description = description;

    }

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().length() == 0) {
            description = "New Search ";
        }
        this.description = description;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(int searchtype) {
        this.searchtype = searchtype;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public String getSymbol() {
        return symbol;
    }

    public List getSymbolsWithTimes() {
        List symbols = new ArrayList();
        String symbolString = symbol;
        int commaPos = symbolString.indexOf(",");
        while (commaPos > -1) {
            String token = symbolString.substring(0, commaPos);
            int semiColonPos = token.indexOf(";");
            String symbol = token.substring(0, semiColonPos);
            String time = token.substring(semiColonPos + 1);
            symbols.add(new Symbol(symbol, time));
            symbolString = symbolString.substring(commaPos + 1);
            commaPos = symbolString.indexOf(",");
        }
        return symbols;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getPatternid() {
        return patternid;
    }

    public void setPatternid(long patternid) {
        this.patternid = patternid;
    }

    public int getTrendchange() {
        return trendchange;
    }

    public void setTrendchange(int trendchange) {
        this.trendchange = trendchange;
    }

    public double getClarity() {
        return clarity;
    }

    public void setClarity(double clarity) {
        this.clarity = clarity;
    }

    public double getUniformity() {
        return uniformity;
    }

    public void setUniformity(double uniformity) {
        this.uniformity = uniformity;
    }

    public double getInitialtrend() {
        return initialtrend;
    }

    public void setInitialtrend(double initialtrend) {
        this.initialtrend = initialtrend;
    }

    public double getBreakout() {
        return breakout;
    }

    public void setBreakout(double breakout) {
        this.breakout = breakout;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }


    public double getMinTimeSymmetry() {
        return minTimeSymmetry;
    }

    public void setMinTimeSymmetry(double minTimeSymmetry) {
        this.minTimeSymmetry = minTimeSymmetry;
    }

    public double getMinPriceSymmetry() {
        return minPriceSymmetry;
    }

    public void setMinPriceSymmetry(double minPriceSymmetry) {
        this.minPriceSymmetry = minPriceSymmetry;
    }

    public int getRowInFlexTable() {
        return rowInFlexTable;
    }

    public void setRowInFlexTable(int rowInFlexTable) {
        this.rowInFlexTable = rowInFlexTable;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean equals(Object obj) {
    	String className = obj.getClass().getName();
        if ("com.autochartist.web.aclite.client.model.PatternSearch".equals(className)) {
        //if (obj instanceof PatternSearch) {        	
            PatternSearch ps = (PatternSearch)obj;
            if (ps.getId()==this.getId() && ps.getGroupid()==this.getGroupid() &&
                    ps.getPatternid()==this.getPatternid() && ps.getDescription().equals(this.getDescription())) {
                return true;
            }
        }
        return false;
    }
    
    public PatternSearch getChartPatternSearch() {
		return chartPatternSearch;
	}

	public void setChartPatternSearch(PatternSearch chartPatternSearch) {
		this.chartPatternSearch = chartPatternSearch;
	}

	public PatternSearch getFibPatternSearch() {
		return fibPatternSearch;
	}

	public void setFibPatternSearch(PatternSearch fibPatternSearch) {
		this.fibPatternSearch = fibPatternSearch;
	}

	public PatternSearch getKeyLevelsPatternSearch() {
		return keyLevelsPatternSearch;
	}

	public void setKeyLevelsPatternSearch(PatternSearch keyLevelsPatternSearch) {
		this.keyLevelsPatternSearch = keyLevelsPatternSearch;
	}
}
