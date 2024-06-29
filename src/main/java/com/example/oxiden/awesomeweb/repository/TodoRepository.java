package com.example.oxiden.awesomeweb.repository;

import java.util.List;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.oxiden.awesomeweb.model.Todo;

@Repository
public class TodoRepository {
	private final JdbcTemplate jdbcTemplate;

	public TodoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getOneUuid() {
		return jdbcTemplate.queryForObject(
				"SELECT uuid FROM todo_item ORDER BY uuid LIMIT 1",
				String.class);
	}

	public List<Todo> getAll() {
		return jdbcTemplate.query(
				"SELECT * FROM todo_item ORDER BY uuid",
				new DataClassRowMapper<>(Todo.class));
	}
}
