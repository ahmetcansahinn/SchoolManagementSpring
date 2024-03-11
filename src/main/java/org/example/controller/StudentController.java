package org.example.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.IStudentService;
import org.example.entities.dtos.request.StudentRequestDto;
import org.example.entities.dtos.response.StudentResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentRequestDto>> getAll(){
        List<StudentRequestDto> getAll=studentService.getAll();

        return new ResponseEntity<List<StudentRequestDto>>(getAll, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") String studentId){
        studentService.deleteStudent(studentId);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto requestDto){
        studentService.addStudent(requestDto);

        return new ResponseEntity<StudentResponseDto>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentResponseDto> updateStudent
            (@PathVariable("id") String studentId, @RequestBody  StudentRequestDto requestDto){
        studentService.updateStudent(studentId, requestDto);

        return new ResponseEntity<StudentResponseDto>(HttpStatus.OK);
    }

}
