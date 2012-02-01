package scollPanelEx.client;

import com.google.gwt.user.client.ui.Image;

/**
 * The source, with you may it be old master
 * Date: 2011/11/22
 */
public class Patterns {

    private String alert;

    private String exchange;

    private String symbol;

    private String direction;

    private Integer interval;

    private String pattern;

    private String identified;

    private String length;

    private Integer quality;

    private String type;

    private String hidden1;

    private String hidden2;

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getIdentified() {
        return identified;
    }

    public void setIdentified(String identified) {
        this.identified = identified;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHidden1() {
        return hidden1;
    }

    public void setHidden1(String hidden1) {
        this.hidden1 = hidden1;
    }

    public String getHidden2() {
        return hidden2;
    }

    public void setHidden2(String hidden2) {
        this.hidden2 = hidden2;
    }

    public String toString() {
        return getAlert() + "; " + getExchange() + "; " + getSymbol() + "; " +
                getDirection() + "; " + getPattern() + "; " + getInterval() + "; " +
                getLength() + "; " + getQuality() + "; " + getType() + "; " + getHidden1() + "; " +
                getHidden2();
    }
}
