package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class CreateCourseTypeAggregate {
    @AggregateIdentifier
    private String courseTypeId;

    private String courseName;

    private String description;

    private double price;

    @CommandHandler
    public CreateCourseTypeAggregate(CretaeCourseTypeCommand command){
        CourseTypeCreatedEvent courseTypeCreatedEvent=new CourseTypeCreatedEvent();
        BeanUtils.copyProperties(command,courseTypeCreatedEvent);
        AggregateLifecycle.apply(courseTypeCreatedEvent); //tambiliyoruz

    }
    @EventSourcingHandler
    public void on(CourseTypeCreatedEvent courseTypeCreatedEvent){

        this.courseTypeId=courseTypeCreatedEvent.getCourseTypeId();
        this.courseName=courseTypeCreatedEvent.getCourseName();
        this.description=courseTypeCreatedEvent.getDescription();
        this.price=courseTypeCreatedEvent.getPrice();

    }


}
