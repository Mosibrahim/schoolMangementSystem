package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CourseRepository extends CrudRepository<Course, UUID>
{
}
