package javaSchool.Task000.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class URLShortener {
	@Id
	private String shortUrl;
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
