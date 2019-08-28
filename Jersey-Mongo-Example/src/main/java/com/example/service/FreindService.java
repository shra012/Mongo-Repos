package com.example.service;

import java.util.List;

import com.example.model.Model;

public interface FreindService {
	public List<Model> findAll();
	public List<Model> insert(Model model);
	public List<Model> delete(Model model);
	public List<Model> update(Model model);
	public List<Model> findByName(String name);
	public List<Model> deleteByName(String name);
}
