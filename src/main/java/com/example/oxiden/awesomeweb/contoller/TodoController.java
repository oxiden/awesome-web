package com.example.oxiden.awesomeweb.contoller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oxiden.awesomeweb.repository.TodoRepository;

@RestController
public class TodoController {

	private final TodoRepository repo;

	TodoController(TodoRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/todo1")
	public ResponseEntity<String> todo1() {
		var httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>("{\"uuid\": \"" + repo.getOneUuid() + "\"}", httpHeaders, HttpStatus.OK);
	}
}
