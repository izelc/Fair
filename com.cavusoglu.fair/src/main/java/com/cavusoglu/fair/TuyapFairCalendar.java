package com.cavusoglu.fair;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

/**
 * @author izel
 *This class provides an arraylist filled with JsonObject of fairs on <a href=
 *         "http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015"
 *         >tuyap.com</a>
 */
public class TuyapFairCalendar {
	
	private Logger logger = Logger.getLogger(getClass());
	private ArrayList<JsonObject> fairList = new ArrayList<JsonObject>();
	private TuyapExtractor tuyapExtractor;

	public TuyapFairCalendar() throws UnidentifiedMonthNameStrikeException {
		tuyapExtractor = new TuyapExtractor();
		fillFairList();
	}

	public TuyapFairCalendar(TuyapExtractor tuyapExtractor) throws UnidentifiedMonthNameStrikeException {
		this.tuyapExtractor = tuyapExtractor;
		fillFairList();
	}

	private void fillFairList() throws UnidentifiedMonthNameStrikeException {
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
			getFairList().add(fair.getJsonLdObject());
			

		}
	}

	ArrayList<JsonObject> getFairList() {
		return fairList;
	}

	void setFairList(ArrayList<JsonObject> fairList) {
		this.fairList = fairList;
	}

}
