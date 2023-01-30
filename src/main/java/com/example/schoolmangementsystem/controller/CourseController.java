package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.model.Course;
import com.example.schoolmangementsystem.model.Exam;
import com.example.schoolmangementsystem.model.Student;
import com.example.schoolmangementsystem.repositories.CourseRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@Data
@RequestMapping("/course")
public class CourseController
{
	final CourseRepository repo;

	@PostMapping("createCourse")
	public void createCourse(Model model, Course course)
	{
		try
		{
			course.setHours(3);
			course.setStudents(new ArrayList<>());
			repo.save(course);
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("addStudent")
	public void addStudent(Model model, UUID id, Student student)
	{
		try
		{
			Optional<Course> byId = repo.findById(id);
			if (byId.isPresent())
			{
				Course course = byId.get();
				course.getStudents().add(student);
				repo.save(course);
			}
			else
			{
				model.addAttribute("errMessage", "Couldn't find the course");
			}
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("removeStudent")
	public void removeStudent(Model model, UUID id, Student student)
	{
		try
		{
			Optional<Course> byId = repo.findById(id);
			if (byId.isPresent())
			{
				Course course = byId.get();
				course.getStudents().remove(student);
				repo.save(course);
			}
			else
			{
				model.addAttribute("errMessage", "Couldn't find the course");
			}
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("addExam")
	public void addExam(Model model, UUID id, Exam exam)
	{
		try
		{
			Optional<Course> byId = repo.findById(id);
			if (byId.isPresent())
			{
				Course course = byId.get();
				course.getExams().add(exam);
				repo.save(course);
			}
			else
			{
				model.addAttribute("errMessage", "Couldn't find the course");
			}
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}

	@PostMapping("removeExam")
	public void removeExam(Model model, UUID id, Exam exam)
	{
		try
		{
			Optional<Course> byId = repo.findById(id);
			if (byId.isPresent())
			{
				Course course = byId.get();
				course.getExams().remove(exam);
				repo.save(course);
			}
			else
			{
				model.addAttribute("errMessage", "Couldn't find the course");
			}
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}
}
