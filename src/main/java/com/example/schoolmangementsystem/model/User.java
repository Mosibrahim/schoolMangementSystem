package com.example.schoolmangementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity
{
	private String userName;
	@ManyToMany
	List<UserRole> roles;
}
