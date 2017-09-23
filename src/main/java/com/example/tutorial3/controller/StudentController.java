package com.example.tutorial3.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tutorial3.model.StudentModel;
import com.example.tutorial3.service.*;
import org.springframework.ui.Model;

@Controller
public class StudentController {
	private final StudentService studentService;

	public StudentController() {
		studentService = new InMemoryStudentService();
	}

	@RequestMapping("/student/add")
	public String add(@RequestParam(value="npm",required=true) String npm,
		@RequestParam(value="name",required=true) String name,
		@RequestParam(value="gpa",required=true) double gpa) {
		StudentModel student = new StudentModel(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
	}

	@RequestMapping("/student/view")
	public String add(@RequestParam(value="npm",required=true) String npm, Model model) {
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
}