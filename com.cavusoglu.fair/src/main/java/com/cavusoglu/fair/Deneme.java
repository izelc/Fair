package com.cavusoglu.fair;

public class Deneme {

	public static void main(String[] args) {
	
		
		String month= "nİsaN".toLowerCase();
		if(month.equals("nisan"))
			System.out.println("true");
		else
			System.err.println("false");
		
		
		 String target = "ŞuBatBar";
		    target = target.replaceAll("(?i)şubaT", "oooo");
		    System.out.println(target);
		    

		    
		    String tarih="03-Nisan-2015";
		    tarih=tarih.replace("-", "");
		    System.out.println(tarih);
	}
	
	
	

}
