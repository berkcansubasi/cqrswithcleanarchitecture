package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.update;

import com.etiya.cqrsWithCleanArchitecture.domain.CourseType;
import com.etiya.cqrsWithCleanArchitecture.persistence.CourseTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UpdateCourseTypeEventHandler {

    private CourseTypeRepository courseTypeRepository;

    public UpdateCourseTypeEventHandler(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }
    @EventHandler
    public void on(CourseTypeUpdatedEvent courseTypeDeletedEvent){
        checkIfExistCourseId(courseTypeDeletedEvent.getCourseTypeId());
        CourseType courseType=new CourseType();
        BeanUtils.copyProperties(courseTypeDeletedEvent,courseType);
        this.courseTypeRepository.save(courseType);
    }
    public void checkIfExistCourseId(String id){
        if(!this.courseTypeRepository.existsByCourseTypeId(id)){
            throw new RuntimeException("Böyle bir id yok");
        }
    }
    }

