package org.example.business.concrets;


import lombok.RequiredArgsConstructor;
import org.example.business.abstracts.IClassService;
import org.example.entities.Class;
import org.example.entities.dtos.request.ClassRequestDto;
import org.example.entities.dtos.response.ClassResponseDto;
import org.example.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClassService implements IClassService {

    private final ClassRepository classRepository;
    private final ModelMapper modelMapper;


    @Override
    public ClassResponseDto addClass(ClassRequestDto requestDto) {

        /*Class class1=Class.builder()
                .quota(requestDto.getQuota())
                .students(requestDto.getStudents())
                .build();*/
        Class class1= modelMapper.map(requestDto,Class.class);
        Class savedClass=classRepository.save(class1);

        return modelMapper.map(savedClass,ClassResponseDto.class);

        /*ClassResponseDto.builder()
                .classId(savedClass.getClassId())
                .quota(savedClass.getQuota())
                .students(savedClass.getStudents())
                .build();*/
    }

    @Override
    public List<ClassRequestDto> getAll() {
        List<Class> class1=classRepository.findAll();

        List<ClassRequestDto> requestDtos=new ArrayList<>();
        for(Class class2 : class1){
            requestDtos.add(modelMapper.map(class2,ClassRequestDto.class));
        }

        return requestDtos;
    }

    @Override
    public void deleteClass(String classId) {
        classRepository.deleteById(classId);
    }

    @Override
    public ClassResponseDto updateClass(String classId, ClassRequestDto requestDto) {
        Class class1=classRepository.findById(classId)
                .orElseThrow(()->new NoSuchElementException("Böyle bir Sınıf bulunamadı."));

        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.map(requestDto,class1);

        Class updatedClass=classRepository.save(class1);

        return modelMapper.map(updatedClass, ClassResponseDto.class);


    }
}
