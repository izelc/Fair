package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class Extractor {
	private Logger logger = Logger.getLogger(getClass());
	protected DocumentSearcher documentSearcher;
	protected DocumentFetcher documentFetcher;
	protected String cssPathForPlace;
	protected String cssPathForName;
	protected String cssPathForDescription;
	protected String cssPathForDate;

	public Extractor() {

	}

	public Extractor(DocumentFetcher documentFetcher) {
		documentSearcher = new DocumentSearcher(documentFetcher);
	}

	public String getDateSplitterRegex() {
		return "\\-";
	}

	public DateInterval findDate(int i) {
		String date = findFairAttribute(i,
				cssPathForDate.replace("MYINDEX", "" + i), "Date");
		logger.info("Date is extracted " + date + " with css path "
				+ cssPathForDate);

		DateInterval interval = new DateInterval().getInterval(date,
				getDateSplitterRegex());
		logger.info("Date is splitted.StartDate: " + interval.getStartDate()
				+ "EndDate" + interval.getEndDate());
		return interval;
	}

	public String findPlace(int i) {
		return findFairAttribute(i, cssPathForPlace.replace("MYINDEX", "" + i),
				"Place");

	}

	public String findName(int i) {
		return findFairAttribute(i, cssPathForName.replace("MYINDEX", "" + i),
				"Name");
	}

	public String findDescription(int i) {
		return findFairAttribute(i,
				cssPathForDescription.replace("MYINDEX", "" + i), "Description");
	}

	public String findFairAttribute(int i, String cssPath,
			String typeOfAttribute) {
		String attribute = documentSearcher.extractElementWithCssPAth(cssPath);
		if (attribute == "" || attribute == null) {
			logger.warn(typeOfAttribute + " is empty");
		} else
			logger.trace(typeOfAttribute + " is found: " + attribute);

		return attribute;
	}

	public Fair extracFairs(int i) {

		return new Fair(findName(i), findDate(i), findPlace(i),
				findDescription(i));

	}

}