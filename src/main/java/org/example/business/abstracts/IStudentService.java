package org.example.business.abstracts;

import org.example.entities.Teacher;
import org.example.entities.dtos.request.StudentRequestDto;
import org.example.entities.dtos.response.StudentResponseDto;

import java.util.List;

public interface IStudentService {

    List<StudentRequestDto> getAll();
    StudentResponseDto addStudent(StudentRequestDto requestDto);
    void deleteStudent(String studentId);
    StudentResponseDto updateStudent(String studentId, StudentRequestDto requestDto);


}
