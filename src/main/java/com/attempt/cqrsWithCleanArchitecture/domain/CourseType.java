package com.etiya.cqrsWithCleanArchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "courseTypes")
@AllArgsConstructor
@NoArgsConstructor
public class CourseType {
    @Id
    @Column(name = "id")
    private String courseTypeId;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;

}
