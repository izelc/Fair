package com.cavusoglu.fair;


import org.apache.log4j.Logger;

import com.google.gson.JsonArray;

public class FairCalendarCreator {
	private Extractor extractor;
	private int lastIndex;
	private int startIndex;
	private int indexIncrease;
	private JsonArray fairList;
	private Logger logger = Logger.getLogger(getClass());
	
	public JsonArray getFairCalendar() {
		return fairList;
	}

	public FairCalendarCreator(Extractor extractor, int startIndex,
			 int lastIndex,int indexIncrease) throws Exception {
		this.extractor = extractor;
		logger.info("Extractor is instantiated.");
		this.lastIndex = lastIndex;
		this.startIndex = startIndex;
		this.indexIncrease = indexIncrease;
		fairList=new JsonArray();
		fillfairlist();
	}

	private void fillfairlist() throws Exception {
		logger.info("filling calendar");
		for (int i = startIndex; i <=lastIndex; i += indexIncrease) {
			try {
				fairList.add(extractor.extracFairs(i).getJsonLdObject());
			} catch (NoSuchIndexAtHtmlDocumentException e) {
                   
				logger.error("Check index value of css path.");
			}
		}
	}
	
	
}
