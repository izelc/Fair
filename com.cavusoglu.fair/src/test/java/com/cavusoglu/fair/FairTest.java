package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FairTest {


	@Test
	public void testGetJsonLdObject() throws Exception{
		 DateInterval interval = new DateInterval().getInterval("01-Nisan-2015 03-Nisan-2015", "\\s+");
	     Fair fair = new Fair("ANFAŞ CITY EXPO", interval,"ANTALYA EXPO CENTER", "  Şehircilik ve Teknolojileri Fuarı");
		 
	     assertTrue(fair.getJsonLdObject().isJsonObject());
	     assertEquals("\"ANFAŞ CITY EXPO\"",fair.getJsonLdObject().get("name").toString());
	     assertEquals("\"ANTALYA EXPO CENTER\"",fair.getJsonLdObject().get("place").toString());
	     assertEquals("\"  Şehircilik ve Teknolojileri Fuarı\"",fair.getJsonLdObject().get("description").toString());
	     assertEquals("\"2015-04-03T00:00:00.000+03:00\"",fair.getJsonLdObject().get("endDate").toString());
	     assertEquals("\"2015-04-01T00:00:00.000+03:00\"",fair.getJsonLdObject().get("startDate").toString());
	}

	

}
