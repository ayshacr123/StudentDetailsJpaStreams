package com.Example.StudentDetailsJpaStreams.repository;

import com.Example.StudentDetailsJpaStreams.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
    List<StudentDetails> findByInstituteId(int instituteId);
}
