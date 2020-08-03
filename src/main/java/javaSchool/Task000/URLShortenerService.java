package javaSchool.Task000;

public class URLShortenerService {
	private final static String URL_GOOGLE_PATTERN = "^.*(google).*$";
	private final static String URL_YAHOO_PATTERN  = "^.*(yahoo).*$";
	private final static String URL_DEFAULT_REMOVE = "[\\W0-9aeiou]";
	
	public static String shortURL(String url) {
		return URLShortenerService.shortURL(url, 0);
	}
	
	public static String shortURL(String url, int count) {
		StringBuilder urlShorten = new StringBuilder();
		return urlShorten.toString();
	}
}
