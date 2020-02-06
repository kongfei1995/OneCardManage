package com.cardsys.controller;

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

import com.cardsys.util.StringUtil;
import com.cardsys.vo.SearchVO;
import com.cardsys.model.User;
import com.cardsys.service.UserService;
import com.cardsys.util.Page;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String get(HttpServletRequest request, ModelMap modelMap, SearchVO searchVO) {
		String pageNow = request.getParameter("pageNow");

		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("name", " '%" + searchVO.getName() + "%'");
		}
		
		int totalCount = (int) userService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		List<User> users = userService.getAll(whereMap);

		modelMap.addAttribute("users", users);
		modelMap.addAttribute("page", page);
		
		return "cardsys/userlist";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(User user, ModelMap modelMap, HttpSession session) {
		User oUser = userService.getUserByAccount(user.getAccount());
		if(user.getId() == null) {
			userService.insert(user);
		} else {
			if (oUser != null) {
				modelMap.put("tempuser", user);
				modelMap.put("message", "用户已存在，请重新输入用户名!");
				return "user";
			}
			userService.update(user);
		}
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(int type, ModelMap modelMap) {
		modelMap.put("type", type);
		return "cardsys/user";
	}
	
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(int id, ModelMap modelMap) {
		User user = userService.getUserByID(id);
		
		modelMap.put("tempuser", user);
		return "cardsys/user";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(int id, ModelMap modelMap) {
		userService.deleteByID(id);
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/mine", method = RequestMethod.GET)
	public String mine(ModelMap modelMap) {
		
		return "cardsys/mine";
	}
	
	@RequestMapping(value="/changePassword", method = RequestMethod.GET)
	public String changePassword(ModelMap modelMap) {
		
		return "cardsys/changepwd";
	}
	
	@RequestMapping(value="/savePassword", method = RequestMethod.POST)
	public String savePassword(HttpSession session, String mpass, String password, ModelMap modelMap) {
		User user = (User) session.getAttribute("user");
		User cuser = userService.getUserByID(user.getId());
		
		if (!cuser.getPassword().equals(mpass)) {
			modelMap.put("error", "旧密码错误，请重新输入!");
		} else {
			modelMap.put("message", "密码修改成功!");
		}
		
		cuser.setPassword(password);
		
		userService.update(cuser);
		
		
		return "cardsys/changepwd";
	}
}
