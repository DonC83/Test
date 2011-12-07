package com.autochartist.web.aclite.client.constants;

import java.io.Serializable;

public interface GlobalSettings extends Serializable {

	// yes, I know, this *should* be an enum. But hey, when you
	// figure out how to make it work with jasper, feel free
	// to use an enum.
	public static final int DEBUG = 1, LOCAL_TEST = 2, REMOTE_TEST = 3, PRODUCTION = 4, BETA = 5;

	public static final int BUILDMODE = DEBUG;

	// Change for tomcat deployment
	/**/
	public static final String CONTEXT_PREFIX = BUILDMODE == DEBUG ? ""
			: BUILDMODE == LOCAL_TEST ? "/aclite"
					: BUILDMODE == REMOTE_TEST ? "/aclite"
							: BUILDMODE == PRODUCTION ? "/aclite" : BUILDMODE == BETA ? "/aclite"
									: "/aclite" ;

	public static final String BROKERPERMISSIONSHOST = BUILDMODE == DEBUG ? "furaha.autochartist.com"
			: BUILDMODE == LOCAL_TEST ? "192.168.5.249"
					: BUILDMODE == REMOTE_TEST ? "puck.autochartist.com"
							: BUILDMODE == PRODUCTION ? "localhost" : BUILDMODE == DEBUG ? "localhost"
									: "localhost";
                                                                   //184.73.192.215
	public static final String BROKERDBHOST = BUILDMODE == DEBUG ? "localhost"
			: BUILDMODE == LOCAL_TEST ? "192.168.5.248"
					: BUILDMODE == REMOTE_TEST ? "216.93.167.57" : "localhost"; // 69.59.179.41
                                                                                      //"ACAWEB_FX"
	public static final String SERVERBROKERDBNAME = BUILDMODE == DEBUG ? "ACAWEB_V"
			: BUILDMODE == LOCAL_TEST ? "ACAWEB"
					: BUILDMODE == REMOTE_TEST ? "ACAWEB_IG6" : "ACAWEB";

	public static final String SATELLITEBROKERDBNAME = BUILDMODE == DEBUG ? "ACAWEB"
			: BUILDMODE == LOCAL_TEST ? "ACAWEB"
					: BUILDMODE == REMOTE_TEST ? "ACAWEB_IG6" : "ACAWEB";

	// public static final String DBTYPE = "MSSQL";
	// System property set for furaha and urafiki to set DBTYPE = MSSQL
	// System.getProperty in not implemented for GWT!!!
	// public static final String DBTYPE = System.getProperty("DBTYPE",
	// "POSTGRESQL");

	public static final int ACCOUNT_TYPE_LIVE = 0;
	public static final int ACCOUNT_TYPE_DEMO = 1;
	public static final int DEMO_DELAY_BARS = 5;	
	
	// Brokers
	public static final int BROKER_IG = 58;
	public static final int BROKER_CITIFX = 55;
	public static final int BROKER_DEMO = 47; // Uses GFT Data
	public static final int BROKER_FXDD = 34;
	public static final int BROKER_FXCLUB = 46;
	public static final int BROKER_ALPARI = 49;
	public static final int BROKER_DIRECT = 24; // Uses IQFeed Data
	public static final int BROKER_KOREADIRECT = 59;
	public static final int BROKER_IRESS = 60; // FP Markets, ASX through the
												// Iguana data feed
	public static final int BROKER_HYMARKETS = 62;
	public static final int BROKER_PFGBEST = 63;
	public static final int BROKER_TRADEFAIR = 64;
	public static final int BROKER_SVS = 66;
	public static final int BROKER_MFGLOBAL_AUS = 68;
	public static final int BROKER_MFGLOBAL_SING = 80;
	public static final int BROKER_INTERBANKFX = 35;
	public static final int BROKER_FXNEWS = 67;
	public static final int BROKER_WORLDSPREADS = 70;
	public static final int BROKER_EXCHANGEDEMO = 71;
	public static final int BROKER_GFT = 43;
	public static final int BROKER_UFXBANK = 72;
	public static final int BROKER_GAINCAPITAL = 36;
	public static final int BROKER_ACTIVTRADES = 73;
	public static final int BROKER_GEMCAPITAL= 74;
	public static final int BROKER_CIMB_INDON = 76;
	public static final int BROKER_CIMB_SING = 81;
	public static final int BROKER_MFFUTURESSINGAPORE = 77;
	public static final int BROKER_FINAM_FX = 78;
	public static final int BROKER_FINAM_EQUITIES = 79;
	public static final int BROKER_ADMIRAL_MARKETS = 82;
	public static final int BROKER_DEMO_FOUR = 75;

	public static final int BROKER_4CAST = 98;	
	public static final int BROKER_DEMO2012 = 99;
	
	public static int DEMOPATTERNVIEWSLIMIT = 15;
}