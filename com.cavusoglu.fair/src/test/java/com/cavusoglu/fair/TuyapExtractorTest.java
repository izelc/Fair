package com.cavusoglu.fair;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class TuyapExtractorTest {
	DocumentFetcher mockDocumentFetcher= Mockito.spy(new DocumentFetcher());
	DocumentSearcher documentSearcher=new DocumentSearcher(mockDocumentFetcher);
	TuyapExtractor tuyapExtractor=new TuyapExtractor(documentSearcher);
	
	
	//DocumentSearcher  mockDocumentSearcher= Mockito.mock(DocumentSearcher.class);
	
	@Before
	public void before() throws IOException {
		Document doc = Jsoup.parse(readFile("ExampleTuyap.html"));
		Mockito.doReturn(doc).when(mockDocumentFetcher).getDocument();
	 //  Mockito.doReturn("mocking").when(mockDocumentSearcher).extractElementWithCssPAth(Matchers.anyString());
	}

//	@Test
//	public void testExtractFairDate() throws Exception {
//
//		assertEquals("22 - 25 Ocak 2015",
//				new TuyapExtractor().extractFairDate(4));
//	}
//	
//	@Test
//	public void testExtractDescription2() throws Exception {
//		documentSearcher.extractElementWithCssPAth(cssPath)
//			assertEquals("mocking",tuyapExtractor.extractFairDescription(1));
//	}
//
//	@Test
//	public void testExtractDescription() throws Exception {
//			assertEquals("mocking",new TuyapExtractor(mockDocumentSearcher).extractFairDescription(1));
//	}
//	
//	
//	@Test
//	public void testExtractFairPlace() throws Exception {
//			assertEquals("mocking",new TuyapExtractor(mockDocumentSearcher).extractFairPlace(1));
//	}
//	
//	@Test
//	public void testExtractFairDate() throws Exception {
//			assertEquals("mocking",new TuyapExtractor(mockDocumentSearcher).extractFairDate(1));
//	}
//	
//	
//	
//	@Test
//	public void testExtractFairName() throws Exception {
//			assertEquals("mocking",new TuyapExtractor(mockDocumentSearcher).extractFairName(1));
//	}
	
@Test
public void testExtractDateInterval() throws Exception, UnidentifiedMonthNameStrike {
	
	TuyapExtractor mock = Mockito.spy(new TuyapExtractor());
	Mockito.doReturn("22 - 25 Mart 2015").when(mock).extractFairDate(Matchers.anyInt());
	assertEquals("2015-03-22T00:00:00.000+02:00",mock.extractDateInterval(1).getEndDate());
	
	

}

/**
 * Reads file from given path
 * 
 * @param path
 *            file path
 * @return file as string text
 * @throws IOException
 */
private String readFile(String path) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(path));
	String everything;
	try {
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		everything = sb.toString();
	} finally {
		br.close();
	}
	return everything;
}
	
	

}
