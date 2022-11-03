package org.enterprise.apicall;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsItem{

	@JsonProperty("volumeInfo")
	private VolumeInfo volumeInfo;

	public void setVolumeInfo(VolumeInfo volumeInfo){
		this.volumeInfo = volumeInfo;
	}

	public VolumeInfo getVolumeInfo(){
		return volumeInfo;
	}
}