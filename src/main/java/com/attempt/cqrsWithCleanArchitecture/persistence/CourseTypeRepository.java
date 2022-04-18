package com.etiya.cqrsWithCleanArchitecture.persistence;

import com.etiya.cqrsWithCleanArchitecture.domain.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseTypeRepository extends JpaRepository<CourseType,String> {
    boolean existsCourseTypeByCourseName(String courseTypeName);
    boolean existsByCourseTypeId(String id);
}
