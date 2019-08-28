package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.example.client.FriendMongoClient;
import com.example.model.Model;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mongodb.client.MongoCollection;

public class FriendServiceImpl implements FreindService {

	FriendMongoClient client;
	MongoCollection<Document> collection;
	
	@Override
	public List<Model> findAll() {
		client = new FriendMongoClient();
		collection = client.getCollection();
		
		List<Document> 
		foundDocument = collection.find().into(new ArrayList<Document>());
		List<Model> modelList = null;
		if(null!=foundDocument && !foundDocument.isEmpty()){
			modelList = new ArrayList<Model>();
			for(Document document : foundDocument){
				Gson gson = new Gson();
				JsonElement jsonElement = gson.toJsonTree(document);
				Model model = gson.fromJson(jsonElement, Model.class);
				modelList.add(model);
				/*document.entrySet().forEach(entry -> {
					if(entry.getKey()=="_id"){
						model.setId(entry.getValue().toString());
					}else if(entry.getKey()=="firstName"){
						model.setFirstName(entry.getValue().toString());
					} else if(entry.getKey()=="lastName"){
						model.setLastName(entry.getValue().toString());
					}
				});*/
			}
			
		}
		return modelList;
	}

	@Override
	public List<Model> insert(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> delete(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> update(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> deleteByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void assembleModelFromEntrySet(List<Model> modelList){
		
	}

}
