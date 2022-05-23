package com.khadri.function.programming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.function.programming.dao.StudentRepository;
import com.khadri.function.programming.entity.Student;

@Service
public class CurdService {
	
	@Autowired
	StudentRepository  studentRepository;
	
	
	public List<Student> getStudentAll(){
		List<Student> list = new ArrayList<>();
		Iterable<Student> iterator = studentRepository.findAll();
		
		iterator.forEach((std)->{
			list.add(std);
		});	
		
		return list;
	}
	

}
