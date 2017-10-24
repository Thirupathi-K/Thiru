package com.igt.test.service;

import java.util.List;

import com.igt.test.pojo.Student;

public interface StudentService {

	List<Student> list() throws Exception;
	
	void addData(Student data) throws Exception;
	
	void deleteData(String id) throws Exception;
}
