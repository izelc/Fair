package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class TuyapExtractorTest {

	private TuyapExtractor tuyapExtractor;

	@Before
	public void before() throws IOException {
		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(readFile("ExampleTuyap.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		DocumentSearcher documentSearcher = new DocumentSearcher(mock);
		tuyapExtractor = new TuyapExtractor(documentSearcher);

	}

	

	 @Test
	 public void testExtractFairDate1() throws Exception {
	
	 assertEquals("22 - 25 Ocak 2015",
	 tuyapExtractor.extractFairDate(4));
	 }
	

	
	 @Test
	 public void testExtractDescription() throws Exception {
	 assertEquals("ÇUKUROVA KİTAP FUARI Çukurova 8. Kitap Fuarı",tuyapExtractor.extractFairDescription(1));
	 
	 }
	
	
	 @Test
	 public void testExtractFairPlace() throws Exception {
	 assertEquals("Tüyap Adana",tuyapExtractor.extractFairPlace(1));
	 }

	
	
	 @Test
	 public void testExtractFairName() throws Exception {
	 assertEquals("ÇUKUROVA KİTAP FUARI",tuyapExtractor.extractFairName(1));
	 }

	 @Test
	 public void testExtractDateInterval() throws Exception,
	 UnidentifiedMonthNameStrikeException {
	
	 TuyapExtractor mockTuyapExtractor = Mockito.spy(tuyapExtractor);
	 Mockito.doReturn("22 - 25 Mart 2015").when(mockTuyapExtractor).extractFairDate(Matchers.anyInt());
    assertEquals("2015-03-22T00:00:00.000+02:00",mockTuyapExtractor.extractDateInterval(1).getEndDate());
	
	
	
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
