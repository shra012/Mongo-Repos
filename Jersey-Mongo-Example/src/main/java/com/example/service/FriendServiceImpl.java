package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.client.FriendMongoClient;
import com.example.model.Friend;
import com.mongodb.client.MongoCollection;

public class FriendServiceImpl implements FreindService {
	
	MongoCollection<Friend> collection = FriendMongoClient.getInstance().getCollection();
	
	@Override
	public List<Friend> findAll() {
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		collection.find().into(friendList);
		return friendList;
	}

	@Override
	public Friend insert(Friend friend) {
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		friendList.add(friend);
		return insertAll(friendList).get(0);
	}
	
	@Override
	public List<Friend> insertAll(List<Friend> friendList) {
		collection.insertMany(friendList);
		return friendList;
	}

	@Override
	public List<Friend> delete(Friend friend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> update(Friend friend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> deleteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void assembleFriendFromEntrySet(List<Friend> friendList){
		
	}

}
