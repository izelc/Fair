package com.cavusoglu.fair;

public class ExtractorIzfas extends Extractor {

	public ExtractorIzfas() {

		documentFetcher = new DocumentFetcher(
				"http://www.izfas.com.tr/tr/fuarlar/fuar-takvimi/",
				"#sol-icerik > div.ictable > tbody");
		documentSearcher = new DocumentSearcher(null);

		cssPathForDate = "> tr:nth-child(MYINDEX) > td:nth-child(2) > p";
		cssPathForPlace = "> tr:nth-child(MYINDEX) > td:nth-child(4) > p";
		cssPathForName="> tr:nth-child(MYINDEX) > td:nth-child(1) > p";
		cssPathForDescription="> tr:nth-child(MYINDEX) > td:nth-child(3) > p";
	}

	public ExtractorIzfas(DocumentFetcher mock) {
		documentSearcher = new DocumentSearcher(null);

		cssPathForDate = "> tr:nth-child(MYINDEX) > td:nth-child(2) > p";
		cssPathForPlace = "> tr:nth-child(MYINDEX) > td:nth-child(4) > p";
		cssPathForName="> tr:nth-child(MYINDEX) > td:nth-child(1) > p";
		cssPathForDescription="> tr:nth-child(MYINDEX) > td:nth-child(3) > p";
	}

	


}
