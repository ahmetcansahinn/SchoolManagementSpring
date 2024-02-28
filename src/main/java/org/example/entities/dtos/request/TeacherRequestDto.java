package org.example.entities.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entities.Class;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDto {

    private String teacherName;

    private String teacherLastName;

    private String branch;

    private List<Class> classes;
}
