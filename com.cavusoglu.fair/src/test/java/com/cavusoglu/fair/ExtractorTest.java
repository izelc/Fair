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

public class ExtractorTest {

	private ExtractorTuyap tuyapExtractor;

	@Before
	public void before() throws IOException {
		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(readFile("ExampleTuyap.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		tuyapExtractor = new ExtractorTuyap(mock);

	}

	@Test
	public void testExtractFairDate1() throws Exception {

		assertEquals("2015-01-22T00:00:00.000+02:00", tuyapExtractor
				.findDate(4).getStartDate());
	}

	@Test
	public void testExtractDescription() throws Exception {
		assertEquals("ÇUKUROVA KİTAP FUARI Çukurova 8. Kitap Fuarı",
				tuyapExtractor.findDescription(1));
		assertEquals("", tuyapExtractor.findDescription(54646546));

	}

	@Test
	public void testExtractFairPlace() throws Exception {
		assertEquals("Tüyap Adana", tuyapExtractor.findPlace(1));
		assertEquals("", tuyapExtractor.findPlace(55846));
	}

	@Test
	public void testExtractFairName() throws Exception,
			NoSuchIndexAtHtmlDocumentException {
		assertEquals("ÇUKUROVA KİTAP FUARI", tuyapExtractor.findName(1));
	}

	@Test(expected = NoSuchIndexAtHtmlDocumentException.class)
	public void testName() throws Exception, NoSuchIndexAtHtmlDocumentException {
		tuyapExtractor.extracFairs(456);
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
