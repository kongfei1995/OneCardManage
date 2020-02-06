package com.cardsys.service;

import java.util.List;
import java.util.Map;

import com.cardsys.model.User;

public interface TeacherService {
	
	List<User> getAll(Map<String, Object> whereMap);
	
	int getCount(Map<String, Object> whereMap);

	void insert(User user);

	void update(User user);

	void deleteById(int id);
	
	User getTeacherById(int id);
	
	User getUserByAccount(String account);

}
