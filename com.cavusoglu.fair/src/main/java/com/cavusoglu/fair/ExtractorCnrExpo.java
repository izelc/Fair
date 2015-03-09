package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class ExtractorCnrExpo extends Extractor {

	Logger logger = Logger.getLogger(getClass());

	public ExtractorCnrExpo() {
		documentFetcher = new DocumentFetcher(
				"http://cnrexpo.com/en_fuar_takvimi.aspx",
				"#aspnetForm > div.sayfa > div.left_content > div > div.takvim_orta");
		documentSearcher = new DocumentSearcher(documentFetcher);

		cssPathForName = "> div:nth-child(MYINDEX) > div.takvim_ad";
		cssPathForDescription = "> div:nth-child(MYINDEX) > div:nth-child(4)";
		cssPathForDate = "> div:nth-child(MYINDEX) > div.takvim_tarih";
	}

	@Override
	public DateInterval findDate(int i) {

		String date = findFairAttribute(i,
				cssPathForDate.replace("MYINDEX", "" + i), "Date");
		logger.info("Date is extracted " + date + " with css path "
				+ cssPathForDate);
		date = date.replace("(", "");
		date = date.replace(")", "");

		DateInterval interval = new DateInterval().getIntervalForNumericMonths(
				date, getDateSplitterRegex());
		logger.info("Date is splitted.StartDate: " + interval.getStartDate()
				+ "EndDate" + interval.getEndDate());
		return interval;

	}

	@Override
	public String findPlace(int i) {
		return "CNREXPO Fair Center";
	}

}
