package org.example.repository;

import org.example.entities.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClassRepository extends MongoRepository <Class, String> {
    List<Class> findByClassId(String classId);

}
