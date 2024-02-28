package org.example.business.abstracts;


import org.example.entities.dtos.request.TeacherRequestDto;
import org.example.entities.dtos.response.TeacherResponseDto;

import java.util.List;

public interface ITeacherService {

    TeacherResponseDto addTeacher(TeacherRequestDto requestDto);
    List<TeacherRequestDto> getAll();

    void deleteTeacher(String teacherId);

    TeacherResponseDto update(String teacherId, TeacherRequestDto requestDto);
}
