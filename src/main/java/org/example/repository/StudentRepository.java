package org.example.repository;

import org.example.entities.Student;
import org.example.entities.dtos.response.StudentResponseDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{'classId': ?0}")
    List<Student> findStudentsByClassId(String classId);
}
