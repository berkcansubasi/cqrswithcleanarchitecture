package com.etiya.cqrsWithCleanArchitecture.ws.models;

import lombok.Data;

@Data
public class CreateCourseTypeModel {

    private String courseName;

    private String description;

    private double price;
}
