package com.etiya.cqrsWithCleanArchitecture.ws.models;

import lombok.Data;

@Data
public class UpdateCourseTypeModel {
    private String id;

    private String courseName;

    private String description;

    private double price;
}
