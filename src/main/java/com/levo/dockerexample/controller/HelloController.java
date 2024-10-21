package com.levo.dockerexample.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Subodh'spipeline {
			agent any
		
			triggers {
				githubPush()
			}
		
			stages {
				stage('Checkout') {
					steps {
						checkout scm
					}
				}
		
				stage('Build') {
					steps {
						sh 'mvn clean package'
					}
				}
		
				stage('Docker Build') {
					steps {
						sh 'docker build -t docker-spring-boot-java-web-service .'
					}
				}
		
				// Add more stages as needed (e.g., Test, Deploy)
			}
		} up and running: " + new Date();
	}

}
