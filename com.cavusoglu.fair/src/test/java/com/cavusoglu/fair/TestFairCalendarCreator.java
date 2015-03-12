package com.cavusoglu.fair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonArray;

public class TestFairCalendarCreator {

	private JsonArray fairlist;

	@Before
	public void before() {
		fairlist = new JsonArray();
		DateInterval interval = new DateInterval().getInterval(
				"12 - 15 Şubat 2015", "\\-");
		Fair fair = new Fair(
				"AGROEXPO 2015 10. Uluslararası Tarım Sera ve Hayvancılık Fuarı",
				interval, "Uluslararası İzmir Fuar Alanı", "Orion Fuarcilik");
		fairlist.add(fair.getJsonLdObject());

		interval = new DateInterval().getInterval("11 - 15 Mart 2015", "\\-");
		fair = new Fair(
				"AEGEANAGRI 2015 11. Ege Tarım Sera ve Hayvancılık Fuarı",
				interval, "EGS Park Fuar Alanı - DENİZLİ", "Orion Fuarcilik");
		fairlist.add(fair.getJsonLdObject());

		interval = new DateInterval().getInterval("12 - 15 Şubat 2015", "\\-");
		fair = new Fair(
				"ANIMALEXPO 2015 6. Uluslararası Hayvancılık Teknolojileri ve Süt Endüstrisi Fuarı",
				interval, "İzmir Uluslararası Fuar Alanı", "Orion Fuarcilik");
		fairlist.add(fair.getJsonLdObject());
	}

	@Test
	public void testName() throws Exception {

		ExtractorOrion extractorOrion = new ExtractorOrion();
		FairCalendarCreator fairCalendarCreator = new FairCalendarCreator(
				extractorOrion, 0, 2, 1);

		for (int i = 0; i < fairCalendarCreator.getFairCalendar().size(); i++) {
			assertEquals(fairlist.get(i).toString(), fairCalendarCreator
					.getFairCalendar().get(i).toString());
		}

	}
}
