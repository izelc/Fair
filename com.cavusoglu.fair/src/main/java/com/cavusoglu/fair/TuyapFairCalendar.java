package com.cavusoglu.fair;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

public class TuyapFairCalendar {
	
	private Logger logger = Logger.getLogger(getClass());
	ArrayList<JsonObject> fairList = new ArrayList<JsonObject>();
	private TuyapExtractor tuyapExtractor;

	public TuyapFairCalendar() throws UnidentifiedMonthNameStrike {
		tuyapExtractor = new TuyapExtractor();
		fillFairList();
	}

	public TuyapFairCalendar(TuyapExtractor tuyapExtractor) throws UnidentifiedMonthNameStrike {
		this.tuyapExtractor = tuyapExtractor;
		fillFairList();
	}

	private void fillFairList() throws UnidentifiedMonthNameStrike {
		DateInterval extractDateInterval;
		Fair fair;
		int i = 1;
		while ( !tuyapExtractor.extractFairName(i).equals("") &&i < 300) {
			
			extractDateInterval = tuyapExtractor.extractDateInterval(i);
			
			fair = new Fair(tuyapExtractor.extractFairName(i),
					extractDateInterval.getEndDate(),
					extractDateInterval.getStartDate(),
					tuyapExtractor.extractFairPlace(i),
					tuyapExtractor.extractFairDescription(i));
			logger.info("Fair has been added into fairlist "+ fair.toString());
			
			i = i + 3;
			fairList.add(fair.getJsonLdObject());
			

		}
	}

}
