package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.repositories.TeacherRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class TeacherController
{
	final TeacherRepository repo;
}
