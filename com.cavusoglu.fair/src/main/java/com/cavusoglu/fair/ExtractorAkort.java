package com.cavusoglu.fair;

public class ExtractorAkort extends Extractor {
	
	public ExtractorAkort() {
		
		super(
				"http://akort.com/akort-fuarlari.html",
				"body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul",
				"> li:nth-child(MYINDEX) > div > h2",
				"> li:nth-child(MYINDEX) > div > p:nth-child(3)",
				"> li:nth-child(MYINDEX) > div > p:nth-child(2)",
				""
				);
	
	}
	
	public ExtractorAkort(DocumentFetcher documentFetcher) {
		
		super(  documentFetcher,
				"http://akort.com/akort-fuarlari.html",
				"body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul",
				"> li:nth-child(MYINDEX) > div > h2",
				"> li:nth-child(MYINDEX) > div > p:nth-child(3)",
				"> li:nth-child(MYINDEX) > div > p:nth-child(2)",
				""
				);
		
	}



	@Override
	public String findPlace(int i) {
		return "Gaziantep Ortadoğu Fuar Merkezi";
	}

}
