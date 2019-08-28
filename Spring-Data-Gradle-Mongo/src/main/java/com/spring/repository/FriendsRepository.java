package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.model.Friend;

public interface FriendsRepository  extends MongoRepository<Friend, String>{
	List<Friend> findAll();
	Page<Friend> findAll(Pageable pageable);
	Friend findByFirstName(int runnerId);
	List<Friend> deleteByLastName(String name);
	List<Friend> deleteByFirstName(String name);
}
