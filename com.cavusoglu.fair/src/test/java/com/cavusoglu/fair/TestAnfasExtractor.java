package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnfasExtractor {
	//2den basliyor 1er artiyor son element 14
	
	ExtractorAnfas extractorAnfas = new ExtractorAnfas();
	
	
	
	@Test
	public void testList() throws Exception {
		for (int j = 2; j < 15; j++) {
			System.err.println(extractorAnfas.extracFairs(j));
		}
	}
	
	
	@Test
	public void testName() throws Exception {
	 String dateSplitterRegex = extractorAnfas.getDateSplitterRegex();
	assertEquals( "\\s+", dateSplitterRegex);
	}
	
	

}
