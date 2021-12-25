package com.covoid21.panman.database.controller;

import com.covoid21.panman.entity.user.Instructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users", params = "user_type=instructor")
public class InstructorController extends UserControllerBase<Instructor> {

}
