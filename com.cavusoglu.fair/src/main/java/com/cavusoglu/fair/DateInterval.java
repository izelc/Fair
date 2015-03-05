package com.cavusoglu.fair;

import org.apache.log4j.Logger;

public class DateInterval { 
   private String endDate;
   private String startDate;
   private Logger logger = Logger.getLogger(getClass());
 
   public DateInterval(String endDate, String startDate) {
	  this.endDate=endDate;
	  this.startDate=startDate;
	  logger.trace("Date Interval object is created between "+ endDate+"and"+startDate);
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
