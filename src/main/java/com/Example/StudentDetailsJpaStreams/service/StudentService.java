package com.Example.StudentDetailsJpaStreams.service;


import com.Example.StudentDetailsJpaStreams.entity.InstituteEntity;
import com.Example.StudentDetailsJpaStreams.entity.StudentDetails;
import com.Example.StudentDetailsJpaStreams.entity.StudentDetails$;
import com.Example.StudentDetailsJpaStreams.repository.InstituteRepository;
import com.Example.StudentDetailsJpaStreams.repository.StudentRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private JPAStreamer jpaStreamer;

    public List<StudentDetails> addStudent(List<StudentDetails> student)
    {
        return studentRepository.saveAll(student);
    }


    public Long getStudentCountForCourses(String course) {
            return jpaStreamer.stream(StudentDetails.class)
                .flatMap(student -> student.getInterestedCourse().stream())
                .filter(courses -> course.contains(courses))
                .distinct()
                .count();
    }

    public List<StudentDetails> getAllByAddress(String addresses) {
        return jpaStreamer.stream(StudentDetails.class)
                .sorted(StudentDetails$.id)
                .filter(StudentDetails$.address.equal(addresses))
                .collect(Collectors.toList());

    }

    public List<StudentDetails> getAllStudent() {
        return studentRepository.findAll();
    }

    public List<StudentDetails> getStudentsByInstituteId(@RequestParam int instituteId) {
        return studentRepository.findByInstituteId(instituteId);
    }

    public InstituteEntity addInstitute(InstituteEntity institute) {
        return instituteRepository.save(institute);
    }

//    public StudentDetails saveStudentInfo( int instituteId) {
//        InstituteEntity institute = instituteRepository.findById(instituteId)
//                .orElseThrow(() -> new EntityNotFoundException("Institute not found with id: " + instituteId));
////        StudentInfo.getInstitute(institute);
////        return studentRepository.save(studentInfo);
//    }

}


