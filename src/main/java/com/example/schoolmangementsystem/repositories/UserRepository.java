package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID>
{
	List<User> findAllUser();
}
