package com.cavusoglu.fair;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorAnfasTest {

	ExtractorAnfas extractorAnfas;

	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleAnfas.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorAnfas = new ExtractorAnfas(mock);
	}

	@Test
	public void testList() throws Exception, NoSuchIndexAtHtmlDocumentException {
		for (int j = 2; j < 15; j++) {
			System.err.println(extractorAnfas.extracFairs(j));
		}
	}

	@Test
	public void getDateSplitter() throws Exception {
		String dateSplitterRegex = extractorAnfas.getDateSplitterRegex();
		assertEquals("\\s+", dateSplitterRegex);
	}
	
	@Test
	public void testOneFair() throws Exception, NoSuchIndexAtHtmlDocumentException {
		
		 DateInterval interval = new DateInterval().getInterval("01-Nisan-2015 03-Nisan-2015", "\\s+");
	        Fair fair = new Fair("ANFAŞ CITY EXPO", interval,"ANTALYA EXPO CENTER", "  Şehircilik ve Teknolojileri Fuarı");
	        assertEquals(fair.toString(), extractorAnfas.extracFairs(2)
					.toString());
		
	}

}
