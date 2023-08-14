package com.example.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.RegistrationForm;
import com.example.model.Result;
import com.example.model.Student;
import com.example.model.User;
import com.example.service.RegistrationFormService;
import com.example.service.ResultService;
import com.example.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RegistrationFormService formService;

	@Autowired
	private ResultService resultService;

	@RequestMapping(value = "/registration_form", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		return "registration_form";
	}

	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("student") Student student) {
		studentService.saveOrUpdateStudent(student);
		return "home";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}


	@GetMapping("/form/{id}")
	public String showForm(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);

		List<RegistrationForm> forms = formService.getFormsByStudentId(id);
		model.addAttribute("forms", forms);
		return "registration_form";
	}

	@PostMapping("/student/saveForm")
	public String saveForm(@ModelAttribute("form") RegistrationForm form) {
		formService.saveOrUpdateForm(form, null);
		return "redirect:/student/form/" + form.getStudent().getId();
	}

	@GetMapping("/results/{id}")
	public String showResults(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);

		List<Result> results = resultService.getResultsByStudentId(id);
		model.addAttribute("results", results);
		return "results";
	}
}
