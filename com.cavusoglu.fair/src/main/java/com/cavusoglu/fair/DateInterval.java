package com.cavusoglu.fair;

/**
 * @author izel
 * Class defines an time interval between event start date ad end date.SSSSSSSS
 */
public class DateInterval {
	private String endDate;
	private String startDate;

	public DateInterval(String endDate, String startDate) {
		this.endDate = endDate;
		this.startDate = startDate;

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

}
