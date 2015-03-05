package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class TuyapCalendarTest {
	
	
	TuyapExtractor mock = Mockito.spy(new TuyapExtractor());

	@Test
	public void testTuyapCalendar() throws Exception, UnidentifiedMonthNameStrike {

		DateInterval interval = new DateInterval("1993-01-01", "1993-01-01");
		Mockito.doReturn(interval).when(mock)
				.extractDateInterval(Matchers.anyInt());
		Mockito.doReturn("mobilya fuari").when(mock)
				.extractFairName(Matchers.anyInt());
		Mockito.doReturn("izmir").when(mock)
				.extractFairPlace(Matchers.anyInt());
		Mockito.doReturn("asdf").when(mock)
				.extractFairDescription(Matchers.anyInt());

		Fair fair = new Fair("mobilya fuari", "1993-01-01", "1993-01-01",
				"izmir", "asdf");
		TuyapFairCalendar tuyapFairCalendar = new TuyapFairCalendar(mock);
		assertEquals(fair.getJsonLdObject(), tuyapFairCalendar.fairList.get(2));

	}

}
