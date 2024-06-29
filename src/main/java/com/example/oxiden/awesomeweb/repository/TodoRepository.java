package com.example.oxiden.awesomeweb.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoRepository {
	private final JdbcTemplate jdbcTemplate;

	public TodoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getOneUuid() {
		return jdbcTemplate.queryForObject(
				"SELECT uuid FROM todo_item LIMIT 1;",
				String.class);
	}
}
