package com.example.schoolmangementsystem.controller;

import com.example.schoolmangementsystem.repositories.ClassRoomRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller
@Data
public class ClasseController
{
	final ClassRoomRepository repo;

}
