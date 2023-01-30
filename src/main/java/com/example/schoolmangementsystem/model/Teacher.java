package com.example.schoolmangementsystem.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Teacher extends BaseEntity
{
	String specialization;
}
