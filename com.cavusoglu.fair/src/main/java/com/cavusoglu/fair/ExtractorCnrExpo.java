package com.cavusoglu.fair;

public class ExtractorCnrExpo extends Extractor {

	public ExtractorCnrExpo() {
		super(
				"http://cnrexpo.com/en_fuar_takvimi.aspx",
				"#aspnetForm > div.sayfa > div.left_content > div > div.takvim_orta",
				"> div:nth-child(MYINDEX) > div.takvim_ad",
				"> div:nth-child(MYINDEX) > div.takvim_tarih",
				"> div:nth-child(MYINDEX) > div:nth-child(4)", "");

	}

	public ExtractorCnrExpo(DocumentFetcher mock) {
		super(
				mock,
				"http://cnrexpo.com/en_fuar_takvimi.aspx",
				"#aspnetForm > div.sayfa > div.left_content > div > div.takvim_orta",
				"> div:nth-child(MYINDEX) > div.takvim_ad",
				"> div:nth-child(MYINDEX) > div.takvim_tarih",
				"> div:nth-child(MYINDEX) > div:nth-child(4)", "");
	}

	@Override
	public DateInterval findDate(int i) {

		String date = findFairAttribute(i,
				getCssPathForDate().replace("MYINDEX", "" + i), "Date");
		logger.info("Date is extracted " + date + " with css path "
				+ getCssPathForDate());
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
