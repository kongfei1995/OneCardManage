package com.cardsys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cardsys.model.CardInfo;
import com.cardsys.model.Change;
import com.cardsys.model.User;
import com.cardsys.service.CardInfoService;
import com.cardsys.service.UserService;
import com.cardsys.util.Page;
import com.cardsys.util.StringUtil;
import com.cardsys.vo.SearchVO;

@Controller
@RequestMapping(value="/cardinfo")
public class CardInfoController extends BaseController {
	
	@Autowired
	CardInfoService cardInfoService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String get(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("state", "新卡");
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("cardno", "'%" + searchVO.getName() + "%'");
		}
		if (!StringUtil.isEmpty(searchVO.getStartDate())) {
			whereMap.put("startDate", searchVO.getStartDate());
		}
		
		if (!StringUtil.isEmpty(searchVO.getEndDate())) {
			whereMap.put("endDate", searchVO.getEndDate());
		}

		int totalCount = (int) cardInfoService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<CardInfo> cardinfos = cardInfoService.getAll(whereMap);

		modelMap.addAttribute("cardinfos", cardinfos);
		modelMap.addAttribute("page", page);
		
		return "cardsys/cardlist";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(CardInfo cardinfo, ModelMap modelMap, HttpSession session) {
		CardInfo oCardInfo = cardInfoService.getCardInfoByCardno(cardinfo.getCardno());
		if(cardinfo.getId() == null) {
			cardinfo.setState("新卡");
			cardinfo.setAddtime(new Date());
			cardInfoService.insert(cardinfo);
		} else {
			if (oCardInfo != null && !oCardInfo.getId().equals(cardinfo.getId())) {
				modelMap.put("cardinfo", cardinfo);
				modelMap.put("message", "卡号已存在，请重新输入!");
				return "cardsys/addcard";
			}
			cardInfoService.update(cardinfo);
		}
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		return "cardsys/addcard";
	}
	
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(int id, ModelMap modelMap) {
		CardInfo cardinfo = cardInfoService.getCardInfoById(id);
		
		modelMap.put("cardinfo", cardinfo);
		return "cardsys/addcard";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(int id, ModelMap modelMap) {
		cardInfoService.deleteById(id);
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/toInvalid", method = RequestMethod.GET)
	public String invalid(ModelMap modelMap) {
		
		return "cardsys/invalid";
	}

	@RequestMapping(value = "/invalidlist", method = RequestMethod.GET)
	public String getInvalid(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("state", "作废");
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("cardno", "'%" + searchVO.getName() + "%'");
		}
		if (!StringUtil.isEmpty(searchVO.getStartDate())) {
			whereMap.put("invalidStartDate", searchVO.getStartDate());
		}
		
		if (!StringUtil.isEmpty(searchVO.getEndDate())) {
			whereMap.put("invalidEndDate", searchVO.getEndDate());
		}

		int totalCount = (int) cardInfoService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<CardInfo> cardinfos = cardInfoService.getAll(whereMap);

		modelMap.addAttribute("cardinfos", cardinfos);
		modelMap.addAttribute("page", page);
		
		return "cardsys/invalidcardlist";
	}
	
	@RequestMapping(value="/invalid", method = RequestMethod.POST)
	public String invalid(String cardno, @RequestParam(required=false)String invalidmsg, ModelMap modelMap, HttpSession session) {
		CardInfo cardinfo = cardInfoService.getCardInfoByCardno(cardno);
		
		if (cardinfo == null) {
			modelMap.put("message", "卡号不存在，请重新输入!");
			return "cardsys/invalid";
		}
		
		cardinfo.setState("作废");
		cardinfo.setInvalidtime(new Date());
		cardinfo.setInvalidmsg(invalidmsg);
		cardInfoService.update(cardinfo);
		
		return "redirect:invalidlist.html";
	}
	
	@RequestMapping(value="/toAllocate", method = RequestMethod.GET)
	public String allocate(ModelMap modelMap) {
		
		return "cardsys/allocate";
	}

	@RequestMapping(value = "/allocatedlist", method = RequestMethod.GET)
	public String getAllocated(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("state", "已分配");
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("cardno", "'%" + searchVO.getName() + "%'");
		}
		if (!StringUtil.isEmpty(searchVO.getStartDate())) {
			whereMap.put("invalidStartDate", searchVO.getStartDate());
		}
		
		if (!StringUtil.isEmpty(searchVO.getEndDate())) {
			whereMap.put("invalidEndDate", searchVO.getEndDate());
		}

		int totalCount = (int) cardInfoService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<CardInfo> cardinfos = cardInfoService.getAll(whereMap);

		modelMap.addAttribute("cardinfos", cardinfos);
		modelMap.addAttribute("page", page);
		
		return "cardsys/allocatecardlist";
	}
	
