package com.example.app3.controllers;

import com.example.app3.models.Course;
import com.example.app3.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping(value = "/new")
    public String newCourse(@RequestBody Course course){
        courseService.newCourse(course);
        return "true";
    }

    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id){
        return ResponseEntity.ok(courseService.getCourseById(id));
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
