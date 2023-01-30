package com.example.schoolmangementsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course extends BaseEntity
{
	Integer hours;
	@OneToMany(cascade = CascadeType.ALL)
	List<Exam> exams;
	@OneToMany
	List<Student> students;
}
