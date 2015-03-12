package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
	public void testName() throws Exception {
		Exception expectedException = null;
		DocumentFetcher documentFetcher = new DocumentFetcher(
				"http://www.izfas.com.tr/");
		StableElementFetcher stableElementFetcher = new StableElementFetcher(
				documentFetcher, "Naughty Css");
		try {
			Elements element = stableElementFetcher.getElement();
		} catch (Exception e) {
			expectedException = e;
		}

		assertTrue(expectedException instanceof UnvalidCssPathException);
	}
	
	
	
	@Test
	public void testNam() throws Exception {
//		ExtractorMeridyen extractorMeridyen = new ExtractorMeridyen();
//		extractorMeridyen.stableElementFetcher.getElement();
		
		DocumentFetcher documentFetcher=new DocumentFetcher("http://www.meridyenfair.com/2015-fuar-takvimi/");
		StableElementFetcher stf=new StableElementFetcher(documentFetcher,"#ai1ec-calendar-view > div.ai1ec-agenda-view");
		stf.getElement();
	}

}
