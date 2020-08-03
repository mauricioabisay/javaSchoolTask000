package javaSchool.Task000;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaSchool.Task000.entities.URLShortener;
import javaSchool.Task000.repos.URLShortenerRepository;

@RestController
@RequestMapping("/")
public class URLShortenerController {
	@Autowired
	private URLShortenerRepository repo;
	
	@GetMapping
	public String getSingle( ) {
		return "hello world";
	}
	
	@GetMapping(value = "/{urlShorten}")
	public void getURLAndRedirect(
			HttpServletResponse response, 
			@PathVariable("urlShorten") String urlShorten
		) throws Exception {
		URLShortener urlShortener = null;
		Optional<URLShortener> url = repo.findById(urlShorten);
		if (url.isPresent()) {
			urlShortener = url.get();
		}
		if (urlShortener == null) {
			response.setStatus(404);
		} else {
			response.sendRedirect(url.get().getUrl());
		}
		return;
	}
	
	@PostMapping
	public URLShortener shortAndSave(@RequestBody URLShortener request) {
		List<URLShortener> urlList = repo.findByFullURL(request.getUrl());
		if (urlList.size() > 0) {
			return urlList.get(0);
		}
		int counter = 0;
		Optional<URLShortener> url;
		do {
			request.setShortUrl(URLShortenerService.shortURL(request.getUrl(), counter));
			url = repo.findById(request.getShortUrl());
			counter++;
		} while(url.isPresent());
		try {
			repo.save(request);
		} catch(IllegalArgumentException exception) {
			throw exception;
		}
		return request;
	}
}
