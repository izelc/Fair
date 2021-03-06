package com.cavusoglu.fair;

public class ExtractorMeridyen extends Extractor {

	public ExtractorMeridyen() {
		super("http://www.meridyenfair.com/2015-fuar-takvimi/",
				"#ai1ec-calendar-view > div.ai1ec-agenda-view", "", "", "", "");

	}

	public ExtractorMeridyen(DocumentFetcher mock) {
		super(mock, "http://www.meridyenfair.com/2015-fuar-takvimi/",
				"#ai1ec-calendar-view > div.ai1ec-agenda-view", "", "", "", "");

	}

	@Override
	public Fair extracFairs(int i) throws Exception {

		String cssPathForFair = "> div:nth-child(MYINDEX) > div > div > div.ai1ec-event-header > span";
		String fair = documentSearcher.extractElementWithCssPAth(cssPathForFair
				.replace("MYINDEX", "" + i));

		String[] split = fair.split("\\|");
		logger.info("Name :" + split[0] + "Date: " + split[1] + "Place"
				+ split[2]);

		DateInterval dateInterval = new DateInterval().getInterval(
				split[1].replaceAll("\\s+", ""), "\\-");

		return new Fair(split[0], dateInterval, split[2], "-");

	}

}
