package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFairCalendarCreator {
@Test
public void testName() throws Exception {
	
	ExtractorIzfas extractorIzfas=new ExtractorIzfas();
	FairCalendarCreator fairCalendarCreator=new FairCalendarCreator(extractorIzfas, 2, 12, 1);
	
	
	for (int i = 2; i < fairCalendarCreator.getFairCalendar().size(); i++) {
		System.out.println(fairCalendarCreator.getFairCalendar().get(i));
	}
	
}
}
