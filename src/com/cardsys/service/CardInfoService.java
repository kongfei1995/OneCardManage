package com.cardsys.service;

import java.util.List;
import java.util.Map;

import com.cardsys.model.CardInfo;
import com.cardsys.model.Change;

public interface CardInfoService {
	
	List<CardInfo> getAll(Map<String, Object> whereMap);
	
	int getCount(Map<String, Object> whereMap);
	
	List<Change> getChangeAll(Map<String, Object> whereMap);
	
	int getChangeCount(Map<String, Object> whereMap);

	void insert(CardInfo cardInfo);

	void update(CardInfo cardInfo);

	void deleteById(int id);
	
	CardInfo getCardInfoById(int id);

	CardInfo getCardInfoByCardno(String cardno);

	CardInfo getCardInfoByUserid(int userid);

	void changeCard(Change change, CardInfo cCardInfo, CardInfo oCardInfo);

}
