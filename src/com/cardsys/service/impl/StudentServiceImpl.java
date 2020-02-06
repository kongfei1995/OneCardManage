package com.cardsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsys.dao.UserMapper;
import com.cardsys.model.User;
import com.cardsys.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService {

	@Autowired
	UserMapper userMapper;

	@Override
	public void insert(User student) {
		userMapper.insertSelective(student);
	}

	@Override
	public void update(User student) {
		userMapper.updateByPrimaryKey(student);
	}

	@Override
	public void deleteById(int id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getStudentById(int id) {
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
