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
import com.cardsys.service.StudentService;
import com.cardsys.util.Page;
import com.cardsys.util.StringUtil;
import com.cardsys.vo.SearchVO;

@Controller
@RequestMapping(value="/student")
public class StudentController extends BaseController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String get(SearchVO searchVO, HttpServletRequest request, ModelMap modelMap) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;

		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("type", "student");
		if (!StringUtil.isEmpty(searchVO.getName())) {
			whereMap.put("name", "'%" + searchVO.getName() + "%'");
		}

		int totalCount = (int) studentService.getCount(whereMap);

		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
		} else {
			page = new Page(totalCount, 1);
		}
		whereMap.put("startPos", page.getStartPos());
		whereMap.put("pageSize", page.getPageSize());
		
		List<User> students = studentService.getAll(whereMap);

		modelMap.addAttribute("students", students);
		modelMap.addAttribute("page", page);
		
		return "cardsys/studentlist";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(User student, ModelMap modelMap, HttpSession session) {
		User oUser = studentService.getUserByAccount(student.getAccount());
		if(student.getId() == null) {
			student.setAddtime(new Date());
			studentService.insert(student);
		} else {
			if (oUser != null && !oUser.getId().equals(student.getId())) {
				modelMap.put("student", student);
				modelMap.put("message", "学生学号已存在，请重新输入!");
				return "cardsys/addstudent";
			}
			studentService.update(student);
		}
		
		return "redirect:list.html";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		
		return "cardsys/addstudent";
	}
	
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(int id, ModelMap modelMap) {
		User student = studentService.getStudentById(id);
		
		modelMap.put("student", student);
		return "cardsys/addstudent";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(int id, ModelMap modelMap) {
		studentService.deleteById(id);
		
		return "redirect:list.html";
	}
}
