package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.create;

import com.etiya.cqrsWithCleanArchitecture.domain.CourseType;
import com.etiya.cqrsWithCleanArchitecture.persistence.CourseTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseTypeEventHandler {

    private CourseTypeRepository courseTypeRepository;

    public CreateCourseTypeEventHandler(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }
    @EventHandler
    public void on(CourseTypeCreatedEvent courseTypeCreatedEvent){

        checkCourseName(courseTypeCreatedEvent.getCourseName());
        CourseType courseType=new CourseType();
        BeanUtils.copyProperties(courseTypeCreatedEvent,courseType);
        this.courseTypeRepository.save(courseType);
    }

    public void checkCourseName(String name){
        if(this.courseTypeRepository.existsCourseTypeByCourseName(name)){
            throw new RuntimeException("Aynı isim olamaz");
        }
    }
}
