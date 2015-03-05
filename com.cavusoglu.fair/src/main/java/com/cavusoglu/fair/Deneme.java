package com.cavusoglu.fair;

public class Deneme {

	public static void main(String[] args) {
		
		//body > span > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody > tr:nth-child(1) > td:nth-child(3) > h5 > b
		System.err.println(new DocumentFetcher().getElement().select("> tr:nth-child(1) > td:nth-child(2) > h5 > strong").text());
	}

}
