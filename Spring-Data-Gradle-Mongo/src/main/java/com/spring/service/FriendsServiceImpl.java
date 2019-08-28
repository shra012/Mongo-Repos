package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Friend;
import com.spring.repository.FriendsRepository;

@Service
public class FriendsServiceImpl implements FreindsSerice {
	
	@Autowired
	FriendsRepository respository;

	@Override
	public List<Friend> findAll() {
		return respository.findAll();
	}

	@Override
	public Friend findOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> delete(Friend friend) {
		respository.deleteByFirstName(friend.getFirstName());
		return respository.findAll();
	}

	@Override
	public List<Friend> insert(Friend friend) {
		respository.save(friend);
		return respository.findAll();
	}

	

}
