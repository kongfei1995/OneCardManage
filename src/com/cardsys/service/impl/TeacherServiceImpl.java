package com.cardsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsys.dao.UserMapper;
import com.cardsys.model.User;
import com.cardsys.service.TeacherService;

@Service
public class TeacherServiceImpl  implements TeacherService {

	@Autowired
	UserMapper userMapper;

	@Override
	public void insert(User teacher) {
		userMapper.insertSelective(teacher);
	}

	@Override
	public void update(User teacher) {
		userMapper.updateByPrimaryKey(teacher);
	}

	@Override
	public void deleteById(int id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getTeacherById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAll(Map<String, Object> whereMap) {
		return userMapper.selectAll(whereMap);
	}

	@Override
	public int getCount(Map<String, Object> whereMap) {
		return userMapper.selectAllCount(whereMap);
	}

	@Override
	public User getUserByAccount(String account) {
		return userMapper.selectByAccount(account);
	}
}
