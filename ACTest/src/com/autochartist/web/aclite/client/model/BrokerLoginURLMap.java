package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;

import java.util.HashMap;

public class BrokerLoginURLMap extends HashMap {

	public BrokerLoginURLMap(String companyId) {
		super();
		put(GlobalSettings.BROKER_ALPARI, "/jsp/AlpariLogin.jsp");
		put(GlobalSettings.BROKER_DIRECT, "/jsp/DirectLogin.jsp");
		put(GlobalSettings.BROKER_FXCLUB, "/jsp/FXClubLogin.jsp");
		put(GlobalSettings.BROKER_FXDD, "/jsp/FXDDLogin.jsp");
		
		put(GlobalSettings.BROKER_MFGLOBAL_AUS, "/jsp/MFGlobalLogin.jsp");
		put(GlobalSettings.BROKER_MFGLOBAL_SING, "/jsp/MFGlobalLogin.jsp");
		if (companyId != null && companyId.equals("1")) {
			put(GlobalSettings.BROKER_HYMARKETS, "/jsp/HYInvestmentLogin.jsp");			
		} else if (companyId != null && companyId.equals("2")) {
			put(GlobalSettings.BROKER_HYMARKETS, "/jsp/HYMarketsLogin.jsp");
		} else if (companyId != null && companyId.equals("3")) {
			put(GlobalSettings.BROKER_HYMARKETS, "/jsp/PipTradeLogin.jsp");
		} else {
			put(GlobalSettings.BROKER_HYMARKETS, "/jsp/HYMarketsLogin.jsp");
		}
		
		put(GlobalSettings.BROKER_IG, "/jsp/igmarkets/IGLogin.jsp");
		put(GlobalSettings.BROKER_IRESS, "/jsp/IRESSLogin.jsp");
		put(GlobalSettings.BROKER_KOREADIRECT, "/jsp/KoreaDirectLogin.jsp");
		put(GlobalSettings.BROKER_DEMO, "/jsp/WebLogin.jsp");
		put(GlobalSettings.BROKER_FXNEWS, "/jsp/FXNEWSLogin.jsp");		
		put(GlobalSettings.BROKER_INTERBANKFX, "/jsp/INTERBANKFXLogin.jsp");
		put(GlobalSettings.BROKER_WORLDSPREADS, "/jsp/WorldSpreadsLogin.jsp");
		put(GlobalSettings.BROKER_EXCHANGEDEMO, "/jsp/ExchangeDemoLogin.jsp");
		put(GlobalSettings.BROKER_GFT, "/jsp/GFTLogin.jsp");
		put(GlobalSettings.BROKER_SVS, "/jsp/SVSLogin.jsp");
		put(GlobalSettings.BROKER_TRADEFAIR, "/jsp/TradeFairLogin.jsp");
		put(GlobalSettings.BROKER_UFXBANK, "/jsp/UFXBankLogin.jsp");
		put(GlobalSettings.BROKER_GAINCAPITAL, "/jsp/GainCapitalLogin.jsp");
		put(GlobalSettings.BROKER_ACTIVTRADES, "/jsp/ActivTradesLogin.jsp");
		put(GlobalSettings.BROKER_CIMB_INDON, "/jsp/CIMBLogin.jsp");
		put(GlobalSettings.BROKER_CIMB_SING, "/jsp/CIMBLogin.jsp");
		put(GlobalSettings.BROKER_MFFUTURESSINGAPORE, "/jsp/MFFuturesSingaporeLogin.jsp");
		put(GlobalSettings.BROKER_FINAM_FX, "/jsp/FinAmFXLogin.jsp");
		put(GlobalSettings.BROKER_FINAM_EQUITIES, "/jsp/FinAmEquitiesLogin.jsp");
		put(GlobalSettings.BROKER_GEMCAPITAL, "/jsp/WSLogin.jsp");
		put(GlobalSettings.BROKER_ADMIRAL_MARKETS, "/jsp/WSLogin.jsp");
		
		put(GlobalSettings.BROKER_4CAST, "/jsp/WSLogin.jsp");
		put(GlobalSettings.BROKER_DEMO2012, "/jsp/Demo2012Login.jsp");		
	}	
}
