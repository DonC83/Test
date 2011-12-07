package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;

import java.util.HashMap;

public class BrokerLogoMap extends HashMap<Integer, String> {
	
	public BrokerLogoMap(String companyId, String locale) {
		super();
		// SIZE: "155px", "55px"
		put(GlobalSettings.BROKER_FXDD, "/icons/logo_fxdd_small.gif");
		put(GlobalSettings.BROKER_FXCLUB, "/icons/logo_fxclub_small.gif");
		put(GlobalSettings.BROKER_ALPARI, "/icons/logo_alpari_small.gif");
		put(GlobalSettings.BROKER_MFGLOBAL_AUS, "/icons/logo_mfglobal.png");
		put(GlobalSettings.BROKER_MFGLOBAL_SING, "/icons/logo_mfglobal.png");
		if (companyId != null) {
			if (companyId.equals("1")) {
				if (locale.toLowerCase().equals("zh_cn") || locale.toLowerCase().equals("zh_tw")) {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_hyinvestment_small_zh_CN.jpg");
				} else {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_hyinvestment_small.jpg");
				}
				put(GlobalSettings.BROKER_GFT, "/icons/logo_gft.png");
				put(GlobalSettings.BROKER_WORLDSPREADS, "/icons/logo_worldspreads.png");
			} else if (companyId.equals("2")) {
				if (locale.toLowerCase().equals("zh_cn") || locale.toLowerCase().equals("zh_tw")) {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_hymarkets_small_zh_CN.jpg");
				} else {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_hymarkets_small.jpg");
				}
			} else if (companyId.equals("3")) {
				if (locale.toLowerCase().equals("zh_cn") || locale.toLowerCase().equals("zh_tw")) {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_piptrade_small_zh_CN.jpg");
				} else {
					put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_piptrade_small.jpg");
				}
			}
		} else {
			put(GlobalSettings.BROKER_HYMARKETS, "/icons/logo_hymarkets_small.jpg");	
			put(GlobalSettings.BROKER_WORLDSPREADS, "/icons/logo_worldspreads.png");
		}		
		put(GlobalSettings.BROKER_TRADEFAIR, "/icons/logo_tradefair_small.png");
		put(GlobalSettings.BROKER_SVS, "/icons/logo_svs_small.png");
		put(GlobalSettings.BROKER_INTERBANKFX, "/icons/logo_interbankfx.png");
		put(GlobalSettings.BROKER_FXNEWS, "/icons/logo_fxnews.png");
		put(GlobalSettings.BROKER_UFXBANK, "/icons/logo_ufxbank.png");
		put(GlobalSettings.BROKER_GAINCAPITAL, "/icons/logo_gain.jpg");
		put(GlobalSettings.BROKER_ACTIVTRADES, "/icons/logo_activtrades.jpg");
		put(GlobalSettings.BROKER_GEMCAPITAL, "/icons/logo_gem.png");
		put(GlobalSettings.BROKER_CIMB_INDON, "/icons/logo_cimb.png");
		put(GlobalSettings.BROKER_CIMB_SING, "/icons/logo_cimb.png");
		put(GlobalSettings.BROKER_MFFUTURESSINGAPORE, "/icons/logo_mfglobal.png");
		put(GlobalSettings.BROKER_FINAM_FX, "/icons/logo_finamfx.png");
		put(GlobalSettings.BROKER_FINAM_EQUITIES, "/icons/logo_finamequities.png");	
		put(GlobalSettings.BROKER_PFGBEST, "/icons/logo_pfgbest.gif");
		
		put(GlobalSettings.BROKER_4CAST, "/icons/logo_4cast.png");				
	}
}
