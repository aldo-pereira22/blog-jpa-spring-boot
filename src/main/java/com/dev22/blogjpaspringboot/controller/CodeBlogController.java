package com.dev22.blogjpaspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dev22.blogjpaspringboot.model.Post;
import com.dev22.blogjpaspringboot.service.CodeBlogService;

@Controller
public class CodeBlogController {

	@Autowired
	CodeBlogService codBlogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv =  new ModelAndView("posts");
		List<Post> posts = codBlogService.findAll();
		mv.addObject("posts", posts);
		return mv;		
	}
	
}
