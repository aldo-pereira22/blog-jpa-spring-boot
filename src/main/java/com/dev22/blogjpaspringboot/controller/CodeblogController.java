package com.dev22.blogjpaspringboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dev22.blogjpaspringboot.model.Post;
import com.dev22.blogjpaspringboot.service.CodeblogService;

@Controller
public class CodeblogController {

	@Autowired
	CodeblogService codBlogService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv =  new ModelAndView("posts");
		List<Post> posts = codBlogService.findAll();
		mv.addObject("posts", posts);
		return mv;		
	}

	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id ) {
		ModelAndView mv =  new ModelAndView("postDetails");
		Post post = codBlogService.findById(id);
		mv.addObject("post", post);
		return mv;		
	}



	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Validated Post post, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos! ");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		
		codBlogService.save(post);
		return "redirect:/posts";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
