package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface QuestionRepository extends CrudRepository<Question, UUID>
{
}
