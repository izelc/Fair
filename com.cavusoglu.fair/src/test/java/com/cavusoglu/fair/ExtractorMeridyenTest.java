package com.cavusoglu.fair;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorMeridyenTest {

	ExtractorMeridyen extractorMeridyen;

	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleMeridyen.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorMeridyen = new ExtractorMeridyen(mock);
	}

	@Test
	public void List() throws Exception {
		for (int i = 1; i < 16; i++) {

			System.err.println(extractorMeridyen.extracFairs(i).toString());
		}

	}

	@Test
	public void testOneFair() throws Exception {

		DateInterval interval = new DateInterval().getInterval(
				"21 – 28 Ocak 2015", "\\-");
		Fair fair = new Fair("INTERNATIONAL FAIR OF KHARTOUM 2015 ", interval,
				" Hartum / Sudan", "-");
		assertEquals(fair.toString(), extractorMeridyen.extracFairs(1)
				.toString());

	}

}
