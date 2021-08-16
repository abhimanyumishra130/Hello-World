package com.example.getresourcesapi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SupportDTO implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public String getUrl(){
		return url;
	}

	public String getText(){
		return text;
	}
}