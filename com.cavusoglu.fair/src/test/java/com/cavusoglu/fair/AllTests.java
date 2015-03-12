package com.cavusoglu.fair;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DateIntervalCreatorTest.class,DocumentFetcherTest.class,DocumentSearcherTest.class,ExtractorAkortTest.class,
	ExtractorAnfasTest.class, ExtractorCnrExpoTest.class, ExtractorIzfasTest.class,ExtractorMeridyenTest.class,ExtractorOrionTest.class,
	ExtractorTuyapTest.class,StableElementFetcherTest.class,TestFairCalendarCreator.class,
		FairTest.class, ExtractorTest.class })
public class AllTests {

}
