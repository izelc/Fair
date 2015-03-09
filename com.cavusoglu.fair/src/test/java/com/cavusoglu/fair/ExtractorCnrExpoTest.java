package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ExtractorCnrExpoTest {
	ExtractorCnrExpo extractorCnrExpo = new ExtractorCnrExpo();	 

	@Test
	public void prepareDate() throws Exception {
		 System.out.println(extractorCnrExpo.extracFairs(2).toString());
	 	}
	
	@Test
	public void findPlace() throws Exception {
       System.out.println(extractorCnrExpo.findPlace(2));		
	}
}
