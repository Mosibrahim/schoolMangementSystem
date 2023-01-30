package com.example.schoolmangementsystem.repositories;

import com.example.schoolmangementsystem.model.ClassRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClassRoomRepository extends CrudRepository<ClassRoom, UUID>
{
}
