package com.Example.StudentDetailsJpaStreams.repository;

import com.Example.StudentDetailsJpaStreams.entity.InstituteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<InstituteEntity, Integer> {
}
