package org.enterprise.googlebooksapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiIsdnCookbook{

	@JsonProperty("items")
	private List<ItemsItem> items;

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}
}