package com.example.service;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Friend> insert(Friend friend) {
		ArrayList<Friend> friendList = new ArrayList<Friend>();
		friendList.add(friend);
		return insertAll(friendList);
	}

	@Override
	public List<Friend> insertAll(List<Friend> friendList) {
		friendList = upsert(friendList);
		return friendList;
	}

	@Override
	public List<Friend> delete(Friend friend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> update(Friend friend) {
		return null;
	}

	public long updateOne(Friend friend) {
		return collection.updateOne(
				and(eq("firstName", friend.getFirstName()),eq("lastName", friend.getLastName())),
				combine(set("firstName", friend.getFirstName()),set("lastName", friend.getLastName()))
				).getMatchedCount();
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

	public List<Friend> upsert(List<Friend> friendList){
		return friendList.stream().filter(friend -> {
			update(friend);
			long count = updateOne(friend);
			if(count == 0) {
				collection.insertOne(friend);
				return false;
			}else {
				return true;
			}
		}).map(friend -> {
			return collection.find(and(eq("firstName", friend.getFirstName()),eq("lastName", friend.getLastName()))).first();
		}).collect(Collectors.toList());
	}

}
