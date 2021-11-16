package com.soit.soitfaculty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soit.soitfaculty.dao.FacultyRepository;
import com.soit.soitfaculty.entity.Faculty;

@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;

	@Autowired
	public FacultyServiceImpl(FacultyRepository theFacultyRepository) {
		facultyRepository = theFacultyRepository;
	}

	@Override
	public List<Faculty> findAll() {
		return facultyRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Faculty findById(int id) {
		Optional<Faculty> facultyid = facultyRepository.findById(id);

		Faculty theFaculty = null;
		if (facultyid.isPresent()) {
			theFaculty = facultyid.get();

		} else {

			throw new RuntimeException("The Faculty ID you entered is incorrect - " + id);
		}
		return theFaculty;
	}

	@Override
	public void save(Faculty theFaculty) {
		facultyRepository.save(theFaculty);

	}

	@Override
	public void delete(int id) {
		facultyRepository.deleteById(id);

	}

}
