package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DateIntervalCreatorTest {

	ArrayList<String> dates = new ArrayList<String>();
	DateInterval dateInterval = new DateInterval();
	private static boolean setUpIsDone = false;

	@Before
	public void setUp() {
		if (setUpIsDone) {
			return;
		}

		dates.add("05 Şubat 2015-08 Şubat 2015");
		dates.add("4-7 ŞUBAT");
		dates.add("12 - 15 Şubat 2015");
		dates.add("30 KASIM - 2 AĞUSTOS");
		dates.add("30 KASIM – 2 EYLÜL");
		dates.add("01-Nisan-2015 03-Nisan-2015");
		dates.add("(15.01.2015 - 18.01.2015)");
		setUpIsDone = true;
	}

	@Test
	public void getIntervalNumeric() throws Exception {
		String date = "(15.01.2015 - 18.01.2015)";
		date = date.replace("(", "");
		date = date.replace(")", "");
		assertEquals("2015-01-18T00:00:00.000+02:00",
				(dateInterval.getIntervalForNumericMonths(date, "\\-")
						.getEndDate()));
	}
	
	@Test
	public void testConvertToIsoFormat() throws Exception {
		String dateWithIsoFormat = new DateInterval()
				.convertToIsoFormat("22/01/2005");
		

		assertEquals("2005-01-22T00:00:00.000+02:00", dateWithIsoFormat);
	}

	@Test
	public void getInterval() throws Exception {

		assertEquals("2015-02-08T00:00:00.000+02:00",
				dateInterval.getInterval(dates.get(0), "\\-").getEndDate());

		for (int i = 0; i < 5; i++) {
			System.err.println(dateInterval.getInterval(dates.get(i), "\\-")
					.getEndDate());

		}

	}

	@Test
	public void getRidOfTurkishCharacters() throws Exception {
		String strLower = new DateInterval()
				.getRidOfTurkishCharacters("ığüşçöİĞÜŞÇÖ");
		assertEquals("iguscoIGUSCO", strLower);
	}

	@Test
	public void replaceMonthsWithNumericEquivalents() throws Exception {
		assertEquals("15/01/2014",
				dateInterval.replaceMonthNameWithMonthNumber("15OCak2014"));
		assertEquals("/04/",
				dateInterval.replaceMonthNameWithMonthNumber("NISAN"));

	}

	@Test
	public void removePunctuation() throws Exception {
		DateInterval dateInterval = new DateInterval();
		assertEquals(
				"testtesttest5564",
				dateInterval
						.removePunctuationAndBlankSpaces("test,test-,test=5564"));

	}

	@Test
	public void splitDate() throws Exception {
		DateInterval splitDate = dateInterval.splitDate(
				"01-Nisan-2015 03-Nisan-2015", "\\s+");
		System.err.println(splitDate.getEndDate());
	}
}
