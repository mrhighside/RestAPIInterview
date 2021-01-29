package com.interview.api.controllers;

import java.util.LinkedList;
import java.util.List;

import com.interview.api.services.WebHealthCheckerService;
import com.interview.api.model.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class WebHealthCheckerController {

    @RequestMapping ("/google-status")
    public HealthResponse GoogleHealthCheck()
    {
        return WebHealthCheckerService.urlHealthCheck("https://www.google.com");
    }

    @RequestMapping ("/amazon-status")
    public HealthResponse AmazonHealthCheck()
    {
        return WebHealthCheckerService.urlHealthCheck("https://www.amazon.com");
    }

    @RequestMapping ("/all-status")
    public List<HealthResponse> AllHealthCheck()
    {
        List<HealthResponse> allResponses = new LinkedList<HealthResponse>();
        
        allResponses.add(WebHealthCheckerService.urlHealthCheck("https://www.amazon.com"));
        allResponses.add(WebHealthCheckerService.urlHealthCheck("https://www.google.com"));
        return allResponses;
    }
}
