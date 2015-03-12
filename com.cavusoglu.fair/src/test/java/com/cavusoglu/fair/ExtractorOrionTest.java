package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorOrionTest {
	ExtractorOrion extractorOrion;
	
	@Before
	public void before() throws IOException {

		DocumentFetcher mock1 = Mockito.spy(new DocumentFetcher());
		Document doc1 = Jsoup.parse(ReadFile.readFile("orion1.html"));
		DocumentFetcher mock2 = Mockito.spy(new DocumentFetcher());
		Document doc2 = Jsoup.parse(ReadFile.readFile("orion2.html"));
		DocumentFetcher mock3 = Mockito.spy(new DocumentFetcher());
		Document doc3 = Jsoup.parse(ReadFile.readFile("orion3.html"));
		Mockito.doReturn(doc1).when(mock1).getDocument();
		Mockito.doReturn(doc2).when(mock2).getDocument();
		Mockito.doReturn(doc3).when(mock3).getDocument();

		extractorOrion= new ExtractorOrion(mock1,mock2,mock3);
	}

	@Test
	public void testFindName() throws Exception {
		assertEquals(
				"ANIMALEXPO 2015 6. Uluslararası Hayvancılık Teknolojileri ve Süt Endüstrisi Fuarı",
				extractorOrion.findName(2));
	}

	@Test
	public void testFindPlace() throws Exception {
		assertEquals("EGS Park Fuar Alanı - DENİZLİ",
				extractorOrion.findPlace(1));

	}

	@Test
	public void testPrepareDate() throws Exception {
		assertEquals("2015-03-15T00:00:00.000+02:00", extractorOrion
				.findDate(1).getEndDate());
		assertEquals("2015-03-11T00:00:00.000+02:00", extractorOrion
				.findDate(1).getStartDate());

	}

	@Test
	public void testExtractFais() throws Exception,
			NoSuchIndexAtHtmlDocumentException {

		for (int i = 0; i < 3; i++) {
			System.err.println(extractorOrion.extracFairs(i).toString());

		}
	}

	@Test
	public void testFair1() throws Exception,
			NoSuchIndexAtHtmlDocumentException {
		DateInterval interval = new DateInterval().getInterval(
				"12 - 15 Şubat 2015", "\\-");
		Fair fair1 = new Fair(
				"AGROEXPO 2015 10. Uluslararası Tarım Sera ve Hayvancılık Fuarı",
				interval, "Uluslararası İzmir Fuar Alanı", "Orion Fuarcilik");
		
		interval = new DateInterval().getInterval("11 - 15 Mart 2015", "\\-");
		Fair fair2 = new Fair(
"AEGEANAGRI 2015 11. Ege Tarım Sera ve Hayvancılık Fuarı",
				interval, "EGS Park Fuar Alanı - DENİZLİ", "Orion Fuarcilik");
		
		interval = new DateInterval().getInterval("12 - 15 Şubat 2015", "\\-");
		Fair fair3 = new Fair(
				"ANIMALEXPO 2015 6. Uluslararası Hayvancılık Teknolojileri ve Süt Endüstrisi Fuarı",
				interval, "İzmir Uluslararası Fuar Alanı", "Orion Fuarcilik");
		assertEquals(fair1.toString(), extractorOrion.extracFairs(0).toString());
		assertEquals(fair2.toString(), extractorOrion.extracFairs(1).toString());
		assertEquals(fair3.toString(), extractorOrion.extracFairs(2).toString());
		

	}

}
