package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.delete;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteCourseTypeCommand {
    @TargetAggregateIdentifier
    private String courseTypeId;

}
