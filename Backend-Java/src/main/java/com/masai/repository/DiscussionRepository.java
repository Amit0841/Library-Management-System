package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Discussions;

public interface DiscussionRepository extends JpaRepository<Discussions, Integer>{

}
