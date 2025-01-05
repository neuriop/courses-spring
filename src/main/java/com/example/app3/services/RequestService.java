package com.example.app3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RequestService {
    @Autowired private RestTemplate restTemplate;

    public void sendNewCourse(int courseid){
        String url = "http://localhost:8084/notifications/advertise/all?courseid=" + courseid;
        restTemplate.put(url, courseid);
    }
}
