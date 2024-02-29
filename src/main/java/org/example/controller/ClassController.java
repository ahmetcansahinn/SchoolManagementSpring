package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.IClassService;
import org.example.entities.dtos.request.ClassRequestDto;
import org.example.entities.dtos.response.ClassResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")
public class ClassController {

    private final IClassService classService;

    @PostMapping()
    public ResponseEntity<ClassResponseDto> addClass(@RequestBody ClassRequestDto requestDto){
        classService.addClass(requestDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ClassRequestDto>> getAllClass(){
        List<ClassRequestDto> getAllClass=classService.getAll();

        return new ResponseEntity<List<ClassRequestDto>>(getAllClass,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable String classId){
        classService.deleteClass(classId);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @PutMapping("{id}")
    public ResponseEntity<ClassResponseDto> updateClass(@PathVariable("{id}") String classId, @RequestBody ClassRequestDto requestDto){
        classService.updateClass(classId, requestDto);

        return new ResponseEntity<ClassResponseDto>(HttpStatus.OK);
    }
}
