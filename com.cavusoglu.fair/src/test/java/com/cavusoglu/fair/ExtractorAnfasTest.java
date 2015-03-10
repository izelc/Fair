package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorAnfasTest {
	
ExtractorAnfas extractorAnfas ;
	
	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleAnfas.html"));
		Mockito.doReturn(doc.select("#subpage-content")).when(mock).getElement();
		extractorAnfas = new ExtractorAnfas(mock);
	}
	
	@Test
	public void testList() throws Exception {
		for (int j = 2; j < 15; j++) {
			System.err.println(extractorAnfas.extracFairs(j));
		}
	}
	
	
	@Test
	public void testName() throws Exception {
	 String dateSplitterRegex = extractorAnfas.getDateSplitterRegex();
	assertEquals( "\\s+", dateSplitterRegex);
	}

}
