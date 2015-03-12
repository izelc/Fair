package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorIzfasTest {

	ExtractorIzfas extractorIzfas;
	private DocumentFetcher mock;

	@Before
	public void before() throws IOException {

		mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleIzfas.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorIzfas = new ExtractorIzfas(mock);
	}

	@Test
	public void testList() throws Exception, NoSuchIndexAtHtmlDocumentException {
		for (int j = 2; j < 5; j++) {
			System.err.println(extractorIzfas.extracFairs(j));
		}

	}

	@Test
	public void testOneFair() throws Exception, NoSuchIndexAtHtmlDocumentException {

		DateInterval interval = new DateInterval().getInterval(
				"4-7 ŞUBAT", "\\-");
		Fair fair = new Fair("IF WEDDING FASHION İZMİR", interval,
				"İzmir Uluslararası Fuar Alanı - Kültürpark",
				"9. Gelinlik, Damatlık ve Abiye Giyim Fuarı");
		assertEquals(fair.toString(), extractorIzfas.extracFairs(2).toString());

	}
}
