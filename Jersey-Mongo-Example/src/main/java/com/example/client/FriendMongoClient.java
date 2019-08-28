package com.example.client;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.example.model.Friend;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public final class FriendMongoClient {
	private static FriendMongoClient client = new FriendMongoClient();
	private MongoCollection<Friend> collection;
	
	private FriendMongoClient(){
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClient client = MongoClients.create(
		        MongoClientSettings.builder()
		                .applyToClusterSettings(builder ->builder.hosts(Arrays.asList(new ServerAddress("localhost", 27017))))
		                .codecRegistry(pojoCodecRegistry)
		                .build());
		
		MongoDatabase database = client.getDatabase("test");
		collection = database.getCollection("friends", Friend.class);
	}
	public static FriendMongoClient getInstance() {
		return client;
	}
	
	public MongoCollection<Friend> getCollection() {
		return collection;
	}
	
}
