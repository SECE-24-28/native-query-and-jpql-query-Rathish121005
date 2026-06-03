package com.exercise.practice.Controller;


import com.exercise.practice.Dto.StudentDto;
import com.exercise.practice.Model.Student;
import com.exercise.practice.Response.StudentDtoResponse;
import com.exercise.practice.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<StudentDtoResponse> getAllStudents()
    {
        return studentService.getAllStudents();
    }



    @PostMapping("/students/add")
    public String addStudent(@Valid @RequestBody Student student)
    {

        return studentService.addStudents(student);
    }

    @GetMapping("students/{rollNumber}")
    public Student getStudent(@Valid @PathVariable String rollNumber)
    {
        return studentService.getStudent(rollNumber);
    }

    @PutMapping("students/update")
    public String updateStudent(@Valid @RequestBody Student student){
        studentService.updateStudent(student);
        return student.getRollNumber()+" Updated Successfully";
    }

    @DeleteMapping("students/delete/{rollNumber}")
    public String deleteStudent(@Valid @PathVariable String rollNumber)
    {
        studentService.deleteStudent(rollNumber);
        return rollNumber+" Deleted Successfully";
    }

    @DeleteMapping("students/deleteAll")
    public String deleteAllStudent()
    {
        studentService.deleteAll();
        return "All Students Deleted";
    }

    @GetMapping("students/genderAndDept")
    public List<Student>getStudentByGenderAndDept(@Valid @Param("gender") String gender,
                                                  @Valid @Param("department") String department)
    {
        return studentService.getStudentByGenderAndDepartment(gender,department);
    }

    @GetMapping("students/name")
    public List<Student>getStudentByName(@Valid @Param("name") String name)
    {
        return studentService.getByName(name);
    }

    @GetMapping("students/department/{department}")
    public List<Student>getStudentByDepartment(@Valid @PathVariable("department") String department)
    {
        return studentService.getByDepartment(department);
    }

    //Native Query
    @PostMapping("students/filter")
    public List<Student> getStudentByGenderAndDepartmentByQuery(@Valid @Param("gender") String gender,
                                                                 @Valid @Param("department") String department){
        return studentService.getStudentWithGenAndDept(gender,department);
    }

    //jpl
    @GetMapping("students/Name/{name}")
    public List<Student>getByName(@Valid @PathVariable("name") String name)
    {
        return studentService.getByStuName(name);
    }

    @GetMapping("students/List")
    public Page<Student>getStudentPage(@RequestParam("page") int page,
                                       @RequestParam("size") int size)
    {
        return studentService.getStudentPage(page,size);
    }





//    @GetMapping("students/{rollNumber}")
//    public Student getByRollNumber(@PathVariable("rollNumber") String rollNumber)
//    {
//        return studentService.getStudentByRollNumber(rollNumber);
//    }
//
//    @PostMapping("students/add")
//    public String addStudent(@RequestBody Student student)
//    {
//        studentService.addStudents(student);
//        return "Student Added";
//    }
//
//    @PutMapping("students/update")
//    public String updateStudent(@RequestBody Student student)
//    {
//        return studentService.updateStudent(student);
//
//    }
//
//    @DeleteMapping("students/delete/{rollNumber}")
//    public String deleteStudent(@PathVariable("rollNumber") String rollNumber)
//    {
//        return studentService.deleteStudent(rollNumber);
//    }

}
