package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorAkortTest {

	ExtractorAkort extractorAkort;
	private DocumentFetcher mock;

	@Before
	public void before() throws IOException {

		mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleAkort.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorAkort = new ExtractorAkort(mock);
	}

	@Test
	public void testList() throws Exception, NoSuchIndexAtHtmlDocumentException {
		DateInterval interval = new DateInterval().getInterval(
				"05 Şubat 2015-08 Şubat 2015", "-");
		Fair fair = new Fair("GAPTARIM", interval,
				"Gaziantep Ortadoğu Fuar Merkezi",
				"Tarım, Tarım Teknolojileri ve Hayvancılık Fuarı");
		assertEquals(fair.toString(), extractorAkort.extracFairs(1).toString());

		// for (int j = 1; j < 2; j++) {
		// System.err.println(extractrtorAkort.extracFairs(j));
		// }

	}

}
