package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TuyapCalendarTest {
	
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
	public void testTuyapCalendar() throws Exception, UnidentifiedMonthNameStrikeException {

	

		Fair fair = new Fair("ÇUKUROVA KİTAP FUARI","2015-01-13T00:00:00.000+02:00", "2015-01-18T00:00:00.000+02:00",
				"Tüyap Adana", "ÇUKUROVA KİTAP FUARI Çukurova 8. Kitap Fuarı");
		TuyapFairCalendar tuyapFairCalendar = new TuyapFairCalendar(tuyapExtractor);
		assertEquals(fair.getJsonLdObject(), tuyapFairCalendar.getFairList().get(0));
            
	}
	/**
	 * Reads file from given path
	 * 
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
