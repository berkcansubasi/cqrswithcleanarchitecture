package com.etiya.cqrsWithCleanArchitecture.ws.controllers;

import com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create.CreateAccountTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.create.CretaeCourseTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.delete.DeleteCourseTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.application.courseTypes.commands.update.UpdateCourseTypeCommand;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateCourseTypeModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.DeleteCourseTypeModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.UpdateCourseTypeModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/coursetypes")
public class CourseTypeController {
    private CommandGateway commandGateway; //içinde fonsksiyonlar var

    public CourseTypeController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCourseTypeModel createCourseTypeModel){ //model request
        CretaeCourseTypeCommand command=CretaeCourseTypeCommand.builder()
                .courseName(createCourseTypeModel.getCourseName())
                .price(createCourseTypeModel.getPrice())
                .description(createCourseTypeModel.getDescription())
                .build();
        command.setCourseTypeId(UUID.randomUUID().toString());
        this.commandGateway.sendAndWait(command);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateCourseTypeModel updateCourseTypeModel){ //model request
        UpdateCourseTypeCommand command=UpdateCourseTypeCommand.builder()
               .courseTypeId(updateCourseTypeModel.getCourseTypeId())
                .courseName(updateCourseTypeModel.getCourseName())
                .price(updateCourseTypeModel.getPrice())
                .description(updateCourseTypeModel.getDescription())
                .build();
          //  command.setCourseTypeId(updateCourseTypeModel.getCourseTypeId());
        this.commandGateway.sendAndWait(command);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCourseTypeModel deleteCourseTypeModel){ //model request
        DeleteCourseTypeCommand command=DeleteCourseTypeCommand.builder()
                .courseTypeId(deleteCourseTypeModel.getCourseTypeId())
                .build();
        this.commandGateway.sendAndWait(command);
    }


}
