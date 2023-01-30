package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.model.Student;
import com.example.schoolmangementsystem.repositories.StudentRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@Data
@RequestMapping("/student")
@SessionAttributes("student")
public class StudentController
{
	final StudentRepository repo;

	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("name", "mostafa");
		return "home.html";
	}

	@GetMapping("listAllStudent")
	public void listStudents(Model model)
	{
		model.addAttribute("students", new ArrayList<>());
	}

	@PostMapping("createStudent")
	public void createStudent(Model model, Student student)
	{
		try
		{
			repo.save(student);
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("deleteStudent")
	public void deleteStudent(Model model, UUID id)
	{
		try
		{
			repo.deleteById(id);
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("updateStudent")
	public String updateStudent(Model model, UUID id, Student student)
	{
		try
		{
			Optional<Student> byId = repo.findById(id);
			if (byId.isPresent())
			{
				Student std = byId.get();
				std.setLevel(student.getLevel());
				std.setGpa(student.getGpa());
				repo.save(std);
			}
			else
			{
				model.addAttribute("errMessage", "Couldn't find the student");
			}

		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
		return "redirect:students";
	}

}
