package javaSchool.Task000;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public void getURLAndRedirect() {
		return;
	}
	
	@PostMapping
	public URLShortener shortAndSave(@RequestBody URLShortener request) {
		return repo.save(request);
	}
}
