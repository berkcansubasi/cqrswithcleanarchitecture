package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.delete;

import lombok.Data;

@Data
public class CourseTypeDeletedEvent {

    private String courseTypeId;

}
