package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TeacherRepository extends CrudRepository<Teacher, UUID>
{
}
