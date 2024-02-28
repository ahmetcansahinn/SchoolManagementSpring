package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.ITeacherService;
import org.example.entities.Teacher;
import org.example.entities.dtos.request.TeacherRequestDto;
import org.example.entities.dtos.response.TeacherResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final ITeacherService teacherService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherRequestDto>> getAllTeacher(){
        List<TeacherRequestDto> getAllTeacher=teacherService.getAll();

        return new ResponseEntity<List<TeacherRequestDto>>(getAllTeacher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDto> addTeacher(@RequestBody TeacherRequestDto requestDto){
        teacherService.addTeacher(requestDto);

        return new ResponseEntity("ürün başarı ile eklendi", HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") @RequestBody String teacherId){
        teacherService.deleteTeacher(teacherId);

        return new ResponseEntity<Teacher>(HttpStatus.ACCEPTED);
    }
    @PutMapping("{id}")
    public ResponseEntity<TeacherResponseDto> update(@PathVariable("id") String teacherId, @RequestBody TeacherRequestDto requestDto) {
        TeacherResponseDto updatedTeacher = teacherService.update(teacherId, requestDto);

        return ResponseEntity.ok(updatedTeacher);
    }


}
