package com.example.app3.services;

import com.example.app3.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();
    @Autowired private RequestService requestService;

    // List.of(new Course(1, "Java", "Java desc"), new Course(2, "PHP", "PHP desc"), new Course(3,"Go", "Go desc"))
    public List<Course> getAllCourses() {
        return courses;
    }

    public void newCourse(Course course) {
            courses.add(course);
            requestService.sendNewCourse(course.getId());
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (id == course.getId()) {
                return course;
            }
        }
        return null;
    }

    public boolean updateCourseById(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (course.getId() == courses.get(i).getId()) {
                courses.set(i, course);
                return true;
            } else {
                newCourse(course);
                return true;
            }
        }
        return false;
    }


    public boolean deleteCourseById(int id) {
        for (Course course : courses) {
            if (id == course.getId()) {
                courses.remove(course);
                return true;
            }
        }
        return false;
    }
}
