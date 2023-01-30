package com.example.schoolmangementsystem.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Student extends BaseEntity
{
	Integer level;
	Double gpa;
}
