package com.cavusoglu.fair;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatePreparetorTest.class, DocumentSearcherTest.class,
		FairTest.class, TuyapCalendarTest.class, TuyapExtractorTest.class })
public class AllTests {

}
