package com.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Friend;
import com.spring.service.FreindsSerice;

@RestController
public class FreindsController {

	@Autowired
	FreindsSerice service;
	
	@RequestMapping(value="/Friends/getFriends", method=RequestMethod.GET)
	public List<Friend>  getFrinds() {
		return service.findAll();
	}
	
	@RequestMapping(value="/Friends/saveFrinds", method=RequestMethod.POST)
	public List<Friend>  saveFrinds(@RequestBody Friend friend) {
		return service.insert(friend);
	}
	
	@RequestMapping(value="/Friends/deleteFrinds", method=RequestMethod.DELETE)
	public List<Friend>  deleteFrinds(@RequestBody Friend friend) {
		return service.delete(friend);
	}
}
