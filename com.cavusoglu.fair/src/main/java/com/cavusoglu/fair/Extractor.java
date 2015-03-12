package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class Extractor {

	private Logger logger = Logger.getLogger(getClass());

	protected DocumentSearcher documentSearcher;
	protected DocumentFetcher documentFetcher;
	protected StableElementFetcher stableElementFetcher;

	protected String cssPathForPlace;
	protected String cssPathForName;
	protected String cssPathForDescription;
	protected String cssPathForDate;
	protected String cssPathForMain;
	protected String siteLink;

	public DocumentSearcher getDocumentSearcher() {
		return documentSearcher;
	}

	public void setDocumentSearcher(DocumentSearcher documentSearcher) {
		this.documentSearcher = documentSearcher;
	}

	public Extractor(DocumentFetcher documentFetcher, String siteLink,
			String cssPathForMain, String cssPathForName,
			String cssPathForDate, String cssPathForDescription,
			String cssPathForPlace) {

		this.cssPathForPlace = cssPathForPlace;
		this.cssPathForName = cssPathForName;
		this.cssPathForDescription = cssPathForDescription;
		this.cssPathForDate = cssPathForDate;
		this.cssPathForMain = cssPathForMain;
		this.siteLink = siteLink;

		this.documentFetcher = documentFetcher;

		stableElementFetcher = new StableElementFetcher(documentFetcher,
				cssPathForMain);

		documentSearcher = new DocumentSearcher(stableElementFetcher);
	}

	public Extractor(String siteLink, String cssPathForMain,
			String cssPathForName, String cssPathForDate,
			String cssPathForDescription, String cssPathForPlace) {

		this.cssPathForPlace = cssPathForPlace;
		this.cssPathForName = cssPathForName;
		this.cssPathForDescription = cssPathForDescription;
		this.cssPathForDate = cssPathForDate;
		this.cssPathForMain = cssPathForMain;
		this.siteLink = siteLink;

		logger.info("connnecting to site: "+ siteLink);
		documentFetcher = new DocumentFetcher(siteLink);

		logger.info("Main css part is: "+cssPathForMain);
		stableElementFetcher = new StableElementFetcher(documentFetcher,cssPathForMain);

		documentSearcher = new DocumentSearcher(stableElementFetcher);
	}
	
	public Extractor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Extractor(DocumentFetcher documentFetcher) {
		// TODO Auto-generated constructor stub
	}
	

	public String getDateSplitterRegex() {
		return "\\-";
	}

	public DateInterval findDate(int i) {
		String date = findFairAttribute(i,
				cssPathForDate.replace("MYINDEX", "" + i), "Date");
		logger.info("Date is extracted " + date + " with css path "
				+ cssPathForDate);

		DateInterval interval;
		interval = new DateInterval().getInterval(date, getDateSplitterRegex());

		logger.info("Date is splitted.StartDate: " + interval.getStartDate()
				+ "EndDate" + interval.getEndDate());
		return interval;
	}

	public String findPlace(int i) {
		return findFairAttribute(i, cssPathForPlace.replace("MYINDEX", "" + i),
				"Place");

	}

	public String findName(int i) throws NoSuchIndexAtHtmlDocumentException {
		String name = findFairAttribute(i, cssPathForName.replace("MYINDEX", "" + i),
				"Name");
		if (name.isEmpty()) {
           throw new NoSuchIndexAtHtmlDocumentException();
		}
		return name;
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

	public Fair extracFairs(int i) throws Exception, NoSuchIndexAtHtmlDocumentException {

		return new Fair(findName(i), findDate(i), findPlace(i),
				findDescription(i));

	}

}