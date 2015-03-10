package com.cavusoglu.fair;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorCnrExpoTest {

ExtractorCnrExpo extractorCnrExpo ;
	
	@Before
	public void before() throws IOException {

		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleCnr.aspx"));
		Mockito.doReturn(doc.select("#aspnetForm > div.sayfa > div.left_content > div > div.takvim_orta")).when(mock).getElement();
		extractorCnrExpo = new ExtractorCnrExpo(mock);
	}
	
	@Test
	public void prepareDate() throws Exception {
		 System.out.println(extractorCnrExpo.extracFairs(2).toString());
	 	}
	
	@Test
	public void findPlace() throws Exception {
       System.out.println(extractorCnrExpo.findPlace(2));		
	}
}
