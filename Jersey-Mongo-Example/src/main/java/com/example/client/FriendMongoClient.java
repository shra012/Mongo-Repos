package com.example.client;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class FriendMongoClient {
	MongoClient client;
	MongoDatabase database;
	MongoCollection<Document> collection;
	public FriendMongoClient(){
		client = new MongoClient();
		database = client.getDatabase("test");
		collection = database.getCollection("friends");
	}
	public MongoCollection<Document> getCollection() {
		return collection;
	}
	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}
}
