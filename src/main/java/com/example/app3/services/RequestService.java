package com.example.app3.services;

import com.example.app3.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RequestService {
    @Autowired private RestTemplate restTemplate;

    public void sendNewCourse(int courseid){
        String url = "http://localhost:8084/notifications/advertise/all?courseid=" + courseid;
        restTemplate.put(url, courseid);
    }

    public void saveCourses(List<Course> courses){
        String url = "http://localhost:8085/courses/save";
        restTemplate.put(url, courses);
    }

    public List<Course> getCourses(){
        String url = "http://localhost:8085/courses/get";
        ParameterizedTypeReference<List<Course>> responseType = new ParameterizedTypeReference<List<Course>>() {};
        ResponseEntity<List<Course>> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
        return response.getBody();
    }
}
