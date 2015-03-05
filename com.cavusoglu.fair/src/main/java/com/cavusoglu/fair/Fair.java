package com.cavusoglu.fair;

import com.google.gson.JsonObject;

public class Fair {
	private String endDate;
	private String startDate;
	private String name;
	private String place;
	private String description;

	public Fair(String name, String startDate,String endDate, String place, String description) {
		this.endDate = endDate;
		this.startDate=startDate;
		this.name = name;
		this.place = place;
		this.description = description;

	}


	public JsonObject getJsonLdObject() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("@context", "http://schema.org");
		jsonObject.addProperty("@type", "Event");
		jsonObject.addProperty("startDate", this.startDate);
		jsonObject.addProperty("endDate", this.endDate);
		jsonObject.addProperty("name", this.name);
		jsonObject.addProperty("description", this.description);
		jsonObject.addProperty("place", this.place);
		return jsonObject;

	}


	@Override
	public String toString() {
		return "Fair [endDate=" + endDate + ", startDate=" + startDate
				+ ", name=" + name + ", place=" + place + ", description="
				+ description + "]";
	}

	

}
