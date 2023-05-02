package com.Example.StudentDetailsJpaStreams.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String StuId;
    private String name;
    private String email;
    private String phone;
    private String qualification;
    @ElementCollection
    private List<String> interestedCourse;
    private String address;
    private String comment;
    private int instituteId;
}
