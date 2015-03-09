package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtractorIzfasTest {

	ExtractorIzfas extractorIzfas=new ExtractorIzfas();
	@Test
	public void testList() throws Exception {
	    for (int i = 2; i < 13; i++) {
	    	System.err.println(extractorIzfas.extracFairs(i).toString());
			
		}
	}
}
