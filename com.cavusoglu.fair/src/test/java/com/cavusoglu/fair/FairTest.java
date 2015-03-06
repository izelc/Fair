package com.cavusoglu.fair;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FairTest {

	TuyapExtractor tuyapExtractor = new TuyapExtractor();
	int i = 1;

	@Test
	public void testGetJsonLdObject() throws Exception, UnidentifiedMonthNameStrikeException {
		Fair fair = new Fair(tuyapExtractor.extractFairName(1), tuyapExtractor
				.extractDateInterval(1).getStartDate(), tuyapExtractor
				.extractDateInterval(1).getStartDate(),
				tuyapExtractor.extractFairPlace(1),
				tuyapExtractor.extractFairDescription(1));
		assertTrue(fair.getJsonLdObject().isJsonObject());
	}

	// @Test
	// public void testFair() throws Exception {
	// Fair fair;
	// while (!tuyapExtractor.extractFairName(i).equals("")) {
	//
	// fair = new Fair(tuyapExtractor.extractFairName(i),
	// tuyapExtractor.extractDateInterval(i).getStartDate(),
	// tuyapExtractor.extractDateInterval(i).getEndDate(),
	// tuyapExtractor.extractFairPlace(i),
	// tuyapExtractor.extractFairDescription(i));
	// System.err.println(fair.getJsonLdObject().toString());
	// i = i + 3;
	// }
	//
	// }

}
