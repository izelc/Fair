package com.cavusoglu.fair;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.cavusoglu.fair.DocumentFetcher;

/**
 * @author izel this class is implemented for getting document from <a href=
 *         "http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015"
 *         >tuyap</a>
 */

public class DocumentFetcher {

	private Logger logger = Logger.getLogger(getClass());
	private Document document;

	public DocumentFetcher() {
		try {
			logger.trace("Getting document from tuyap.com ");
			document = Jsoup
					.connect(
							"http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015")
					.get();
		} catch (IOException e) {
			logger.error("Error occured while getting document from tuyap ", e);
		}
	}

	public Document getDocument() {
		return document;
	}

	public Elements getElement() {
		return getDocument()
				.select("body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody");
	}
}
