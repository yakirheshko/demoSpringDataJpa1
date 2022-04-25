package com.example.controller;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Value("${app.name:Default Demo App}")
    public String appName;

    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getAllWithPagination")
    public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        List<Student> studentList = studentService.getAllStudentsWithPagination(pageNo,pageSize);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getAllWithSorting")
    public List<StudentResponse> getAllStudentsWithSorting(){
        List<Student> studentList = studentService.getAllStudentsWithSorting();
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstName")
    public List<StudentResponse> getByFirstName(@RequestParam(value = "first_name") String firstName){
        List<Student> studentList = studentService.getByFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstNameAndLastName")
    public List<StudentResponse> getByFirstNameAndLastName(@RequestParam(value = "first_name") String firstName, @RequestParam String lastName){
        List<Student> studentList = studentService.getByFirstNameAndLastName(firstName, lastName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstNameOrLastName")
    public List<StudentResponse> getByFirstNameOrLastName(@RequestParam(value = "first_name") String firstName, @RequestParam String lastName){
        List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("getByFirstNameIn")
    public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest){
        List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("likeFirstName")
    public List<StudentResponse> likeFirstName(@RequestParam String firstName){
        List<Student> studentList = studentService.likeFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @GetMapping("startsWithFirstName")
    public List<StudentResponse> startsWithFirstName(@RequestParam String firstName){
        List<Student> studentList = studentService.startsWithFirstName(firstName);
        List<StudentResponse> studentResponseList = new ArrayList<>();

        studentList.stream().forEach(student -> studentResponseList.add(new StudentResponse(student)));
        return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("updateStudentFirstNameByLastNameJPQL")
    public Integer updateStudentFirstNameByLastNameJPQL(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        return studentService.updateStudentFirstNameByLastNameJPQL(updateStudentRequest);
    }

    @DeleteMapping("delete")
    public String deleteStudent(@RequestParam long id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("deleteStudentByLastNameJPQL")
    public Integer deleteStudentByLastNameJPQL(@RequestParam String lastName){
        return studentService.deleteStudentByLastNameJPQL(lastName);
    }

/*    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }*/


}

