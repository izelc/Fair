package com.cavusoglu.fair;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DocumentSearcher {
	private Logger logger = Logger.getLogger(getClass());
	DocumentFetcher df;
	String fixedCss;
	Elements fixedPart;

	public DocumentSearcher(DocumentFetcher df) {
		this.df = df;
		fixedCss = "body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody";
		fixedPart=df.getDocument().select(fixedCss);
	}

	public DocumentSearcher() {
		df = new DocumentFetcher();
		fixedCss = "body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody";
		fixedPart=df.getDocument().select(fixedCss);
	}

	public String extractElementWithCssPAth(String cssPath) {

		// logger.trace("getting element with css path" + cssPath);
		try {
			return fixedPart.select(cssPath).text();
		} catch (Exception e) {
			logger.error("cssPath is not valid.");
			return null;
		}
	}
	
	
	
	
}
