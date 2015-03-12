package com.cavusoglu.fair;

import org.junit.Test;

public class DocumentFetcherTest {
	@Test
	public void testName() throws Exception {
		DocumentFetcher documentFetcher = new DocumentFetcher("http://www.meridyenfair.com/2015-fuar-takvimi/");
		System.out.println(documentFetcher.getDocument());

	}
}
