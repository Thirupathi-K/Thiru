package com.igt.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igt.test.pojo.Student;
import com.igt.test.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService stdService;

	@RequestMapping(value = "/list", method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Student> getData() {
		try {
			List<Student> data = stdService.list();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE})
	public String addStudent(@RequestBody Student data) {
		try{
			stdService.addData(data);	
			return "completed";
		} catch (Exception e) {
			e.printStackTrace();
			return "Pending";
		} 
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE})
	public String delete(@RequestBody Student data) {
		try{
			stdService.deleteData(data.getStudentNo());
			return "completed";
		} catch (Exception e) {
			e.printStackTrace();
			return "Pending";
		}
	}

}
