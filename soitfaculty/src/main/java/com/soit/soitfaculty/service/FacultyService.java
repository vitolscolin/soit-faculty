package com.soit.soitfaculty.service;

import java.util.List;

import com.soit.soitfaculty.entity.Faculty;

public interface FacultyService {
	
	public List<Faculty> findAll();
	public Faculty findByID(int id);
	public void save(Faculty theFaculty);
	public void delete(int id);
}
