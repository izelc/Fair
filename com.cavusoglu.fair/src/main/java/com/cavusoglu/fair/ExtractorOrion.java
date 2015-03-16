package com.cavusoglu.fair;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

public class ExtractorOrion extends Extractor {

	private ArrayList<Document> documents;

	private String[][] matrixCssPAthForAttributes = {
			{
					"#aciklama > table > tbody > tr:nth-child(1) > td:nth-child(2)",
					"#aciklama > table > tbody > tr:nth-child(2) > td:nth-child(2)",
					"#aciklama > table > tbody > tr:nth-child(3) > td:nth-child(2)" },

			{
					"#aciklama > div > table > tbody > tr:nth-child(1) > td:nth-child(2) > div",
					"#aciklama > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div",
					"#aciklama > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > div" },

			{
					"#aciklama > div > table > tbody > tr:nth-child(1) > td:nth-child(2)",
					"#aciklama > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div",
					"#aciklama > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > div" } };

	public ExtractorOrion() {
		documents = new ArrayList<Document>();
		documents
				.add(new DocumentFetcher(
						"http://www.orionfuarcilik.com.tr/orion-tarim-fuari-fuarlar-13-90.html")
						.getDocument());
		documents
				.add(new DocumentFetcher(
						"http://www.orionfuarcilik.com.tr/orion-tarim-fuari-fuarlar-14-99.html")
						.getDocument());
		documents
				.add(new DocumentFetcher(
						"http://www.orionfuarcilik.com.tr/orion-tarim-fuari-fuarlar-15-108.html")
						.getDocument());

	}

	public ExtractorOrion(DocumentFetcher df1, DocumentFetcher df2,
			DocumentFetcher df3) {
		documents = new ArrayList<Document>();
		documents.add(df1.getDocument());
		documents.add(df2.getDocument());
		documents.add(df3.getDocument());

	}

	@Override
	public String findName(int i) {
		String name = documents.get(i).select(matrixCssPAthForAttributes[i][0])
				.text();
		logger.trace("we got fair name from orion fuarcilik: " + name);
		return name;
	}

	@Override
	public DateInterval findDate(int i) {
		String date = documents.get(i).select(matrixCssPAthForAttributes[i][1])
				.text();
		logger.trace("we got fair date from orion fuarcilik: " + date);

		return new DateInterval().getInterval(date, "\\-");
	}

	@Override
	public String findPlace(int i) {
		String place = documents.get(i)
				.select(matrixCssPAthForAttributes[i][2]).text();
		logger.trace("we got fair place from orion fuarcilik: " + place);
		return place;
	}

	@Override
	public String findDescription(int i) {

		return "Orion Fuarcilik";
	}

}
