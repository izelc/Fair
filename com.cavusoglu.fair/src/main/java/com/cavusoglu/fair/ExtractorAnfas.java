package com.cavusoglu.fair;

public class ExtractorAnfas extends Extractor {

	public ExtractorAnfas() {

		super(
				"http://www.anfas.com.tr/gelecek_fuarlar.html",
				"#subpage-content",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(1) > td > strong",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(2)",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(3)",
				"");

	}

	public ExtractorAnfas(DocumentFetcher mock) {

		super(
				mock,
				"http://www.anfas.com.tr/gelecek_fuarlar.html",
				"#subpage-content",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(1) > td > strong",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(2)",
				"> div:nth-child(MYINDEX) > table > tbody > tr:nth-child(2) > td:nth-child(3)",
				"");

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
