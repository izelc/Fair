package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class DocumentSearcherTest {

	@Test
	public void testExtractElementWithCssPAth() throws Exception {
		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		StableElementFetcher stableElementFetcher=new StableElementFetcher(mock,"#subpage-content");
		DocumentSearcher documentSearcher=new DocumentSearcher(stableElementFetcher);
	
		Document doc = Jsoup.parse(ReadFile.readFile("exampleAnfas.html"));
		Mockito.doReturn(doc).when(mock).getDocument();
		
		
		
	

		  String cssPath = "> div:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2)";
		  assertEquals("01-Nisan-2015 03-Nisan-2015", documentSearcher.extractElementWithCssPAth(cssPath));

	}

}
