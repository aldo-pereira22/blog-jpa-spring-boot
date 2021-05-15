package com.dev22.blogjpaspringboot.service;

import java.util.List;

import com.dev22.blogjpaspringboot.model.Post;

public interface CodeBlogService {

	List<Post> findAll();
	Post findById(Long id);
	Post save(Post post);
	
}
