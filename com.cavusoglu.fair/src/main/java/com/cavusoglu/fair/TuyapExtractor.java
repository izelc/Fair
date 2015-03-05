package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class TuyapExtractor {

	private Logger logger = Logger.getLogger(getClass());
	DocumentSearcher documentSearcher;
	DatePreparator datePreparator = new DatePreparator();

	public TuyapExtractor() {
		documentSearcher = new DocumentSearcher();

	}

	public TuyapExtractor( DocumentSearcher documentSearcher)  {
		this.documentSearcher = new DocumentSearcher();
	}

	public String extractFairName(int i) {
		String cssPath = "> tr:nth-child("+ i + ") > td:nth-child(2) > h5 > strong";
		String fairName = documentSearcher.extractElementWithCssPAth(cssPath);
		logger.debug("Fair name has been extracted" + fairName);
		return fairName;

	}

	public String extractFairDate(int i) {
		String cssPath = "> tr:nth-child(" + i + ") > td:nth-child(3) > h5 > b";
		String extractElementWithCssPAth = documentSearcher
				.extractElementWithCssPAth(cssPath);
		logger.info("Fair date has been extracted" + extractElementWithCssPAth);
		return extractElementWithCssPAth;
	}

	public DateInterval extractDateInterval(int i) throws UnidentifiedMonthNameStrike {
		logger.info("extractDateInterval is working");
		return new DatePreparator().splitAndConvertToIso(extractFairDate(i));
	}
	
	

	public String extractFairDescription(int i) {
		String cssPath = "> tr:nth-child(" + i + ") > td:nth-child(2)";
		String fairDescription = documentSearcher
				.extractElementWithCssPAth(cssPath);
		logger.debug("Fair desc. has been extracted" + fairDescription);
		return fairDescription;
	}

	public String extractFairPlace(int i) {
		String cssPath = "> tr:nth-child(" + i + ") > td:nth-child(3) > b > span";
		String fairPlace = documentSearcher.extractElementWithCssPAth(cssPath);
		logger.debug("Fair place has been extracted" + fairPlace);
		return fairPlace;

	}

}
