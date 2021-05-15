package com.dev22.blogjpaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev22.blogjpaspringboot.model.Post;

public interface CodeBlogRepository extends JpaRepository<Post, Long> {

	
}
