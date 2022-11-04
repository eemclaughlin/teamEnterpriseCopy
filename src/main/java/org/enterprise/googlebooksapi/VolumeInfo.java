package org.enterprise.googlebooksapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VolumeInfo{

	@JsonProperty("industryIdentifiers")
	private List<IndustryIdentifiersItem> industryIdentifiers;

	@JsonProperty("pageCount")
	private int pageCount;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	@JsonProperty("publishedDate")
	private String publishedDate;

	@JsonProperty("categories")
	private List<String> categories;

	@JsonProperty("title")
	private String title;

	@JsonProperty("maturityRating")
	private String maturityRating;

	@JsonProperty("imageLinks")
	private ImageLinks imageLinks;

	@JsonProperty("authors")
	private List<String> authors;

	public void setIndustryIdentifiers(List<IndustryIdentifiersItem> industryIdentifiers){
		this.industryIdentifiers = industryIdentifiers;
	}

	public List<IndustryIdentifiersItem> getIndustryIdentifiers(){
		return industryIdentifiers;
	}

	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	public int getPageCount(){
		return pageCount;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setCategories(List<String> categories){
		this.categories = categories;
	}

	public List<String> getCategories(){
		return categories;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setMaturityRating(String maturityRating){
		this.maturityRating = maturityRating;
	}

	public String getMaturityRating(){
		return maturityRating;
	}

	public void setImageLinks(ImageLinks imageLinks){
		this.imageLinks = imageLinks;
	}

	public ImageLinks getImageLinks(){
		return imageLinks;
	}

	public void setAuthors(List<String> authors){
		this.authors = authors;
	}

	public List<String> getAuthors(){
		return authors;
	}
}