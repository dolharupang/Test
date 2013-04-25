package com.caotico.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caotico.test.dao.UserDAO;
import com.caotico.test.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource (name="userDAO")
	private UserDAO userDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		int count = userDAO.getResult();
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("count", count);
		
		return "home";
	}
	
	@RequestMapping(value = "/testJSON", produces="application/json", method=RequestMethod.GET)
	public @ResponseBody User testJson(Locale local, Model model) {
		User user = new User();
		user.setId(50);
		
		return user;
	}
}
