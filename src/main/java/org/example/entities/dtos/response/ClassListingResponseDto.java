package org.example.entities.dtos.response;

import lombok.*;
import org.example.entities.Student;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassListingResponseDto {

    private String classId;
    private int quota;
    private List<Student> students;
}