	@RequestMapping(value="/allocate", method = RequestMethod.POST)
	public String allocate(String cardno, @RequestParam(required=false)String allocatemsg, String account, ModelMap modelMap, HttpSession session) {
		User user = userService.getUserByAccount(account);
		CardInfo cardinfo = cardInfoService.getCardInfoByCardno(cardno);
		
		if (user == null) {
			modelMap.put("message", "学生学号/教师工号不存在，请重新输入!");
			return "cardsys/allocate";
		}
		
		if (cardinfo == null || !cardinfo.getState().equals("新卡")) {
			modelMap.put("message", "卡片不存在或者已分配给其他人!");
			return "cardsys/allocate";
		}
		
		cardinfo.setUserid(user.getId());
		cardinfo.setUsername(user.getName());
		if ("teacher".equals(user.getType())) {
			cardinfo.setCardname("教师卡");
		} else if ("teacher".equals(user.getType())) {
			cardinfo.setCardname("学生卡");
		}
		cardinfo.setState("已分配");
		cardinfo.setAllocatetime(new Date());
		cardinfo.setAllocatemsg(allocatemsg);
		cardInfoService.update(cardinfo);
		
		return "redirect:allocatedlist.html";
	}
	
	@RequestMapping(value="/toChange", method = RequestMethod.GET)
	public String change(ModelMap modelMap) {
		
		return "cardsys/change";
	}

	@RequestMapping(value = "/changelist", method = RequestMethod.GET)
	public String getchange(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();

		int totalCount = (int) cardInfoService.getChangeCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<Change> cardinfos = cardInfoService.getChangeAll(whereMap);

		modelMap.addAttribute("cardinfos", cardinfos);
		modelMap.addAttribute("page", page);
		
		return "cardsys/changelist";
	}
	
	@RequestMapping(value="/change", method = RequestMethod.POST)
	public String change(String cardno, String account, ModelMap modelMap, HttpSession session) {
		User user = userService.getUserByAccount(account);
		
		if (user == null) {
			modelMap.put("message", "学生学号/教师工号不存在，请重新输入!");
			return "cardsys/change";
		}
		
		CardInfo oCardInfo = cardInfoService.getCardInfoByUserid(user.getId());
		if (oCardInfo == null) {
			modelMap.put("message", user.getName() + "目前没有卡，请给他分配新卡片或者重新输入!");
			return "cardsys/change";
		}
		
		CardInfo cCardInfo = cardInfoService.getCardInfoByCardno(cardno);
		if (cCardInfo == null || !cCardInfo.getState().equals("新卡")) {
			modelMap.put("message", "卡片不存在或者已分配给其他人!");
			return "cardsys/change";
		}
		
		Change change = new Change();
		change.setOldcardno(oCardInfo.getCardno());
		change.setNewcardno(cardno);
		change.setOperatedate(new Date());
		change.setUserid(user.getId());
		change.setUsername(user.getName());
		
		oCardInfo.setState("作废");
		oCardInfo.setInvalidtime(new Date());
		oCardInfo.setInvalidmsg("补卡作废");
		
		cCardInfo.setUserid(user.getId());
		cCardInfo.setUsername(user.getName());
		if ("teacher".equals(user.getType())) {
			cCardInfo.setCardname("教师卡");
		} else if ("teacher".equals(user.getType())) {
			cCardInfo.setCardname("学生卡");
		}
		cCardInfo.setState("已分配");
		cCardInfo.setAllocatetime(new Date());
		
		cardInfoService.changeCard(change, cCardInfo, oCardInfo);
		
		return "redirect:changelist.html";
	}
}
