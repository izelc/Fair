package com.cavusoglu.fair;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Mockito;

public class DocumentSearcherTest {

	@Test
	public void testExtractElementWithCssPAth() throws Exception {
		DocumentFetcher mock = Mockito.spy(new DocumentFetcher());
		Document doc = Jsoup.parse(readFile("ExampleTuyap.html"));
		Mockito.doReturn(doc).when(mock).getDocument();

		String cssPath = "> tr:nth-child(4) > td:nth-child(3) > h5 > b";
		String date = new DocumentSearcher(mock)
				.extractElementWithCssPAth(cssPath);
		assertEquals("22 - 25 Ocak 2015", date);

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
