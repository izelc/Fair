package com.cavusoglu.fair;


public class ExtractorAnfas extends Extractor {

	public ExtractorAnfas() {
		documentFetcher = new DocumentFetcher(
				"http://www.anfas.com.tr/gelecek_fuarlar.html",
				"#subpage-content");
		documentSearcher = new DocumentSearcher(documentFetcher);
		cssPathForDate = "> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(2)";
		cssPathForName = "> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(1) > td > strong";
		cssPathForDescription = "> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(3)";

	}

	
	
	@Override
	public String getDateSplitterRegex() {
		return "\\s+";
	}

	@Override
	public String findPlace(int i) {

		return "ANTALYA EXPO CENTER";
	}

}
