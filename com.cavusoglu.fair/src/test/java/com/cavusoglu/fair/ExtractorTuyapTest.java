package com.cavusoglu.fair;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ExtractorTuyapTest {

	ExtractorTuyap extractorTuyap;
	private DocumentFetcher mock;

	@Before
	public void before() throws IOException {

		mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(ReadFile.readFile("exampleTuyap.php?main=m_fuar-2015"));
		Mockito.doReturn(doc).when(mock).getDocument();

		extractorTuyap = new ExtractorTuyap(mock);
	}

	@Test
	public void testList() throws Exception, NoSuchIndexAtHtmlDocumentException {
		for (int j = 1; j < 15; j+=3) {
			System.err.println(extractorTuyap.extracFairs(j));
		}
	}
}
