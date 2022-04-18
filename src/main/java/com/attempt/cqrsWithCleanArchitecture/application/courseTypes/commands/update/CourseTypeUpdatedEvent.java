package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.update;

import lombok.Data;

@Data
public class CourseTypeUpdatedEvent {

    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;
}
