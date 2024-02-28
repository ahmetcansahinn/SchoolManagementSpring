package org.example.repository;

import org.example.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    void deleteByTeacherId(String teacherId);

    Teacher findByTeacherId(String teacherId);


}
