package com.exercise.practice.Service;


import com.exercise.practice.Dto.StudentDto;
import com.exercise.practice.Model.Student;
import com.exercise.practice.Repository.Repo;
import com.exercise.practice.Response.StudentDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    Repo repo;

    public List<StudentDtoResponse> getAllStudents()
    {
        List<Student> students = repo.findAll();

        List<StudentDtoResponse> responseList = new ArrayList<>();

        for(Student student : students) {

            StudentDtoResponse dto = new StudentDtoResponse();

            dto.setRollNumber(student.getRollNumber());
            dto.setName(student.getName());
            dto.setDepartment(student.getDepartment());
            dto.setGender(student.getGender());
            dto.setEmail(student.getEmail());

            responseList.add(dto);
        }

        return responseList;
    }

    public String addStudents(Student student)
    {
        repo.save(student);
        return student.getRollNumber()+" Added Successfully";
    }

    public Student getStudent(String rollNumber)
    {
        return repo.findById(rollNumber).orElse(new Student());
    }

    public void updateStudent(Student student)
    {
        Student std=repo.findById(student.getRollNumber()).orElse(new Student());
        std.setName(student.getName());
        std.setDepartment(student.getDepartment());
        std.setGender(student.getGender());
        repo.save(std);
    }

    public void deleteStudent(String rollNumber)
    {
        repo.deleteById(rollNumber);
    }

    public void deleteAll()
    {
        repo.deleteAll();
    }

    public List<Student> getStudentByGenderAndDepartment(String gender,String department)
    {
        return repo.findByGenderAndDepartment(gender,department);
    }

    public List<Student> getByName(String name)
    {
        return repo.findByName(name);
    }

    public List<Student>getByDepartment(String department) {
        return repo.findByDepartment(department);

    }
    public List<Student> getStudentWithGenAndDept(String gender,String dept) {
        return repo.findByGenAndDept(gender,dept);
    }

    public List<Student>getByStuName(String name)
    {
        return repo.findByName(name);
    }

    public Page<Student> getStudentPage(int page, int size) {
        return repo.findAll(
                PageRequest.of(page,size)
        );

    }


//    public Student getStudentByRollNumber(String rollNumber)
//    {
//        int index=0;
//        boolean flag=false;
//        for(int i=0;i<studentList.size();i++)
//        {
//            if(studentList.get(i).getRollNumber().equalsIgnoreCase(rollNumber))
//            {
//                index=i;
//                flag=true;
//            }
//        }
//        if(!flag)
//        {
//            return new Student(null,null,null);
//        }
//        return studentList.get(index);
//    }
//
//    public void addStudents(Student student)
//    {
//        studentList.add(student);
//    }
//
//    public String updateStudent(Student student) {
//        int index = 0;
//        boolean flag = false;
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentList.get(i).getRollNumber().equalsIgnoreCase(student.getRollNumber())) {
//                index = i;
//                flag = true;
//
//            }
//        }
//
//        if (!flag) {
//            return "No Student found with " + student.getRollNumber();
//        } else {
//            studentList.set(index, student);
//            return "Successfully added";
//        }
//    }
//
//    public String deleteStudent(String rollNumber)
//    {
//        int index=0;
//        boolean flag=false;
//        for(int i=0;i<studentList.size();i++)
//        {
//            if(studentList.get(i).getRollNumber().equalsIgnoreCase(rollNumber))
//            {
//                index=i;
//                flag=true;
//            }
//        }
//        if(!flag){
//            return "Roll Number not found with "+rollNumber;
//        }
//        else {
//            studentList.remove(index);
//            return rollNumber+" Deleted Successfully";
//        }
//    }
}

