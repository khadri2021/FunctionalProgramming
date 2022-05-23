package com.khadri.function.programming.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khadri.function.programming.entity.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, String>{

	
}
