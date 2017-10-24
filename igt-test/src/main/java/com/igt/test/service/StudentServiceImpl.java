package com.igt.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.igt.test.pojo.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier(value="mongoOperations")
	MongoOperations mongoOperation;
	
	@Override
	public List<Student> list() throws Exception{
		Query searchUserQuery = new Query();		
		List<Student> col = mongoOperation.find(searchUserQuery, Student.class);
        return col;
	}

	@Override
	public void addData(Student data) throws Exception {
		data.setStatus("Completed");
		mongoOperation.save(data);		
	}

	@Override
	public void deleteData(String studentNo) throws Exception {
		Query query = new Query(Criteria.where("studentNo").is(studentNo));
		mongoOperation.remove(query, Student.class);
	}

}
