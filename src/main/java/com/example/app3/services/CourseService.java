package com.example.app3.services;

import com.example.app3.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();
// List.of(new Course(1, "Java", "Java desc"), new Course(2, "PHP", "PHP desc"), new Course(3,"Go", "Go desc"))
    public String getAllCourses(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Course cours : courses) {
           stringBuilder.append(cours.toString()) ;
        }
        return stringBuilder.toString();
    }

    public void newCourse(Course course){
        try {
            courses.add(course);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCourseById(int id){
        for (Course course : courses) {
            if (id == course.getId()){
                return course.toString();
            }
        }
        return "";
    }

    public boolean updateCourseById(Course course){
        for (int i = 0; i < courses.size(); i++) {
            if(course.getId() == courses.get(i).getId()){
                courses.set(i, course);
                return true;
            } else {
                newCourse(course);
                return true;
            }
        }
        return false;
    }


    public boolean deleteCourseById(int id){
        for (Course course : courses) {
            if (id == course.getId()){
                courses.remove(course);
                return true;
            }
        }
        return false;
    }
}
