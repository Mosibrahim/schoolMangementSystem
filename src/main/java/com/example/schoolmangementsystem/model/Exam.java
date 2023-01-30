package com.example.schoolmangementsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Exam extends BaseEntity
{
	@SuppressWarnings("JpaAttributeTypeInspection")
	@OneToMany(cascade = CascadeType.ALL)
	List<Question> questions;

}
