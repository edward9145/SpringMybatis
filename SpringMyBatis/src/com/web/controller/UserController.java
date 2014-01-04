package com.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.domain.User;
import com.web.service.UserService;
import com.web.util.Str;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/register")
	public String register(User user, HttpServletRequest request, Model model) {
		if(StringUtils.isBlank(user.getUsername())){
			model.addAttribute("msg", Str.name_null);
			return "user/register";
		}
		if(StringUtils.isBlank(user.getPassword())){
			model.addAttribute("msg", Str.password_null);
			return "user/register";
		}
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		String result = userService.register(user);
		
		if(result == Str.name_existed){
			model.addAttribute("msg", Str.name_existed);
			return "user/register";
		}
		request.getSession().setAttribute("user", user);
		model.addAttribute("user", user);
		return "user/info";
	}
	
	@RequestMapping("/info")
	public String info(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) return "user/login";
		model.addAttribute("user", user);
		return "user/info";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, HttpServletRequest request, Model model) {
		System.out.println(username + " " + password);
		if(StringUtils.isBlank(username)) model.addAttribute("msg", Str.name_null);
		if(StringUtils.isBlank(password)){
			model.addAttribute("msg", Str.password_null);
			return "user/login";
		}
		
		if( !StringUtils.isBlank(username)){
			User user = userService.login(username, DigestUtils.md5Hex(password));
			request.getSession().setAttribute("user", user);
			if(user == null) return "user/login";
		}
		return "redirect:info";
	}
	
	@RequestMapping("/option")
	public String option(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user", user);
		return "user/option";
	}
	@RequestMapping("/update")
	public String update(String password, String new_password, Integer age, Float height, 
			HttpServletRequest request, Model model) {
		if(StringUtils.isBlank(password)){
			model.addAttribute("msg", Str.password_null);
			return "user/option";
		}
		password = DigestUtils.md5Hex(password);
		User user = (User) request.getSession().getAttribute("user");
		if(user.getPassword().equals(password)){
			if( ! StringUtils.isBlank(new_password)) 
				user.setPassword(DigestUtils.md5Hex(new_password));
			if(age != null) user.setAge(age);
			if(height != null) user.setHeight(height);
			
			userService.update(user);
			return "redirect:info";
		}
		model.addAttribute("msg", Str.password_error);
		return "user/option";
	}
	
	@RequestMapping("/remove")
	public String remove(String password, HttpServletRequest request, Model model) {
		if(StringUtils.isBlank(password)){
			model.addAttribute("msg", Str.password_null);
			return "user/remove";
		}
		password = DigestUtils.md5Hex(password);
		
		User user = (User) request.getSession().getAttribute("user");
		model.addAttribute("user", user);
		
		if(user.getPassword().equals(password)){
			userService.remove(user.getId());
			model.addAttribute("msg", user.getUsername() + " removed");
			return "user/login";
		}
		model.addAttribute("msg", Str.password_error);
		return "user/remove";
		
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public User user(String id) {
		return userService.json(id);
	}
 
}
