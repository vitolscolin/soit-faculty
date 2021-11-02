package com.soit.soitfaculty;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soit.soitfaculty.entity.Faculty;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {

	// upload faculty info
	private List<Faculty> theFaculties;

	@PostConstruct
	private void loadData() {

		// create faculties
		Faculty fac1 = new Faculty(1, "Dave", "Smith", "dave@uc.edu");
		Faculty fac2 = new Faculty(2, "John", "Doe", "john@uc.edu");
		Faculty fac3 = new Faculty(3, "Robert", "Lee", "robert@uc.edu");

		// create list
		theFaculties = new ArrayList<>();

		// add to list
		theFaculties.add(fac1);
		theFaculties.add(fac2);
		theFaculties.add(fac3);

	}

	// mapping for "/list"
	@GetMapping("/list")
	public String listFaculties(Model theModel) {

		// add faculties to the spring model
		theModel.addAttribute("faculties", theFaculties);

		return "list-faculties";
	}

}