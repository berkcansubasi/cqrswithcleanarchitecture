package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.delete;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;

@Aggregate
public class DeleteCourseTypeAggregate {
    @AggregateIdentifier
    private String courseTypeId;

    protected DeleteCourseTypeAggregate(){

    }

    @CommandHandler
    public DeleteCourseTypeAggregate(DeleteCourseTypeCommand command){
        CourseTypeDeletedEvent courseTypeDeletedEvent=new CourseTypeDeletedEvent();
        BeanUtils.copyProperties(command,courseTypeDeletedEvent);
        AggregateLifecycle.apply(courseTypeDeletedEvent); //tambiliyoruz

    }
    //@EventSourcingHandler
//    public void on(CourseTypeDeletedEvent courseTypeDeletedEvent){
//
//        this.courseTypeId=courseTypeDeletedEvent.getCourseTypeId();
//
//
//    }


}
