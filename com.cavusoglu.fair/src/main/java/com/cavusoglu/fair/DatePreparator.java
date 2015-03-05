package com.cavusoglu.fair;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DatePreparator {

	DateInterval dateInterval = new DateInterval(null, null);

	private Logger logger = Logger.getLogger(getClass());

	public DateInterval splitDate(String dateWithBothEndTimeAndStartTime) {
		String[] dates = dateWithBothEndTimeAndStartTime.split("\\-");
		if (dates[0].length() <= 3) {
			dates[0] = dates[0]
					+ dates[1].replaceAll("\\d", "").replaceAll("\\s+", "")
					+ " " + 2015;
		} else {
			dates[0] = dates[0] + 2015;
		}
		dates[1] = dates[1].substring(1);
		DateInterval dateInterval = new DateInterval(dates[0], dates[1]);
		logger.debug("split date is working");

		return dateInterval;
	}

	public DateInterval getRidOfTurkishMonths(DateInterval dateInterval) throws UnidentifiedMonthNameStrike {
		dateInterval.setEndDate(convertMonthNameWithMonthNumber(dateInterval
				.getEndDate()));
		dateInterval.setStartDate(convertMonthNameWithMonthNumber(dateInterval
				.getStartDate()));
		logger.debug(" getRidOfTurkishMonths is working");

		return dateInterval;

	}

	private String convertMonthNameWithMonthNumber(String date) throws UnidentifiedMonthNameStrike {
		String month = date.replaceAll("\\d", "").replaceAll("\\s+", "");
		if (month.equals("Ocak")) {
			date = date.replace(" Ocak ", "/01/");
		}
		if (month.equals("Şubat")) {
			date = date.replace(" Şubat ", "/02/");
		}
		if (month.equals("Mart")) {
			date = date.replace(" Mart ", "/03/");
		}
		if (month.equals("Nisan")) {
			date = date.replace(" Nisan ", "/04/");
		}
		if (month.equals("Mayıs")) {
			date = date.replace(" Mayıs ", "/05/");
		}
		if (month.equals("Haziran")) {
			date = date.replace(" Haziran ", "/06/");
		}
		if (month.equals("Temmuz")) {
			date = date.replace(" Temmuz ", "/07/");
		}
		if (month.equals("Ağustos")) {
			date = date.replace(" Ağustos ", "/08/");
		}
		if (month.equals("Eylül")) {
			date = date.replace(" Eylül ", "/09/");
		}
		if (month.equals("Ekim")) {
			date = date.replace(" Ekim ", "/10/");
		}
		if (month.equals("Kasım")) {
			date = date.replace(" Kasım ", "/11/");
		}
		if (month.equals("Aralık")) {
			date = date.replace(" Aralık ", "/12/");
		}
		else{
			throw new UnidentifiedMonthNameStrike();
		}
		logger.debug("convertMonthNameWithMonthNumber working and " + month
				+ " replaced with its numeric equivalent");
		return date;
	}

	public String convertToIsoFormat(String date) {
		DateTimeFormatter parser1 = DateTimeFormat.forPattern("dd/MM/yyyy");
		String isoDateStr;

		DateTime dateTimeObj1 = DateTime.parse(date, parser1);
		DateTimeFormatter isoDateFormat = ISODateTimeFormat.dateTime();
		isoDateStr = isoDateFormat.print(dateTimeObj1);
	//	isoDateStr = isoDateStr.substring(0, 10);
		date = isoDateStr;

		return date;

	}

	public DateInterval splitAndConvertToIso(
			String dateWithBothEndTimeAndStartTime) throws UnidentifiedMonthNameStrike {
		DateInterval dateInterval = getRidOfTurkishMonths(splitDate(dateWithBothEndTimeAndStartTime));
		dateInterval.setEndDate(convertToIsoFormat(dateInterval.getEndDate()));
		dateInterval.setStartDate(convertToIsoFormat(dateInterval
				.getStartDate()));
		logger.info(dateWithBothEndTimeAndStartTime
				+ "has been splitted and converted to iso format like this: "
				+ dateInterval.getStartDate() + dateInterval.getEndDate());
		return dateInterval;
	}

}
