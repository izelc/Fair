package com.cavusoglu.fair;

public class ExtractorAkort extends Extractor {
	public ExtractorAkort() {
		cssPathForMain = "body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul";

		cssPathForDate = "> li:nth-child(MYINDEX) > div > p:nth-child(3)";

		cssPathForName = "> li:nth-child(MYINDEX) > div > h2";

		cssPathForDescription = "> li:nth-child(MYINDEX) > div > p:nth-child(2)";
		
		documentFetcher = new DocumentFetcher(
				"http://akort.com/akort-fuarlari.html",cssPathForMain
				);
		documentSearcher = new DocumentSearcher(null);
	}
	
	public ExtractorAkort(DocumentFetcher documentFetcher) {
		
		documentSearcher = new DocumentSearcher(null);

		cssPathForDate = "> li:nth-child(MYINDEX) > div > p:nth-child(3)";

		cssPathForName = "> li:nth-child(MYINDEX) > div > h2";

		cssPathForDescription = "> li:nth-child(MYINDEX) > div > p:nth-child(2)";
		
		cssPathForMain = "body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul";
	}



	@Override
	public String findPlace(int i) {
		return "Gaziantep Ortadoğu Fuar Merkezi";
	}

}
