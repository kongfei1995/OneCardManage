package com.cardsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsys.dao.UserMapper;
import com.cardsys.model.User;
import com.cardsys.service.UserService;

@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUserByID(int id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteByID(int id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void insert(User user) {
		userMapper.insertSelective(user);
	}

	@Override
	public User getUserByAccount(String account) {
		return userMapper.selectByAccount(account);
	}

	@Override
	public List<User> getAll(Map<String, Object> whereMap) {
		return userMapper.selectAll(whereMap);
	}

	@Override
	public int getCount(Map<String, Object> whereMap) {
		return userMapper.selectAllCount(whereMap);
	}
}
