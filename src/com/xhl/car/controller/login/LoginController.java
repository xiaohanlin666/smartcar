package com.xhl.car.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	//private UserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String username , @RequestParam String password, HttpServletRequest request)
	{
		logger.info("username==="+username);
		logger.info("password==="+password);
		HttpSession session=request.getSession();
		ModelAndView mv = new ModelAndView("/home");
		//UserDto user=userService.selectByUsername(username);
		Map<String,String> user=new HashMap<String,String>();
		user.put("username", "xiaohanlin");
		user.put("password", "Xiao123456*");
		if(user.get("username").equals(username)&&user.get("password").equals(password))
			session.setAttribute("userInfo", user);
		
		return mv;
	}

}
