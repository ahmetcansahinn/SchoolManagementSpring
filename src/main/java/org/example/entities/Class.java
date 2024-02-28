package org.example.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "classes")
@Builder
public class Class {
    @Id
    private String classId;

    private int quota;

    @DBRef
    private List<String> studentId;

}
