package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Mockito;

public class StableElementFetcherTest {

	@Test
	public void getElement() throws Exception {
		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile
				.readFile("exampleTuyap.php?main=m_fuar-2015"));
		Mockito.doReturn(doc).when(mock).getDocument();
		StableElementFetcher stableElementFetcher = new StableElementFetcher(
				mock,
				"body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody");
		assertFalse(stableElementFetcher.getElement().isEmpty());
		assertEquals(
				"�UKUROVA 7. K�TAP FUARI",
				stableElementFetcher
						.getElement()
						.select("> tr:nth-child(1) > td:nth-child(2) > h5 > strong")
						.text());

	}

	@Test
	public void testException() throws Exception {
		Exception expectedException = null;
		DocumentFetcher documentFetcher = new DocumentFetcher(
				"http://www.izfas.com.tr/");
		StableElementFetcher stableElementFetcher = new StableElementFetcher(
				documentFetcher, "Naughty Css");
		try {
			stableElementFetcher.getElement();
		} catch (Exception e) {
			expectedException = e;
		}

		assertTrue(expectedException instanceof UnvalidCssPathException);
	}

}
