package org.launchcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.launchcode.models.HelloMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm () {
		return "helloform";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)

	public String hello(HttpServletRequest request, Model model) {
		
		// get name parameter from request; will be null of no parameter passed in
		String name = request.getParameter("name");
		
		if (name == null) {
			name = "world";
		}
		model.addAttribute("message", HelloMessage.getMessage(name));
		return "hello"; //if having folders, put in the path name
	}
	
}
