package com.example.schoolmangementsystem.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity
{
	@Id
	long id;
	String name1;
	String name2;
	String code;
}
