package javaSchool.Task000;

import org.apache.commons.lang3.RandomStringUtils;

public class URLShortenerService {
	private final static String URL_GOOGLE_PATTERN = "^.*(google).*$";
	private final static String URL_YAHOO_PATTERN  = "^.*(yahoo).*$";
	private final static String URL_DEFAULT_REMOVE = "[\\W0-9aeiou]";
	
	public static String shortURL(String url) {
		return URLShortenerService.shortURL(url, 0);
	}
	
	public static String shortURL(String url, int count) {
		StringBuilder urlShorten = new StringBuilder();
		if (url.matches(URL_GOOGLE_PATTERN)) {
			urlShorten.append(RandomStringUtils.randomAlphabetic(5));
		} else if (url.matches(URL_YAHOO_PATTERN)) {
			urlShorten.append(RandomStringUtils.randomAlphanumeric(7));
		} else if (count > 0) {
			urlShorten.append(url.toLowerCase().replaceAll(URL_DEFAULT_REMOVE, ""));
			urlShorten.append(count);
		} else {
			urlShorten.append(url.toLowerCase().replaceAll(URL_DEFAULT_REMOVE, ""));
		}
		return urlShorten.toString();
	}
}
