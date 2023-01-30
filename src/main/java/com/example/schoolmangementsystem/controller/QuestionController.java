package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.repositories.QuestionRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class QuestionController
{
	final QuestionRepository repo;
}
