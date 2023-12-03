package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.WishList;

public interface WishListRepository extends JpaRepository<WishList, Integer>{

}
