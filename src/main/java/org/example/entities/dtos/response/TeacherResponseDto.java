package org.example.entities.dtos.response;

import lombok.*;
import org.example.entities.Class;
import org.example.entities.Teacher;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponseDto {

    private String teacherId;

    private String teacherName;

    private String teacherLastName;

    private String branch;

}
