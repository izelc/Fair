package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindDate {
	
@Test
public void testName() throws Exception {
	
	Extractor extractor=new ExtractorAkort();
	System.err.println(extractor.findDate(2));
	
	extractor=new ExtractorAnfas();
	System.err.println(extractor.findDate(2));
	
	
	extractor=new ExtractorCnrExpo();
	System.err.println(extractor.findDate(2));
	
	extractor=new ExtractorIzfas();
	System.err.println(extractor.findDate(2));
	
//	extractor=new ExtractorMeridyen();
//	System.err.println(extractor.findDate(2));
	
	extractor=new ExtractorOrion();
	System.err.println(extractor.findDate(2));
	
	extractor=new ExtractorTuyap();
	System.err.println(extractor.findDate(2));
	

}

}
