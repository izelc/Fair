package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorCnrExpoTest {

	ExtractorCnrExpo extractorCnrExpo;

	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleCnr.aspx"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorCnrExpo = new ExtractorCnrExpo(mock);
	}

	@Test
	public void testOneFair() throws Exception, NoSuchIndexAtHtmlDocumentException {

		DateInterval interval = new DateInterval().getIntervalForNumericMonths(
				"15.01.2015 - 18.01.2015", "\\-");
		Fair fair = new Fair("ANNE BEBEK ÇOCUK ÜRÜNLERİ FUARI", interval,
				"CNREXPO Fair Center",
				"27.ULUSLARARASI İSTANBUL ANNE BEBEK ÇOCUK ÜRÜNLERİ FUARI");
		assertEquals(fair.toString(), extractorCnrExpo.extracFairs(2)
				.toString());

	}

}
