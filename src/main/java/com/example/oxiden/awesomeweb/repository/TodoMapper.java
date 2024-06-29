package com.example.oxiden.awesomeweb.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.oxiden.awesomeweb.model.Todo;

@Mapper
public interface TodoMapper {

	@Select("SELECT uuid FROM todo_item ORDER BY uuid LIMIT 1")
	public String getOneUuid();

	@Select("SELECT * FROM todo_item ORDER BY uuid")
	public List<Todo> getAll();
}
