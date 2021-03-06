package com.cavusoglu.fair;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author izel This class is implemented for getting document from given site
 *         also it enables user to enter main and stable css query part that
 *         user wants to use on searches.
 */

public class DocumentFetcher {

	private Logger logger = Logger.getLogger(getClass());
	private Document document;


	public DocumentFetcher() {

	}

	public DocumentFetcher(String siteLink) {
		try {
			logger.trace("Getting document");
			document = Jsoup
					.connect(siteLink)
					.userAgent(
							"Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52")
					.get();
		} catch (IOException e) {
			logger.error("Error occured while getting document from "
					+ siteLink, e);
		}

	}

	

	public Document getDocument() {
		return document;
	}

	

}
