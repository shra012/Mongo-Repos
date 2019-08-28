package com.example.service;

import java.util.List;

import com.example.model.Friend;

public interface FreindService {
	public List<Friend> findAll();
	public Friend insert(Friend friend);
	public List<Friend> insertAll(List<Friend> friends);
	public List<Friend> delete(Friend friend);
	public List<Friend> update(Friend friend);
	public List<Friend> findByName(String friend);
	public List<Friend> deleteByName(String friend);
}
