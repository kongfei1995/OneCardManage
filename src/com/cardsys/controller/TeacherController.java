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

import com.cardsys.model.User;
import com.cardsys.service.TeacherService;
import com.cardsys.util.Page;
import com.cardsys.util.StringUtil;
import com.cardsys.vo.SearchVO;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController extends BaseController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String get(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("type", "teacher");
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("name", "'%" + searchVO.getName() + "%'");
		}

		int totalCount = (int) teacherService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<User> teachers = teacherService.getAll(whereMap);

		modelMap.addAttribute("teachers", teachers);
		modelMap.addAttribute("page", page);
		
		return "cardsys/teacherlist";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(User teacher, ModelMap modelMap, HttpSession session) {
		User oUser = teacherService.getUserByAccount(teacher.getAccount());
		if(teacher.getId() == null) {
			teacher.setAddtime(new Date());
			teacherService.insert(teacher);
		} else {
			if (oUser != null && !oUser.getId().equals(teacher.getId())) {
				modelMap.put("teacher", teacher);
				modelMap.put("message", "教师工号已存在，请重新输入!");
				return "cardsys/addteacher";
			}
			teacherService.update(teacher);
		}
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		return "cardsys/addteacher";
	}
	
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(int id, ModelMap modelMap) {
		User teacher = teacherService.getTeacherById(id);
		
		modelMap.put("teacher", teacher);
		return "cardsys/addteacher";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(int id, ModelMap modelMap) {
		teacherService.deleteById(id);
		
		return "redirect:list.html";
	}
}
