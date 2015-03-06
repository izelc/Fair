package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatePreparetorTest {

	@Test
	public void testSplitDate() throws Exception {
		DateInterval dateInterval = new DatePreparator()
				.splitDate("22 - 25 Ocak 2015");
		assertEquals("22 Ocak 2015", dateInterval.getEndDate());
		assertEquals("25 Ocak 2015", dateInterval.getStartDate());

	}

	@Test
	public void testGetRidOfTurkishMonths() throws Exception, UnidentifiedMonthNameStrikeException {
		DateInterval dateInterval = new DatePreparator()
				.splitDate("22 - 25 Ocak 2015");
		new DatePreparator().getRidOfTurkishMonths(dateInterval);
		assertEquals("22/01/2015", dateInterval.getEndDate());
	}

	@Test
	public void testConvertToIsoFormat() throws Exception, UnidentifiedMonthNameStrikeException {
		DateInterval splitAndConvertToIso = new DatePreparator()
				.splitAndConvertToIso("22 - 25 Ocak 2015");
		String endDate = splitAndConvertToIso.getEndDate();
		String startDate = splitAndConvertToIso.getStartDate();

		assertEquals("2015-01-22T00:00:00.000+02:00", endDate);
		assertEquals("2015-01-25T00:00:00.000+02:00", startDate);
	}
}
