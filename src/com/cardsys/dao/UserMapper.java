package com.cardsys.dao;

import java.util.List;
import java.util.Map;

import com.cardsys.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	int selectAllCount(Map<String, Object> whereMap);

	List<User> selectAll(Map<String, Object> whereMap);

	User selectByAccount(String account);
}