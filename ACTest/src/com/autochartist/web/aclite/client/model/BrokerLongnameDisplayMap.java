package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.GlobalSettings;

import java.util.HashMap;

public class BrokerLongnameDisplayMap extends HashMap<Integer, Boolean> {
	
	private static final long serialVersionUID = -7498361596275194218L;

	public BrokerLongnameDisplayMap() {
		super();		
		// All brokers that should display long names		
		put(GlobalSettings.BROKER_IG, true); 
		put(GlobalSettings.BROKER_MFGLOBAL_AUS, true);
		put(GlobalSettings.BROKER_MFGLOBAL_SING, true);
		put(GlobalSettings.BROKER_MFFUTURESSINGAPORE, true);
		put(GlobalSettings.BROKER_CIMB_INDON, true);
		put(GlobalSettings.BROKER_CIMB_SING, true);
		put(GlobalSettings.BROKER_EXCHANGEDEMO, true);
		put(GlobalSettings.BROKER_WORLDSPREADS, true);
		put(GlobalSettings.BROKER_KOREADIRECT, true);
		put(GlobalSettings.BROKER_FINAM_EQUITIES, true);
		put(GlobalSettings.BROKER_DEMO2012, true);		
	}

	@Override
	public Boolean get(Object key) {
		Boolean boolean1 = super.get(key);
		// default to false if not found
		if (boolean1 == null) {
			return false;
		} else {
			return boolean1;
		}
	}
}