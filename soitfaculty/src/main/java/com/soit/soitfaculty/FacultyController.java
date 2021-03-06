package com.soit.soitfaculty;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soit.soitfaculty.entity.Faculty;
import com.soit.soitfaculty.service.FacultyService;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {

	public FacultyService facultyService;

	public FacultyController(FacultyService theFacultyService) {
		facultyService = theFacultyService;
	}

	// mapping for "/list"
	@GetMapping("/list")
	public String listFaculties(Model theModel) {

		// get faculty from db
		List<Faculty> theFaculties = facultyService.findAll();

		// add faculties to the spring model
		theModel.addAttribute("faculties", theFaculties);

		return "faculties/list-faculties";
	}

	@GetMapping("/viewAddForm")
	public String viewAddForm(Model theModel) {

		// model for data binding
		Faculty theFaculty = new Faculty();

		theModel.addAttribute("faculty", theFaculty);

		return "faculties/faculty-form";
	}

	@GetMapping("/viewUpdateForm")
	public String viewUpdateForm(@RequestParam("facultyId") int theId, Model theModel) {

		// retrive the faculty from the service layer
		Faculty theFaculty = facultyService.findById(theId);
		// pre-poplate the form by setting the faculty as a model attribute
		theModel.addAttribute("faculty", theFaculty);
		
		return "faculties/faculty-form";
	}

	@PostMapping("/save")
	public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty) {
		// register faculty
		facultyService.save(theFaculty);
		// block dup submissions
		return "redirect:/Faculties/list";

	}
	@GetMapping("/delete")
	public String deleteFaculty(@RequestParam("facultyId") int theId) {
		//remove faculty
		facultyService.delete(theId);
		//return to faulty directory
		return "redirect:/Faculties/list";
		
	}
	
	
}