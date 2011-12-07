package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SymbolSuggestionHelper implements Serializable {
	
	//           broker      locale    suggestions
	private Map<Integer, Map<String,MultiWordSuggestOracle>> suggestionMap = new HashMap<Integer, Map<String, MultiWordSuggestOracle>>();
	
	private String localeCode; 
	private int brokerId;
	
	//todo - make this dynamic from a SQL query!
	public SymbolSuggestionHelper(String localeCode, int brokerId) {
		super();		
		this.localeCode = localeCode;
		this.brokerId = brokerId;
		if (brokerId == GlobalSettings.BROKER_FXDD) {
			doFXDD();
		} else if (brokerId == GlobalSettings.BROKER_DEMO) {
			doWebDemo();
		} else if (brokerId == GlobalSettings.BROKER_DIRECT) {
			doDirect();
		} else if (brokerId == GlobalSettings.BROKER_FXCLUB) {
			doFXClub();
		} else if (brokerId == GlobalSettings.BROKER_ALPARI) {
			doAlpari();
		} else if (brokerId == GlobalSettings.BROKER_MFGLOBAL_AUS) {
			//doEmpty();
			doMFGlobal();
		} else {
			doEmpty();
		} 
	}
	
	public MultiWordSuggestOracle getSuggestOracle() { 
		return suggestionMap.get(brokerId).get(localeCode);
	}


	private void doFXDD() {
		MultiWordSuggestOracle fxddOracle = new MultiWordSuggestOracle();
		fxddOracle.add("AUDCAD");
		fxddOracle.add("AUDJPY");
		fxddOracle.add("AUDNZD");
		fxddOracle.add("AUDUSD");
		fxddOracle.add("CADJPY");
		fxddOracle.add("CHFJPY");
		fxddOracle.add("EURAUD");
		fxddOracle.add("EURCAD");
		fxddOracle.add("EURCHF");
		fxddOracle.add("EURGBP");
		fxddOracle.add("EURJPY");
		fxddOracle.add("EURUSD");
		fxddOracle.add("GBPCHF");
		fxddOracle.add("GBPJPY");
		fxddOracle.add("GBPUSD");
		fxddOracle.add("NZDUSD");
		fxddOracle.add("USDCAD");
		fxddOracle.add("USDCHF");
		fxddOracle.add("USDJPY");
		fxddOracle.add("USDMXN");
		Map fxddMap = new HashMap();
		fxddMap.put(localeCode, fxddOracle);
		suggestionMap.put(brokerId, fxddMap);
	}
	
	private void doDirect() {
		MultiWordSuggestOracle directOracle = new MultiWordSuggestOracle();
		directOracle.add("AUDUSD");
		directOracle.add("EURAUD");
		directOracle.add("EURCAD");
		directOracle.add("EURCHF");
		directOracle.add("EURGBP");
		directOracle.add("EURJPY");
		directOracle.add("EURUSD");
		directOracle.add("GBPCHF");
		directOracle.add("GBPJPY");
		directOracle.add("GBPUSD");
		directOracle.add("USDCAD");
		directOracle.add("USDCHF");
		directOracle.add("USDJPY");
		directOracle.add("USDZAR");		
		Map directMap = new HashMap();
		directMap.put(localeCode, directOracle);
		suggestionMap.put(brokerId, directMap);
	}
	
	private void doAlpari() {
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("AUDCAD");
		oracle.add("AUDCHF");
		oracle.add("AUDJPY");
		oracle.add("AUDNZD");
		oracle.add("AUDUSD");
		oracle.add("CADCHF");
		oracle.add("CADJPY");
		oracle.add("CHFJPY");
		oracle.add("EURAUD");
		oracle.add("EURCAD");
		oracle.add("EURCHF");
		oracle.add("EURGBP");
		oracle.add("EURJPY");
		oracle.add("EURNZD");
		oracle.add("EURUSD");
		oracle.add("GBPCHF");
		oracle.add("GBPJPY");
		oracle.add("GBPUSD");
		oracle.add("NZDJPY");
		oracle.add("NZDUSD");
		oracle.add("SGDJPY");
		oracle.add("USDCAD");
		oracle.add("USDCHF");
		oracle.add("USDDKK");
		oracle.add("USDHKD");
		oracle.add("USDJPY");
		oracle.add("USDNOK");
		oracle.add("USDSEK");
		oracle.add("USDSGD");
		oracle.add("XAGUSD");
		oracle.add("XAUUSD");						
		Map map = new HashMap();
		map.put(localeCode, oracle);
		suggestionMap.put(brokerId, map);
	}
	
	private void doFXClub() {
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("AUDCAD");
		oracle.add("AUDCHF");
		oracle.add("AUDJPY");
		oracle.add("AUDUSD");
		oracle.add("CADCHF");
		oracle.add("CADJPY");
		oracle.add("CHFJPY");
		oracle.add("EURAUD");
		oracle.add("EURCAD");
		oracle.add("EURCHF");
		oracle.add("EURGBP");
		oracle.add("EURJPY");
		oracle.add("EURUSD");
		oracle.add("GBPCAD");
		oracle.add("GBPCHF");
		oracle.add("GBPJPY");
		oracle.add("GBPUSD");
		oracle.add("NZDJPY");
		oracle.add("NZDUSD");
		oracle.add("USDCAD");
		oracle.add("USDCHF");
		oracle.add("USDJPY");
						
		Map map = new HashMap();
		map.put(localeCode, oracle);
		suggestionMap.put(brokerId, map);
	}
	
	private void doWebDemo() {
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("MXN/JPY");
		oracle.add("HKD/JPY");
		oracle.add("USD/HUF");
		oracle.add("USD/SGD");
		oracle.add("AUD/NZD");
		oracle.add("GBP/PLN");
		oracle.add("USD/MXN");
		oracle.add("GBP/TRY");
		oracle.add("CZK/JPY");
		oracle.add("DKK/CZK");
		oracle.add("EUR/HKD");
		oracle.add("CAD/SEK");
		oracle.add("NZD/PLN");
		oracle.add("DKK/ZAR");
		oracle.add("CHF/JPY");
		oracle.add("USD/SEK");
		oracle.add("AUD/JPY");
		oracle.add("USD/DKK");
		oracle.add("USD/AED");
		oracle.add("CAD/DKK");
		oracle.add("CAD/CHF");
		oracle.add("NZD/HKD");
		oracle.add("CAD/SGD");
		oracle.add("GBP/HKD");
		oracle.add("EUR/MXN");
		oracle.add("EUR/GBP");
		oracle.add("EUR/TRY");
		oracle.add("USD/CHF");
		oracle.add("AUD/CAD");
		oracle.add("SEK/JPY");
		oracle.add("USD/THB");
		oracle.add("USD/ILS");
		oracle.add("GBP/SGD");
		oracle.add("USD/CZK");
		oracle.add("PLN/JPY");
		oracle.add("NZD/SGD");
		oracle.add("EUR/SEK");
		oracle.add("AUD/USD");
		oracle.add("USD/PLN");
		oracle.add("USD/TRY");
		oracle.add("THB/JPY");
		oracle.add("ZAR/JPY");
		oracle.add("EUR/THB");
		oracle.add("EUR/JPY");
		oracle.add("NZD/JPY");
		oracle.add("AUD/NOK");
		oracle.add("EUR/SGD");
		oracle.add("EUR/CAD");
		oracle.add("NZD/SEK");
		oracle.add("CHF/NOK");
		oracle.add("GBP/JPY");
		oracle.add("GBP/SEK");
		oracle.add("CHF/HKD");
		oracle.add("NZD/THB");
		oracle.add("AUD/HKD");
		oracle.add("EUR/PLN");
		oracle.add("DKK/HUF");
		oracle.add("USD/KWD");
		oracle.add("GBP/CAD");
		oracle.add("AUD/ZAR");
		oracle.add("NOK/DKK");
		oracle.add("NZD/CAD");
		oracle.add("CHF/ZAR");
		oracle.add("GBP/THB");
		oracle.add("NZD/USD");
		oracle.add("CHF/HUF");
		oracle.add("GBP/CZK");
		oracle.add("AUD/SGD");
		oracle.add("CHF/SGD");
		oracle.add("NZD/CZK");
		oracle.add("GBP/USD");
		oracle.add("GBP/DKK");
		oracle.add("USD/SAR");
		oracle.add("SGD/HKD");
		oracle.add("CHF/SEK");
		oracle.add("AUD/SEK");
		oracle.add("CAD/PLN");
		oracle.add("CHF/DKK");
		oracle.add("EUR/CZK");
		oracle.add("USD/JPY");
		oracle.add("AUD/DKK");
		oracle.add("EUR/USD");
		oracle.add("CAD/JPY");
		oracle.add("GBP/ZAR");
		oracle.add("PLN/CZK");
		oracle.add("EUR/NZD");
		oracle.add("TRY/JPY");
		oracle.add("CZK/HUF");
		oracle.add("NZD/ZAR");
		oracle.add("AUD/CHF");
		oracle.add("USD/CAD");
		oracle.add("GBP/NOK");
		oracle.add("AUD/THB");
		oracle.add("NZD/HUF");
		oracle.add("NOK/SEK");
		oracle.add("AUD/CZK");
		oracle.add("CHF/CZK");
		oracle.add("GBP/HUF");
		oracle.add("SEK/PLN");
		oracle.add("DKK/THB");
		oracle.add("GBP/NZD");
		oracle.add("CHF/TRY");
		oracle.add("EUR/ZAR");
		oracle.add("AUD/PLN");
		oracle.add("CHF/PLN");
		oracle.add("DKK/JPY");
		oracle.add("EUR/NOK");
		oracle.add("NOK/JPY");
		oracle.add("SGD/JPY");
		oracle.add("DKK/SEK");
		oracle.add("EUR/CHF");
		oracle.add("PLN/HUF");
		oracle.add("NZD/DKK");
		oracle.add("USD/NOK");
		oracle.add("EUR/AUD");
		oracle.add("DKK/PLN");
		oracle.add("CAD/HKD");
		oracle.add("EUR/HUF");
		oracle.add("CAD/NOK");
		oracle.add("USD/HKD");
		oracle.add("NZD/CHF");
		oracle.add("DKK/SGD");
		oracle.add("GBP/CHF");
		oracle.add("GBP/AUD");
		oracle.add("EUR/DKK");
		oracle.add("USD/ZAR");
		Map wordMap = new HashMap();
		wordMap.put(localeCode, oracle);
		suggestionMap.put(brokerId, wordMap);
	}
	
	private void doMFGlobal() {
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		oracle.add("LSE | SAB | SABMILLER PLC");
		Map map = new HashMap();
		map.put(localeCode, oracle);
		suggestionMap.put(brokerId, map);
	}
	
	private void doEmpty() {
		MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
		//oracle.add("???");
		Map map = new HashMap();
		map.put(localeCode, oracle);
		suggestionMap.put(brokerId, map);
	}
	
}
