package com.cavusoglu.fair;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorAkortTest {
	
	
	ExtractorAkort extractorAkort ;
	
	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleAkort.html"));
		Mockito.doReturn(doc.select("body > div.main-wrapper > div.alt-sayfa-content-wrapper > div > div > ul")).when(mock).getElement();
		extractorAkort = new ExtractorAkort(mock);
	}
	
	
	@Test
	public void testList() throws Exception {
		for (int j = 1; j < 8; j++) {
			System.err.println(extractorAkort.extracFairs(j));
		}
		
	}


}
