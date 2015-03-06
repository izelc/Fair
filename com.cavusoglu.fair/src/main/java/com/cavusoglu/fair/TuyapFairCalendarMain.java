package com.cavusoglu.fair;

public class TuyapFairCalendarMain {

	public static void main(String[] args) throws UnidentifiedMonthNameStrikeException {
	    TuyapFairCalendar tuyapFairCalendar=new TuyapFairCalendar();
	    
	    for (int i = 0; i < tuyapFairCalendar.getFairList().size(); i++) {
			System.err.println(tuyapFairCalendar.getFairList().get(i));
		}

	}

}
