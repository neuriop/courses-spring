package com.example.app3.services;

import com.example.app3.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();
    @Autowired
    private RequestService requestService;

    private void fetchCourses() {
        List<Course> courses1;
        if ((courses1 = requestService.getCourses()) != null) {
            courses = courses1;
        }
    }

    private void saveCourses() {
        requestService.saveCourses(courses);
    }


    public List<Course> getAllCourses() {
        return courses;
    }

    public void newCourse(Course course) {
        fetchCourses();
        course.setId(courses.size());
        courses.add(course);
        saveCourses();
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
        fetchCourses();
        for (int i = 0; i < courses.size(); i++) {
            if (course.getId() == courses.get(i).getId()) {
                courses.set(i, course);
                saveCourses();
                return true;
            } else {
                newCourse(course);
                saveCourses();
                return true;
            }
        }
        saveCourses();
        return false;
    }


    public boolean deleteCourseById(int id) {
        fetchCourses();
        for (Course course : courses) {
            if (id == course.getId()) {
                courses.remove(course);
                saveCourses();
                return true;
            }
        }
        saveCourses();
        return false;
    }
}
