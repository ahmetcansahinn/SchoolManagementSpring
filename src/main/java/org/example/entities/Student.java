package org.example.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "students")
public class Student {

    @Id
    private String studentId;

    private String studentName;

    private String studentLastName;

    private int studentNumber;


}
