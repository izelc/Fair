package com.cavusoglu.fair;

import org.apache.log4j.Logger;
import org.jsoup.select.Elements;

public class StableElementFetcher {

	private String fixedPart;
	DocumentFetcher documentFetcher;
	private Logger logger = Logger.getLogger(getClass());

	public StableElementFetcher(String fixedPart) {
		this.fixedPart = fixedPart;
	}

	public StableElementFetcher(DocumentFetcher documentFetcher,
			String fixedPart) {
		this.documentFetcher = documentFetcher;
		this.fixedPart = fixedPart;
	}

	public Elements getElement() throws Exception {

		logger.trace("Getting element stable css part " + fixedPart);
		Elements stableElement = documentFetcher.getDocument()
				.select(fixedPart);

		if (stableElement.isEmpty()) {
			logger.error("Stable css part is not valid");
			throw new UnvalidCssPathException(
					"Check the value you've given for fixed css path is belong to given page");

		}

		return stableElement;
	}

}
