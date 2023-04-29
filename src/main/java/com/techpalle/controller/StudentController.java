package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.AdminDao;
import com.techpalle.dao.StudentDao;
import com.techpalle.model.Admin;
import com.techpalle.model.Student;

@Controller
public class StudentController {
	@RequestMapping("editStudent")
	public ModelAndView editStudentDetails(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv = insertStudentServlet(req);
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView editStudent(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int i = Integer.parseInt(req.getParameter("id"));
		
		Student s = StudentDao.getOneStudent(i);
		
		mv.addObject("student", s);
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteStudent(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int i = Integer.parseInt(req.getParameter("id"));
		
		StudentDao.deleteStudent(i);

		mv = displayAllStudents();
		return mv;
	}
	
	@RequestMapping("admin")
	public ModelAndView validateAdmin(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String au = req.getParameter("tbAdminUsername");
		String ap = req.getParameter("tbAdminPassword");
		
		Admin a = new Admin(au, ap);
		
		boolean b = AdminDao.validateAdmin(a);
		if (b){
			mv.setViewName("index.jsp");
		}
		else {
			mv.setViewName("login.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value="student", params="show")
	public ModelAndView displayAllStudents() {
		ModelAndView mv = new ModelAndView();
		
		//Call the DAO method
		ArrayList<Student> alStud = StudentDao.getAllStudents();
		
		//We need to redirect user to display.jsp with ArrayList Data:
		mv.addObject("student", alStud);
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="student", params="reg")
	public ModelAndView getRegisterPage() {
		ModelAndView mv = new ModelAndView();
		Student s = null;
		mv.addObject("student", s);
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping(value="student", params="signout")
	public ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("insert")
	public ModelAndView insertStudentServlet(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String n = req.getParameter("tbName");
		String e = req.getParameter("tbEmail");
		String p = req.getParameter("tbPass");
		Long m = Long.parseLong(req.getParameter("tbMobile"));
		
		Student stud = new Student(n, e, p, m);
		
		StudentDao.insertStudent(stud);
		
		mv= displayAllStudents();
		
		return mv;
	}
}
