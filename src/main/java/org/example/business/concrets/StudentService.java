package org.example.business.concrets;

import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.IStudentService;
import org.example.core.exceptions.types.BusinessException;
import org.example.entities.Class;
import org.example.entities.Student;
import org.example.entities.dtos.request.StudentRequestDto;
import org.example.entities.dtos.response.StudentResponseDto;
import org.example.repository.ClassRepository;
import org.example.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final MessageSource messageSource;


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
        studentNumberIfLessThanZero(requestDto.getStudentNumber());
        Student student = modelMapper.map(requestDto, Student.class);
        Student savedStudent = studentRepository.save(student);

        
        Class class1 = classRepository.findById(requestDto.getClassId()).orElse(null);
        if (class1 != null) {
            class1.addStudent(savedStudent);
             classRepository.save(class1);
        }

        return modelMapper.map(savedStudent, StudentResponseDto.class);
    }

    @Override
    public void deleteStudent(String studentId) {
        Student studentToDelete=returnStudentByIdIfExists(studentId);
        studentRepository.delete(studentToDelete);

    }

    @Override
    public StudentResponseDto updateStudent(String studentId, StudentRequestDto requestDto) {
        Student studentIfExist = returnStudentByIdIfExists(studentId);
        Student student=studentRepository.findById(studentId).orElseThrow();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(requestDto,Student.class);
        Student updatedStudent=studentRepository.save(student);
        return modelMapper.map(updatedStudent,StudentResponseDto.class);
    }

    @Override//Daha bitmedi controller eklenecek.
    public List<StudentResponseDto> findStudentsByClassId(String classId) {
        List<Student> students = studentRepository.findStudentsByClassId(classId);
        return students.stream()
                .map(student -> modelMapper.map(student, StudentResponseDto.class))
                .collect(Collectors.toList());
    }
    private Student returnStudentByIdIfExists(String id){
        Student studentToDelete = studentRepository.findById(id).orElse(null);
        if(studentToDelete==null)
            throw new BusinessException(
                    messageSource.getMessage("studentDoesNotExistWithGivenId", new Object[] {id}, LocaleContextHolder.getLocale()));
        return studentToDelete;
    }
    private void studentNumberIfLessThanZero(int studentNumber){
        if(studentNumber<=0){
            throw new BusinessException(messageSource.getMessage("studentNumberCanNotLessThanZero", new Object[]{studentNumber}
            ,LocaleContextHolder.getLocale()));
        }
    }
}
