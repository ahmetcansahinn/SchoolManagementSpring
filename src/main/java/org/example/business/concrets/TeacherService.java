package org.example.business.concrets;


import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.ITeacherService;
import org.example.entities.Teacher;
import org.example.entities.dtos.request.TeacherRequestDto;
import org.example.entities.dtos.response.TeacherResponseDto;
import org.example.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class TeacherService implements ITeacherService {

    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;
    @Override
    public TeacherResponseDto addTeacher(TeacherRequestDto requestDto) {
        Teacher teacher = Teacher.builder()
                .teacherName(requestDto.getTeacherName())
                .teacherLastName(requestDto.getTeacherLastName())
                .branch(requestDto.getBranch())
                .classes(requestDto.getClasses())
                .build();

        Teacher savedTeacher = teacherRepository.save(teacher);

        return TeacherResponseDto.builder()
                .teacherId(savedTeacher.getTeacherId())
                .teacherName(savedTeacher.getTeacherName())
                .teacherLastName(savedTeacher.getTeacherLastName())
                .branch(savedTeacher.getBranch())
                .classes(savedTeacher.getClasses())
                .build();
    }

    @Override
    public List<TeacherRequestDto> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();

        List<TeacherRequestDto> requestDtos = new ArrayList<>();
        for (Teacher teacher : teachers) {
            requestDtos.add(modelMapper.map(teacher, TeacherRequestDto.class));
        }

        return requestDtos;
    }

    @Override
    public void deleteTeacher(String teacherId) {
        teacherRepository.deleteByTeacherId(teacherId);
    }

    @Override
    public TeacherResponseDto update(String teacherId, TeacherRequestDto requestDto) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("Öğretmen bulunamadı"));

        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.map(requestDto, teacher);

        Teacher updatedTeacher = teacherRepository.save(teacher);

        return modelMapper.map(updatedTeacher, TeacherResponseDto.class);
    }
    }

