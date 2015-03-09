package com.cavusoglu.fair;

import com.google.gson.JsonObject;

public class Fair {
	private DateInterval dateInterval;
	private String name;
	private String place;
	private String description;

	public Fair(String name, DateInterval dateInterval, String place,
			String description) {
		this.dateInterval = dateInterval;
		this.name = name;
		this.place = place;
		this.description = description;

	}

	public JsonObject getJsonLdObject() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", this.name);
		jsonObject.addProperty("startDate", this.dateInterval.getStartDate());
		jsonObject.addProperty("endDate", this.dateInterval.getEndDate());
		jsonObject.addProperty("description", this.description);
		jsonObject.addProperty("place", this.place);
		jsonObject.addProperty("@context", "http://schema.org");
		jsonObject.addProperty("@type", "Event");
		return jsonObject;

	}

	@Override
	public String toString() {
		return "Fair [endDate=" + dateInterval.getEndDate() + ", startDate="
				+ dateInterval.getStartDate() + ", name=" + name + ", place="
				+ place + ", description=" + description + "]";
	}

}
