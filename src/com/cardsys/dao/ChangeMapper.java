package com.cardsys.dao;

import java.util.List;
import java.util.Map;

import com.cardsys.model.Change;

public interface ChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Change record);

    int insertSelective(Change record);

    Change selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Change record);

    int updateByPrimaryKey(Change record);

	List<Change> selectAll(Map<String, Object> whereMap);

	int selectAllCount(Map<String, Object> whereMap);
}