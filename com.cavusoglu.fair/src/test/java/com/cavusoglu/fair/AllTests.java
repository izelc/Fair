package com.cavusoglu.fair;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DocumentSearcherTest.class,
		FairTest.class, ExtractorTest.class })
public class AllTests {

}
