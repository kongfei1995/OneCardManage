package com.cardsys.dao;

import java.util.List;
import java.util.Map;

import com.cardsys.model.CardInfo;

public interface CardInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CardInfo record);

    int insertSelective(CardInfo record);

    CardInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CardInfo record);

    int updateByPrimaryKey(CardInfo record);

	List<CardInfo> selectAll(Map<String, Object> whereMap);

	int selectAllCount(Map<String, Object> whereMap);

	CardInfo selectByCardno(String cardno);

	CardInfo selectByUserid(int userid);
}