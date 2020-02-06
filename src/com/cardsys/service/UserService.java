package com.cardsys.service;

import java.util.List;
import java.util.Map;

import com.cardsys.model.User;

public interface UserService {
	
	public User getUserByID(int id);
	
	void deleteByID(int id);

	List<User> getAll(Map<String, Object> whereMap);
	
	int getCount(Map<String, Object> whereMap);

	void update(User user);

	void insert(User user);
	
	User getUserByAccount(String account);
	
}
