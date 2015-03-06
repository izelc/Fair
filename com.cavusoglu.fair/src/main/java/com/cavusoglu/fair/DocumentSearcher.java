package com.cavusoglu.fair;

import org.apache.log4j.Logger;
import org.jsoup.select.Elements;

/**
 * @author izel Class is implemented for searching on particular element of
 *         "http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015"
 *         >tuyap.com</a>
 * 
 */
public class DocumentSearcher {
	private Logger logger = Logger.getLogger(getClass());
	private DocumentFetcher df;
	private Elements fixedPart;

	public DocumentSearcher(DocumentFetcher df) {
		this.df = df;
		fixedPart = df
				.getDocument()
				.select("body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody");
	}

	public DocumentSearcher() {
		df = new DocumentFetcher();
		fixedPart = df
				.getDocument()
				.select("body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody");
	}

	public String extractElementWithCssPAth(String cssPath) {

		logger.trace("getting element with css path"
				+ "body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody"
				+ cssPath);
		try {
			return fixedPart.select(cssPath).text();
		} catch (Exception e) {
			logger.error("cssPath is not valid.");
			return null;
		}
	}

}
