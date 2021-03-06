package com.KOPO.Students;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value = "/manageScore", method = RequestMethod.GET)
	public String manageScore(Locale locale, Model model) {
		
		return "manageScore";
	}
	
	@RequestMapping(value = "/insert_action", method = RequestMethod.POST)
	public String insertAction(Locale locale, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			Test test = new Test(name, kor, eng, math);
			String dbUrl = "//Users//saebyul//SqliteDB//students.db";
			DB db = new DB(dbUrl, "test");
			db.open();
			db.insertData(test);
			db.close();
		} catch (Exception e) {
			
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/select_action", method = RequestMethod.POST)
	public String selectAction(Locale locale, Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String dbUrl = "//Users//saebyul//SqliteDB//students.db";
			DB db = new DB(dbUrl, "test");
			db.open();
			Test result = db.selectData(idx);
			db.close();
		} catch (Exception e) {
			
		}
		
		return "report";
	}
	

	
	
}
