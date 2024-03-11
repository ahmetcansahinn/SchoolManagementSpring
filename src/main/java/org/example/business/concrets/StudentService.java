package org.example.business.concrets;

import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.IStudentService;
import org.example.entities.Student;
import org.example.entities.dtos.request.StudentRequestDto;
import org.example.entities.dtos.response.StudentResponseDto;
import org.example.repository.ClassRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;


    private final ModelMapper modelMapper;
    @Override
    public List<StudentRequestDto> getAll() {
        List<Student> students= studentRepository.findAll();

        List<StudentRequestDto> studentRequestDtos=new ArrayList<>();
        for(Student student: students){
            studentRequestDtos.add(modelMapper.map(student,StudentRequestDto.class));
        }
        return studentRequestDtos;
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto requestDto) {
        Student student= modelMapper.map(requestDto, Student.class);

        Student savedStudent=studentRepository.save(student);

        return modelMapper.map(savedStudent, StudentResponseDto.class);

    }

    @Override
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);

    }

    @Override
    public StudentResponseDto updateStudent(String studentId, StudentRequestDto requestDto) {
        Student student=studentRepository.findById(studentId).orElseThrow();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(requestDto,Student.class);
        Student updatedStudent=studentRepository.save(student);
        return modelMapper.map(updatedStudent,StudentResponseDto.class);
    }
}
