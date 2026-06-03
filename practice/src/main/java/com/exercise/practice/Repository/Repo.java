package com.exercise.practice.Repository;

import com.exercise.practice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repo extends JpaRepository<Student,String> {

     List<Student> findByGenderAndDepartment(String gender, String department);
     //List<Student> findByName(String name);
     List<Student> findByDepartment(String department);

     @Query(nativeQuery = true, value="SELECT *FROM student WHERE gender=:gender AND department=:dept")
     List<Student>findByGenAndDept(String gender,String dept);

     @Query("SELECT s FROM Student s Where s.name=:name")
     List<Student>findByName(String name);

}
