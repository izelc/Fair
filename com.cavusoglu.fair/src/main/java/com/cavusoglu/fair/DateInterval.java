package com.cavusoglu.fair;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class DateInterval {

	private String endDate;
	private String startDate;
	private Logger logger;

	public DateInterval() {

		logger = Logger.getLogger(getClass());

	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public DateInterval splitDate(String extractedDate, String splitingRegex) {
		extractedDate = extractedDate.replace("–", "-");
		String[] dates = extractedDate.split(splitingRegex);
		logger.debug(extractedDate);

		if (dates[0].length() <= 3) {
			dates[0] = dates[0] + dates[1].replaceAll("\\d", "") + 2015;
		} else if (!dates[0].contains("2015") && !dates[1].contains("2016")) {
			dates[0] = dates[0] + 2015;
		}

		if (!dates[1].contains("2015") && !dates[1].contains("2016"))
			dates[1] = dates[1] + 2015;

		startDate = dates[0];
		endDate = dates[1];
		logger.debug("split date is working start date: " + getStartDate()
				+ "end date: " + getEndDate());

		return this;

	}

	public String removeBlankSpaces(String date) {
		return date.replaceAll("\\s+", "");
	}

	public String removePunctuationAndBlankSpaces(String date) {
		date = getRidOfTurkishCharacters(date);
		return date.replaceAll("\\W", "");

	}

	public String getRidOfTurkishCharacters(String str) {

		str = str.replace("ı", "i");
		str = str.replace("ö", "o");
		str = str.replace("ü", "u");
		str = str.replace("ş", "s");
		str = str.replace("ğ", "g");
		str = str.replace("ç", "c");
		str = str.replace("Ü", "U");
		str = str.replace("İ", "I");
		str = str.replace("Ö", "O");
		str = str.replace("Ü", "U");
		str = str.replace("Ş", "S");
		str = str.replace("Ğ", "G");
		str = str.replace("Ç", "C");

		return str;

	}

	public String replaceMonthNameWithMonthNumber(String date)
			throws UnidentifiedMonthException {
		date = getRidOfTurkishCharacters(date);
		String month = date.replaceAll("\\d", "").replaceAll("\\s+", "");

		if (month.equalsIgnoreCase("Ocak")) {
			date = date.replaceAll("(?i)ocak", "/01/");
		} else if (month.equalsIgnoreCase("subat")) {
			date = date.replaceAll("(?i)subat", "/02/");
		} else if (month.equalsIgnoreCase("Mart")) {
			date = date.replaceAll("(?i)mart", "/03/");
		} else if (month.equalsIgnoreCase("Nisan")) {
			date = date.replaceAll("(?i)nisan", "/04/");
		} else if (month.equalsIgnoreCase("Mayis")) {
			date = date.replaceAll("(?i)mayis", "/05/");
		} else if (month.equalsIgnoreCase("Haziran")) {
			date = date.replaceAll("(?i)haziran", "/06/");
		} else if (month.equalsIgnoreCase("temmuz")) {
			date = date.replaceAll("(?i)temmuz", "/07/");
		} else if (month.equalsIgnoreCase("agustos")) {
			date = date.replaceAll("(?i)agustos", "/08/");
		} else if (month.equalsIgnoreCase("eylul")) {
			date = date.replaceAll("(?i)eylul", "/09/");
		} else if (month.equalsIgnoreCase("ekim")) {
			date = date.replaceAll("(?i)ekim", "/10/");
		} else if (month.equalsIgnoreCase("kasim")) {
			date = date.replaceAll("(?i)kasim", "/11/");
		} else if (month.equalsIgnoreCase("aralik")) {
			date = date.replaceAll("(?i)aralik", "/12/");
		} else {
			logger.error(month + " is not defined at :" + date);
			throw new UnidentifiedMonthException();
		}
		logger.debug(month + " replaced with its numeric equivalent");

		return date;
	}

	public String convertToIsoFormat(String date) {
		DateTimeFormatter parser1 = DateTimeFormat.forPattern("dd/MM/yyyy");
		String isoDateStr;

		DateTime dateTimeObj1 = DateTime.parse(date, parser1);
		DateTimeFormatter isoDateFormat = ISODateTimeFormat.dateTime();
		isoDateStr = isoDateFormat.print(dateTimeObj1);
		// isoDateStr = isoDateStr.substring(0, 10);
		date = isoDateStr;

		return date;

	}

	public DateInterval getInterval(String date, String splitterRegex) {
		splitDate(date, splitterRegex);

		try {
			startDate = convertToIsoFormat(replaceMonthNameWithMonthNumber(removePunctuationAndBlankSpaces(startDate)));
			endDate = convertToIsoFormat(replaceMonthNameWithMonthNumber(removePunctuationAndBlankSpaces(endDate)));
		} catch (UnidentifiedMonthException e) {
			logger.error("Date is not proper");
			return this;
		}

		return this;
	}
	
	public DateInterval getIntervalForNumericMonths(String date, String splitingRegex) {
          splitDate(date, splitingRegex);
          
           startDate= convertToIsoFormat(removeBlankSpaces(startDate.replace(".", "/")));
          endDate= convertToIsoFormat(removeBlankSpaces(endDate.replace(".", "/")));
          
          return this;
           
	}

}
