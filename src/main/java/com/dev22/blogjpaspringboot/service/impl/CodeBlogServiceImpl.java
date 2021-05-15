package com.dev22.blogjpaspringboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev22.blogjpaspringboot.model.Post;
import com.dev22.blogjpaspringboot.repository.CodeBlogRepository;
import com.dev22.blogjpaspringboot.service.CodeBlogService;

@Service
public class CodeBlogServiceImpl implements CodeBlogService{

	@Autowired
	CodeBlogRepository codeBlogRepository;
	
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return codeBlogRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		// TODO Auto-generated method stub
		return codeBlogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return codeBlogRepository.save(post);
	}
	
	
}
