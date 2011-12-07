package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class MultilanguageMap extends LinkedHashMap<String, /*MultiLanguageItem*/ String> implements Serializable {

	LinkedHashMap<String, String> valueIcons = new LinkedHashMap<String, String>();
    
	LinkedHashMap<String, MultiLanguageItem> itemMap = new LinkedHashMap<String, MultiLanguageItem>();
	
	public MultilanguageMap() {
		super();	
	}
	
	public MultilanguageMap(String prefix, int brokerId) {
		super();
		
		put("en_GB", "English");
		put("ja_JP", "日本語");
		put("zh_CN", "简体中文");
		put("ru_RU", "Русский");
		put("it_IT", "Italiano");
		put("sv_SE", "Svenska");
		put("de_DE", "Deutsch");
		put("fr_LU", "Français");
		put("es_ES", "Español");
		put("pt_PT", "Português");
		put("ko_KR", "한국어");
		put("ar_AE", "العربية");
		put("nl_NL", "Nederlandse");
		if(brokerId == GlobalSettings.BROKER_GEMCAPITAL) {
			put("el_GR", "Ελληνικά");
		}
		itemMap.put("en_GB", new MultiLanguageItem(prefix, "English", "en_GB", "/icons/en_GB.png"));
		itemMap.put("ja_JP", new MultiLanguageItem(prefix, "日本語", "ja_JP", "/icons/ja_JP.png"));
		itemMap.put("zh_CN", new MultiLanguageItem(prefix, "简体中文", "zh_CN", "/icons/zh_CN.png"));
		itemMap.put("ru_RU", new MultiLanguageItem(prefix, "Русский", "ru_RU", "/icons/ru_RU.png"));
		itemMap.put("it_IT", new MultiLanguageItem(prefix, "Italiano", "it_IT", "/icons/it_IT.png"));
		itemMap.put("sv_SE", new MultiLanguageItem(prefix, "Svenska", "sv_SE", "/icons/sv_SE.png"));
		itemMap.put("de_DE", new MultiLanguageItem(prefix, "Deutsch", "de_DE", "/icons/de_DE.png"));
		itemMap.put("fr_LU", new MultiLanguageItem(prefix, "Français", "fr_LU", "/icons/fr_LU.png"));
		itemMap.put("es_ES", new MultiLanguageItem(prefix, "Español", "es_ES", "/icons/es_ES.png"));
		itemMap.put("pt_PT", new MultiLanguageItem(prefix, "Português", "pt_PT", "/icons/pt_PT.png"));
		itemMap.put("ko_KR", new MultiLanguageItem(prefix, "한국어", "ko_KR", "/icons/ko_KR.png"));
		itemMap.put("ar_AE", new MultiLanguageItem(prefix, "العربية", "ar_AE", "/icons/ar_AE.png"));
		itemMap.put("nl_NL", new MultiLanguageItem(prefix, "Nederlandse", "nl_NL", "/icons/nl_NL.png"));
		if(brokerId == GlobalSettings.BROKER_GEMCAPITAL) {
			itemMap.put("el_GR", new MultiLanguageItem(prefix, "Ελληνικά", "el_GR", "/icons/el_GR.png"));
		}
		
		valueIcons.put("en_GB", "en_GB");
	    valueIcons.put("ja_JP", "ja_JP");
	    valueIcons.put("zh_CN", "zh_CN");
	    valueIcons.put("ru_RU", "ru_RU");
	    valueIcons.put("it_IT", "it_IT");
	    valueIcons.put("sv_SE", "sv_SE");
	    valueIcons.put("de_DE", "de_DE");
	    valueIcons.put("fr_LU", "fr_LU");
	    valueIcons.put("es_ES", "es_ES");
	    valueIcons.put("pt_PT", "pt_PT");
	    valueIcons.put("ko_KR", "ko_KR");
	    valueIcons.put("ar_AE", "ar_AE");
	    valueIcons.put("nl_NL", "nl_NL");
	    if(brokerId == GlobalSettings.BROKER_GEMCAPITAL) {
	    	valueIcons.put("el_GR", "el_GR");
	    }
	}

	public LinkedHashMap<String, String> getValueIcons() {
		return valueIcons;
	}

	public LinkedHashMap<String, MultiLanguageItem> getItemMap() {
		return itemMap;
	}
	
	
	
}
