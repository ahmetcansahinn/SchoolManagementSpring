package org.example.entities.dtos.request;

import lombok.*;
import org.example.entities.Student;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassListingRequestDto {

    private int quota;
    private List<Student> students;
}
