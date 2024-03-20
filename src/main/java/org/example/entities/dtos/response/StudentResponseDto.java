package org.example.entities.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Class;
import org.example.entities.Teacher;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private String studentId;

    private String studentName;

    private String studentLastName;

    private int studentNumber;

    private String classId;

    private String teacherId;
}
