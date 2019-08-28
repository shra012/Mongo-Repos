package com.spring.service;

import java.util.List;

import com.spring.model.Friend;

public interface FreindsSerice {

	List<Friend> findAll();
	Friend findOne(String name);
	List<Friend> delete(Friend name);
	List<Friend> insert(Friend name);
}
