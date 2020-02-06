package com.cardsys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cardsys.util.StringUtil;

public abstract class BaseController {
	
	protected Map<String, Object> getWhereMap(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();

		int start = StringUtil.parseToInt(request.getParameter("start"), 0);
		int limit = StringUtil.parseToInt(request.getParameter("limit"), 50);

		map.put("start", start);
		map.put("limit", limit);

		return map;
	}
	
	protected Map<String, Object> getMessageMap(boolean success, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", success);
		map.put("message", message);
		
		return map;
	}
}
