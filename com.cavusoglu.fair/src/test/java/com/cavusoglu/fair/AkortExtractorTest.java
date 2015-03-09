package com.cavusoglu.fair;

import org.junit.Test;

public class AkortExtractorTest {
	
	ExtractorAkort ExtractorAkort = new ExtractorAkort();
	
	
	@Test
	public void testList() throws Exception {
		for (int j = 1; j < 8; j++) {
			System.err.println(ExtractorAkort.extracFairs(j));
		}
	}


}
