package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.create;

import lombok.Data;

import javax.persistence.Column;
@Data
public class CourseTypeCreatedEvent {

    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;
}
