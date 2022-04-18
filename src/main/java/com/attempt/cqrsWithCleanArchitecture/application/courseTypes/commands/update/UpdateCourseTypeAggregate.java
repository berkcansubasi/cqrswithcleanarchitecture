package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.update;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UpdateCourseTypeAggregate {
    @AggregateIdentifier
    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;

    @CommandHandler
    public UpdateCourseTypeAggregate(UpdateCourseTypeCommand command){
        CourseTypeUpdatedEvent courseTypeUpdatedEvent=new CourseTypeUpdatedEvent();
        BeanUtils.copyProperties(command,courseTypeUpdatedEvent);
        AggregateLifecycle.apply(courseTypeUpdatedEvent); //tambiliyoruz

    }
//    @EventSourcingHandler
//    public void on(CourseTypeUpdatedEvent courseTypeUpdatedEvent){
//
//        this.courseTypeId=courseTypeUpdatedEvent.getCourseTypeId();
//        this.courseName=courseTypeUpdatedEvent.getCourseName();
//        this.description=courseTypeUpdatedEvent.getDescription();
//        this.price=courseTypeUpdatedEvent.getPrice();
//
//    }


}
