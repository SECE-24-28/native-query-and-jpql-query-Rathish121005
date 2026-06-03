package com.exercise.practice.Dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentDto {

       @Id
       private String rollNumber;
       private String name;
       private String department;
       private String gender;
       private String email;
       private String password;
}
