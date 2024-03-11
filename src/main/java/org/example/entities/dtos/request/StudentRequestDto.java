package org.example.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Class;
import org.example.entities.Teacher;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    private String studentName;

    private String studentLastName;

    private int studentNumber;

    private Class classes;

    private Teacher teacher;
}
