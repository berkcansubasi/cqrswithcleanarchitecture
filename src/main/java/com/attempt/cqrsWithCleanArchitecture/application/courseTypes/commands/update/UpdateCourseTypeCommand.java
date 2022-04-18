package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.update;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateCourseTypeCommand {
    @TargetAggregateIdentifier
    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;

}
