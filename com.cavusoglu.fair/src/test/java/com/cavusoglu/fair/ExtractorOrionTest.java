package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtractorOrionTest {
	ExtractorOrion extractorOrion = new ExtractorOrion();

	@Test
	public void testFindName() throws Exception {
		System.err.println("sadasd");
		assertEquals(
				"ANIMALEXPO 2015 6. Uluslararası Hayvancılık Teknolojileri ve Süt Endüstrisi Fuarı",
				extractorOrion.findName(2));
	}

	

	@Test
	public void testFindPlace() throws Exception {
		assertEquals("EGS Park Fuar Alanı - DENİZLİ",
				extractorOrion.findPlace(1));

	}

	@Test
	public void testPrepareDate() throws Exception {
		assertEquals("2015-03-15T00:00:00.000+02:00", extractorOrion
				.findDate(1).getEndDate());
		assertEquals("2015-03-11T00:00:00.000+02:00", extractorOrion
				.findDate(1).getStartDate());

	}

	@Test
	public void testExtractFais() throws Exception {

		for (int i = 0; i < 2; i++) {
			System.err.println(extractorOrion.extracFairs(i).toString());

		}
	}

}
