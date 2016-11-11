package org.launchcode.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloLog;
import org.launchcode.models.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
	
	@Autowired
	private HelloLogDao helloLogDao;
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm () {
		return "helloform";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)

	public String hello(HttpServletRequest request, Model model) {
		
		// get name parameter from request; will be null of no parameter passed in
		String name = request.getParameter("name");
		
		if (name == null || name == "") {
			name = "world";
		}
		HelloLog log = new HelloLog(name);
		helloLogDao.save(log);
		model.addAttribute("message", HelloMessage.getMessage(name));
		model.addAttribute("title", "Hello, Spring! Reponse");
		return "hello"; //if having folders, put in the path name
	}
	
	@RequestMapping(value = "/log")
	public String log(Model model) {
		List<HelloLog> logs = helloLogDao.findAll();
		model.addAttribute("logs", logs);
		model.addAttribute("title", "Hello Logs!");
		return "log";
	}
	
}
