package com.example.schoolmangementsystem.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ClassRoom extends BaseEntity
{
	Integer allowedNoOfStudent;
}
