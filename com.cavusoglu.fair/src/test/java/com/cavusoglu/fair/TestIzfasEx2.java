package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIzfasEx2 {
	
	@Test
	public void testName() throws Exception {
		
		
		ExtractorIzfas extractorIzfas = new ExtractorIzfas();
		
		for (int i = 2; i < 10; i++) {
			System.err.println(extractorIzfas.extracFairs(i));
			
		}
		
		ExtractorTuyap extractorTuyap=new ExtractorTuyap();
		for (int i = 1; i < 40; i+=3) {
			System.out.println(extractorTuyap.extracFairs(i));
			
		}
		
		
	
		
		
	}
	

}
