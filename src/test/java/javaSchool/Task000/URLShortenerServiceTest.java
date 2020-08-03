package javaSchool.Task000;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class URLShortenerServiceTest {
	
	@Test
	public void googleURLShortener() {
		String urlFull = "www.google.com/helloworld";
		String alphaPattern = "[a-z]{5}";
		String result = URLShortenerService.shortURL(urlFull);
		Assert.isTrue(result.length() == 5, "URL shorten length must be 5");
		Assert.isTrue(result.toLowerCase().matches(alphaPattern), "URL shorten must only contain alphabetic chars");
	}
	
	@Test
	public void yahooURLShortener() {
		String urlFull = "www.yahoo.com/helloworld";
		String alphaPattern = "[a-z0-9]{7}";
		String result = URLShortenerService.shortURL(urlFull);
		Assert.isTrue(result.length() == 7, "URL shorten length must be 7");
		Assert.isTrue(result.toLowerCase().matches(alphaPattern), "URL shorten must only contain alphabetic and numeric chars");
	}
	
	@Test
	public void defaultURLShortener() {
		String urlFull = "www.helloworld.com/hello$world%123";
		String urlExpected = "wwwhllwrldcmhllwrld";
		String result = URLShortenerService.shortURL(urlFull);
		Assert.isTrue(result.equalsIgnoreCase(urlExpected), "URL shorten doesn't match expected value");
	}
}
