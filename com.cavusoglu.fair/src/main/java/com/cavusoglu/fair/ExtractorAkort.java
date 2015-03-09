package com.cavusoglu.fair;

public class ExtractorAkort extends Extractor {
	public ExtractorAkort() {
		documentFetcher = new DocumentFetcher(
				"http://akort.com/akort-fuarlari.html",
				"body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul");
		documentSearcher = new DocumentSearcher(documentFetcher);

		cssPathForDate = "> li:nth-child(MYINDEX) > div > p:nth-child(3)";

		cssPathForName = "> li:nth-child(MYINDEX) > div > h2";

		cssPathForDescription = "> li:nth-child(MYINDEX) > div > p:nth-child(2)";
	}



	@Override
	public String findPlace(int i) {
		return "Gaziantep Ortadoğu Fuar Merkezi";
	}

}
