package kr.ac.kopo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
@PreAuthorize("hasRole('BOOK')")
public class BookController {
	private final String path = "book/";
	
	@GetMapping("/list")
	String list() {
		return path + "list";
	}
}
