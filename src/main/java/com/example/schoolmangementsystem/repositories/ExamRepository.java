package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.Exam;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ExamRepository extends CrudRepository<Exam, UUID>
{
}
