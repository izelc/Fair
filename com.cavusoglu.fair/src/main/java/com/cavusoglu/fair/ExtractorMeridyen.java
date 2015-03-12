package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class ExtractorMeridyen extends Extractor {
	// #ai1ec-calendar-view > div.ai1ec-agenda-view > div:nth-child(1) > div >
	// div > div.ai1ec-event-header > span
	// #ai1ec-calendar-view > div.ai1ec-agenda-view > div:nth-child(2) > div >
	// div > div.ai1ec-event-header > span
	Logger logger = Logger.getLogger(getClass());

	public ExtractorMeridyen() {
		super("http://www.meridyenfair.com/2015-fuar-takvimi/",
				"#ai1ec-calendar-view > div.ai1ec-agenda-view", "", "", "", "");
		// documentFetcher = new DocumentFetcher(
		// "http://www.meridyenfair.com/2015-fuar-takvimi/",
		// "#ai1ec-calendar-view > div.ai1ec-agenda-view");
		// documentSearcher = new DocumentSearcher(null);
	}

	public ExtractorMeridyen(DocumentFetcher mock) {
		// TODO Auto-generated constructor stub
		super(mock, "http://www.meridyenfair.com/2015-fuar-takvimi/",
				"#ai1ec-calendar-view > div.ai1ec-agenda-view", "", "", "", "");

	}

	@Override
	public Fair extracFairs(int i) throws Exception {

		String cssPathForFair = "> div:nth-child(MYINDEX) > div > div > div.ai1ec-event-header > span";
		String fair = stableElementFetcher.getElement()
				.select(cssPathForFair.replace("MYINDEX", "" + i)).text();

		String[] split = fair.split("\\|");
		logger.info("Name :" + split[0] + "Date: " + split[1] + "Place"
				+ split[2]);

		DateInterval dateInterval = new DateInterval().getInterval(
				split[1].replaceAll("\\s+", ""), "\\-");

		return new Fair(split[0], dateInterval, split[2], "-");

	}

}
