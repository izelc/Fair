package com.cavusoglu.fair;

public class TuyapFairCalendarMain {

	public static void main(String[] args) throws UnidentifiedMonthNameStrike {
	    TuyapFairCalendar tuyapFairCalendar=new TuyapFairCalendar();
	    
	    for (int i = 0; i < tuyapFairCalendar.fairList.size(); i++) {
			System.err.println(tuyapFairCalendar.fairList.get(i));
		}

	}

}
