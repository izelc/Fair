package com.cavusoglu.fair;

public class ExtractorTuyap extends Extractor {

	public ExtractorTuyap(DocumentFetcher documentFetcher) {
		super(documentFetcher);
		cssPathForDate = "> tr:nth-child(MYINDEX) > td:nth-child(3) > h5 > b";
		cssPathForPlace = "> tr:nth-child(MYINDEX) > td:nth-child(3) > b > span";

		cssPathForName = "> tr:nth-child(MYINDEX) > td:nth-child(2) > h5 > strong";

		cssPathForDescription = "> tr:nth-child(MYINDEX) > td:nth-child(2)";
	}

	public ExtractorTuyap() {

		documentFetcher = new DocumentFetcher(
				"http://www.tuyap.com.tr/tr/index.php?main=m_fuar-2015&left=l_fuarlar&FuarYili=2015",
				"body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody");
		documentSearcher = new DocumentSearcher(documentFetcher);
		
		cssPathForDate = "> tr:nth-child(MYINDEX) > td:nth-child(3) > h5 > b";
		cssPathForPlace = "> tr:nth-child(MYINDEX) > td:nth-child(3) > b > span";
		cssPathForName = "> tr:nth-child(MYINDEX) > td:nth-child(2) > h5 > strong";
		cssPathForDescription = "> tr:nth-child(MYINDEX) > td:nth-child(2)";
	}



}
