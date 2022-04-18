package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CretaeCourseTypeCommand {
    @TargetAggregateIdentifier
    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;

}
