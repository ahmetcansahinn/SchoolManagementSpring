package org.example.entities.dtos.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassResponseDto {

    private String classId;
    private int quota;
    private List<String> studentId;
}
