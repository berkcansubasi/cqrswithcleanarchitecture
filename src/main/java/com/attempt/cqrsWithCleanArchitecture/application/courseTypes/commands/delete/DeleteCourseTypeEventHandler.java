package com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.delete;

import com.etiya.cqrsWithCleanArchitecture.persistence.CourseTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteCourseTypeEventHandler {

    private CourseTypeRepository courseTypeRepository;

    public DeleteCourseTypeEventHandler(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }
    @EventHandler
    public void delete(CourseTypeDeletedEvent courseTypeDeletedEvent){
        this.courseTypeRepository.deleteById(courseTypeDeletedEvent.getCourseTypeId());
    }
}
