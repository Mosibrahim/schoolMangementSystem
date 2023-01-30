package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.model.Exam;
import com.example.schoolmangementsystem.model.Question;
import com.example.schoolmangementsystem.repositories.ExamRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Data
@RequestMapping("/exam")
public class ExamController
{
	final ExamRepository repo;

	@PostMapping("/createExam")
	public void createExam(Model model, List<Question> questions)
	{
		try
		{
			Exam exam = new Exam();
			exam.setQuestions(questions);
			repo.save(exam);
		}
		catch (Exception e)
		{
			model.addAttribute("errMessage", e);
		}
	}
}
