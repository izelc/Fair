package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtractorMeridyenTest {
	
	ExtractorMeridyen extractorMeridyen = new ExtractorMeridyen();
	
	
	@Test
	public void List() throws Exception {
		for (int i = 1; i < 16; i++) {
		
			System.err.println(extractorMeridyen.extracFairs(i).toString());
		}
	}

}
