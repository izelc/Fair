package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFairCalendarCreator {
@Test
public void testName() throws Exception {
	
	ExtractorOrion extractorOrion=new ExtractorOrion();
	FairCalendarCreator fairCalendarCreator=new FairCalendarCreator(extractorOrion, 0, 2, 1);
	
	
	for (int i = 0; i < fairCalendarCreator.getFairCalendar().size(); i++) {
		System.out.println(fairCalendarCreator.getFairCalendar().get(i));
	}
	
}
}
