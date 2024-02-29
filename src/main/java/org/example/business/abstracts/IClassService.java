package org.example.business.abstracts;

import org.example.entities.dtos.request.ClassRequestDto;
import org.example.entities.dtos.response.ClassResponseDto;

import java.util.List;

public interface IClassService {

    ClassResponseDto addClass(ClassRequestDto requestDto);

    List<ClassRequestDto> getAll();

    void deleteClass(String classId);

    ClassResponseDto updateClass(String classId, ClassRequestDto requestDto);
}
