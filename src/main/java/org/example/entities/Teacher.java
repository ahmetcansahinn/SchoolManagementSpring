package org.example.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "teachers")
public class Teacher {

    @Id
    private String teacherId;

    private String teacherName;

    private String teacherLastName;

    private String branch;

}
