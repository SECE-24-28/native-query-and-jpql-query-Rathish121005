package com.exercise.practice.Response;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentDtoResponse {

    @Id
    private String rollNumber;
    private String name;
    private String department;
    private String gender;
    private String email;
}
