package com.autochartist.web.aclite.client.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PowerstatsTranslations implements Serializable
{	ArrayList<String> DayNames;
	String Title;
	String XTitle;
	String YTitle;
	String EnglishTitle;
	ArrayList<String> TimePeriods; //minute/hour/daily
	
	public PowerstatsTranslations()
	{}
	
	public PowerstatsTranslations(ArrayList<String> dayNames, String title, String xtitle, String ytitle, String englishTitle, ArrayList<String> timePeriods)
	{	DayNames = dayNames;
		Title = title;
		XTitle = xtitle;
		YTitle = ytitle;
		EnglishTitle = englishTitle;
		TimePeriods = timePeriods;
	}
	
	public PowerstatsTranslations clone()
	{	PowerstatsTranslations pst = new PowerstatsTranslations();
		pst.Title = getTitle();
		pst.XTitle = getXTitle();
		pst.YTitle = getYTitle();
		pst.EnglishTitle = getEnglishTitle();
		pst.DayNames = new ArrayList<String>();
		if(getDayNames() != null)
		{	for(int i = 0; i < getDayNames().size(); i++)
			{	pst.DayNames.add(getDayNames().get(i));
			}
		}

		if(getTimePeriods() != null)
		{	for(int i = 0; i < getTimePeriods().size(); i++)
			{	pst.TimePeriods.add(getTimePeriods().get(i));
			}
		}
		return pst;
	}

	public ArrayList<String> getTimePeriods() 
	{	return TimePeriods;
	}

	public void setTimePeriods(ArrayList<String> timePeriods) 
	{	TimePeriods = timePeriods;
	}

	public String getEnglishTitle() 
	{	return EnglishTitle;
	}

	public void setEnglishTitle(String englishTitle) 
	{	EnglishTitle = englishTitle;
	}

	public ArrayList<String> getDayNames() 
	{	return DayNames;
	}

	public void setDayNames(ArrayList<String> dayNames) 
	{	DayNames = dayNames;
	}

	public String getTitle() 
	{	return Title;
	}

	public void setTitle(String title) 
	{	Title = title;
	}

	public String getXTitle() 
	{	return XTitle;
	}

	public void setXTitle(String xTitle) 
	{	XTitle = xTitle;
	}

	public String getYTitle() 
	{	return YTitle;
	}

	public void setYTitle(String yTitle) 
	{	YTitle = yTitle;
	}
}
