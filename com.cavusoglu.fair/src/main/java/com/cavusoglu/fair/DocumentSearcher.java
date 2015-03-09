package com.cavusoglu.fair;

import org.apache.log4j.Logger;

/**
 * @author izel Class is implemented for searching on particular element of
 *         "http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015"
 *         >tuyap.com</a>
 * 
 */
public class DocumentSearcher {
	private Logger logger = Logger.getLogger(getClass());
	private DocumentFetcher df;

	public DocumentSearcher(DocumentFetcher df) {
		this.df = df;
				
	}


	public String extractElementWithCssPAth(String cssPath) {

		logger.trace("getting element with changable css path"
				+ cssPath);
		try {
			return df.getElement().select(cssPath).text();
		} catch (Exception e) {
			logger.error("cssPath is not valid.");
			return null;
		}
	}

}
