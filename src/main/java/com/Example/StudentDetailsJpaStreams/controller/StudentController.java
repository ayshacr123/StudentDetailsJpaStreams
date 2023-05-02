package com.Example.StudentDetailsJpaStreams.controller;


import com.Example.StudentDetailsJpaStreams.entity.InstituteEntity;
import com.Example.StudentDetailsJpaStreams.entity.StudentDetails;
import com.Example.StudentDetailsJpaStreams.entity.StudentDetails$;
import com.Example.StudentDetailsJpaStreams.service.StudentService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/add")
    public List<StudentDetails> addStudent(@RequestBody List<StudentDetails> student)
    {
        return service.addStudent(student);
    }

    @GetMapping("/students/{course}")
    public Long getStudentCountForCourses(@PathVariable String course)
    {
        return service.getStudentCountForCourses(course);
    }

    @GetMapping("/addr/{addresses}")
    public List<StudentDetails> getAllByAddress(@PathVariable String addresses)
    {
        return service.getAllByAddress(addresses);
    }

    @GetMapping("/students")
    public List<StudentDetails> getAllStudent()
    {
        return service.getAllStudent();
    }

    @GetMapping("/getstudent/{instituteId}")
    public List<StudentDetails> getStudentsByInstituteId(@RequestParam int instituteId) {
        return service.getStudentsByInstituteId(instituteId);
    }
//    public StudentDetails saveStudentInfo( @PathVariable int instituteId)
//    {
//        return service.saveStudentInfo(instituteId);
//    }
    @PostMapping("/institute")
    public InstituteEntity addInstitute(@RequestBody InstituteEntity institute)
    {
        return service.addInstitute(institute);
    }









}
