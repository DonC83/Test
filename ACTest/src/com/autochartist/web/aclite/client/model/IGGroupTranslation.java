package com.autochartist.web.aclite.client.model;

import com.autochartist.web.aclite.client.constants.ACConstants;

import java.util.HashMap;

public class IGGroupTranslation extends HashMap<String, String> {

	public IGGroupTranslation(ACConstants constants) {
		super();
		put("Bonds and Rates", constants.BondsAndRates());
		put("Indices, Metals, Commodities and Energies", constants.IndicesMetalsCommoditiesEnergies());
		put("Commodities, Metals, Energies", constants.CommoditiesMetalsEnergies());
		put("Commodities and Energies", constants.CommoditiesandEnergies());
		put("All FOREX CFD", constants.AllFOREXCFD());
		put("All FOREX", constants.AllFOREX());
		put("Stock Indicies", constants.StockIndices());
		put("Stock Indices", constants.StockIndices());
		put("Metals", constants.Metals());
		put("Energies", constants.Energies());
		put("Soft Commodities", constants.SoftCommodities());
		put("Rates", constants.Rates());
		put("Shares US", constants.SharesUS());
		put("Shares UK", constants.SharesUK());
		put("Shares Australia", constants.SharesAustralia());
		put("Shares Netherlands, Belgium, Portugal, France",
				constants.SharesNetherlandsBelgiumPortugalFrance());
		put("Shares Germany", constants.SharesGermany());
		put("Shares Italy", constants.SharesItaly());
		put("Shares Spain", constants.SharesSpain());
		put("Shares Ireland", constants.SharesIreland());
		put("Shares Switzerland", constants.SharesSwitzerland());
		put("Shares Denmark, Finland, Sweden", constants.SharesDenmarkFinlandSweden());
		put("Shares Norway", constants.SharesNorway());
		put("Shares Austria", constants.SharesAustria());
		put("Shares Greece", constants.SharesGreece());
		put("Shares Singapore", constants.SharesSingapore());
		put("Shares Japan", constants.SharesJapan());
		put("Shares Korea", constants.SharesKorea());
		put("Shares Hong Kong", constants.SharesHongKong());
		put("Shares Taiwan", constants.SharesTaiwan());
		put("Shares South Africa", constants.SharesSouthAfrica());
		put("Shares Canada", constants.SharesCanada());
		put("Currencies", constants.Currencies());
		put("Currencies and Metals", constants.CurrenciesandMetals());
		put("UK Sectors", constants.UKSectors());
		put("Australian Sectors", constants.AustralianSectors());	
		put("Commodities",constants.Commodities());
	}
}
