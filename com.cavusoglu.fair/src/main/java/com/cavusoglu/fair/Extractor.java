package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class Extractor {

	protected Logger logger = Logger.getLogger(getClass());

	protected DocumentSearcher documentSearcher;

	private String cssPathForPlace;
	private String cssPathForName;
	private String cssPathForDescription;
	private String cssPathForDate;
	private String cssPathForMain;
	private String siteLink;

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

		this.setCssPathForPlace(cssPathForPlace);
		this.setCssPathForName(cssPathForName);
		this.setCssPathForDescription(cssPathForDescription);
		this.setCssPathForDate(cssPathForDate);
		this.setCssPathForMain(cssPathForMain);
		this.setSiteLink(siteLink);


		documentSearcher = new DocumentSearcher(new StableElementFetcher(
				documentFetcher, cssPathForMain));
	}

	public Extractor(String siteLink, String cssPathForMain,
			String cssPathForName, String cssPathForDate,
			String cssPathForDescription, String cssPathForPlace) {

		this.setCssPathForPlace(cssPathForPlace);
		this.setCssPathForName(cssPathForName);
		this.setCssPathForDescription(cssPathForDescription);
		this.setCssPathForDate(cssPathForDate);
		this.setCssPathForMain(cssPathForMain);
		this.setSiteLink(siteLink);

		logger.info("connnecting to site: " + siteLink);

		logger.info("Main css part is: " + cssPathForMain);
		documentSearcher = new DocumentSearcher(new StableElementFetcher(
				new DocumentFetcher(siteLink), cssPathForMain));
	}

	public Extractor() {
	}

	public Extractor(DocumentFetcher documentFetcher) {
	}

	public String getDateSplitterRegex() {
		return "\\-";
	}

	public DateInterval findDate(int i) {
		String date = findFairAttribute(i,
				getCssPathForDate().replace("MYINDEX", "" + i), "Date");
		logger.info("Date is extracted " + date + " with css path "
				+ getCssPathForDate());

		DateInterval interval;
		interval = new DateInterval().getInterval(date, getDateSplitterRegex());

		logger.info("Date is splitted.StartDate: " + interval.getStartDate()
				+ "EndDate" + interval.getEndDate());
		return interval;
	}

	public String findPlace(int i) {
		return findFairAttribute(i, getCssPathForPlace().replace("MYINDEX", "" + i),
				"Place");

	}

	public String findName(int i) throws NoSuchIndexAtHtmlDocumentException {
		String name = findFairAttribute(i,
				getCssPathForName().replace("MYINDEX", "" + i), "Name");
		if (name.isEmpty()) {
			throw new NoSuchIndexAtHtmlDocumentException();
		}
		return name;
	}

	public String findDescription(int i) {
		return findFairAttribute(i,
				getCssPathForDescription().replace("MYINDEX", "" + i), "Description");
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

	public Fair extracFairs(int i) throws Exception,
			NoSuchIndexAtHtmlDocumentException {

		return new Fair(findName(i), findDate(i), findPlace(i),
				findDescription(i));

	}

	protected String getCssPathForPlace() {
		return cssPathForPlace;
	}

	protected void setCssPathForPlace(String cssPathForPlace) {
		this.cssPathForPlace = cssPathForPlace;
	}

	protected String getCssPathForName() {
		return cssPathForName;
	}

	protected void setCssPathForName(String cssPathForName) {
		this.cssPathForName = cssPathForName;
	}

	protected String getCssPathForDescription() {
		return cssPathForDescription;
	}

	protected void setCssPathForDescription(String cssPathForDescription) {
		this.cssPathForDescription = cssPathForDescription;
	}

	protected String getCssPathForDate() {
		return cssPathForDate;
	}

	protected void setCssPathForDate(String cssPathForDate) {
		this.cssPathForDate = cssPathForDate;
	}

	protected String getCssPathForMain() {
		return cssPathForMain;
	}

	protected void setCssPathForMain(String cssPathForMain) {
		this.cssPathForMain = cssPathForMain;
	}

	protected String getSiteLink() {
		return siteLink;
	}

	protected void setSiteLink(String siteLink) {
		this.siteLink = siteLink;
	}

}