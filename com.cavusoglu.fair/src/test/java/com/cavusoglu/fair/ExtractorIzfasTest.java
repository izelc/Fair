package com.cavusoglu.fair;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ExtractorIzfasTest {

ExtractorIzfas extractorIzfas ;
private DocumentFetcher mock;
	
	@Before
	public void before() throws IOException {

		mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleIzfas.html"));
		Mockito.doReturn(doc.select("#sol-icerik > div.ictable > tbody")).when(mock).getElement();
		Mockito.doReturn(doc).when(mock).getDocument();
		extractorIzfas = new ExtractorIzfas(mock);
	}
	@Test
	public void testList() throws Exception {
       System.out.println(mock.getDocument().select("#sol-icerik > div.icerik > table > tbody > tr:nth-child(2) > td:nth-child(1) > p").text());
		System.out.println(mock.getElement().select("> tr:nth-child(2) > td:nth-child(1) > p"));
	
	}
}
