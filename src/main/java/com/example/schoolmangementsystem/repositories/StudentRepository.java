package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID>
{
}
