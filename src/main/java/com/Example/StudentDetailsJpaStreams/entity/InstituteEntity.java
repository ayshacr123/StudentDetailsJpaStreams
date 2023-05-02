package com.Example.StudentDetailsJpaStreams.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstituteEntity {
    @Id
    private int instituteId;
    private String name;
    private String location;
    @ElementCollection
    @CollectionTable(name = "course_price",
            joinColumns = @JoinColumn(name = "institute_id"))
    @MapKeyColumn(name = "course")
    @Column(name = "price")
    private Map<String, Double> listOfCoursesWithPrices;
}
