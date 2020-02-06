package com.cardsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsys.dao.CardInfoMapper;
import com.cardsys.dao.ChangeMapper;
import com.cardsys.model.CardInfo;
import com.cardsys.model.Change;
import com.cardsys.service.CardInfoService;

@Service
public class CardInfoServiceImpl  implements CardInfoService {

	@Autowired
	CardInfoMapper cardInfoMapper;

	@Autowired
	ChangeMapper changeMapper;

	@Override
	public void insert(CardInfo cardInfo) {
		cardInfoMapper.insertSelective(cardInfo);
	}

	@Override
	public void update(CardInfo cardInfo) {
		cardInfoMapper.updateByPrimaryKeySelective(cardInfo);
	}

	@Override
	public void deleteById(int id) {
		cardInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public CardInfo getCardInfoById(int id) {
		return cardInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CardInfo> getAll(Map<String, Object> whereMap) {
		return cardInfoMapper.selectAll(whereMap);
	}

	@Override
	public int getCount(Map<String, Object> whereMap) {
		return cardInfoMapper.selectAllCount(whereMap);
	}

	@Override
	public CardInfo getCardInfoByCardno(String cardno) {
		return cardInfoMapper.selectByCardno(cardno);
	}

	@Override
	public List<Change> getChangeAll(Map<String, Object> whereMap) {
		return changeMapper.selectAll(whereMap);
	}

	@Override
	public int getChangeCount(Map<String, Object> whereMap) {
		return changeMapper.selectAllCount(whereMap);
	}

	@Override
	public void changeCard(Change change, CardInfo cCardInfo, CardInfo oCardInfo) {
		changeMapper.insertSelective(change);
		
		cardInfoMapper.updateByPrimaryKeySelective(cCardInfo);

		cardInfoMapper.updateByPrimaryKeySelective(oCardInfo);
	}

	@Override
	public CardInfo getCardInfoByUserid(int userid) {
		return cardInfoMapper.selectByUserid(userid);
	}
}
