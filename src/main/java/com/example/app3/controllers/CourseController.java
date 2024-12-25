package com.example.app3.controllers;

import com.example.app3.models.Course;
import com.example.app3.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String getAll(){
        return courseService.getAllCourses();
    }

    @PostMapping(value = "/new")
    public String newCourse(@RequestBody Course course){
        courseService.newCourse(course);
        return "true";
    }

    @GetMapping(value = "/getbyid")
    public String getCourseById(@RequestParam int id){
        return courseService.getCourseById(id);
    }

    @PutMapping(value = "/update")
    public String updateCourseById(@RequestBody Course course){
        return String.valueOf(courseService.updateCourseById(course));
    }

    @DeleteMapping(value = "/delete")
    public String deleteCourseById(@RequestParam int id){
        return String.valueOf(courseService.deleteCourseById(id));
    }
}
