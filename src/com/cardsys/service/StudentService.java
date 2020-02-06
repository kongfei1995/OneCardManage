package com.cardsys.service;

import java.util.List;
import java.util.Map;

import com.cardsys.model.User;

public interface StudentService {
	
	List<User> getAll(Map<String, Object> whereMap);
	
	int getCount(Map<String, Object> whereMap);

	void insert(User student);

	void update(User student);

	void deleteById(int id);
	
	User getStudentById(int id);
	
	User getUserByAccount(String account);

}
