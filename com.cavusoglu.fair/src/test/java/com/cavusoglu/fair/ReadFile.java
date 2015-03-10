package com.cavusoglu.fair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public static String readFile(String path) throws IOException {
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
