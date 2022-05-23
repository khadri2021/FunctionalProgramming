package com.khadri.function.programming.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khadri.function.programming.entity.Student;
import com.khadri.function.programming.service.CurdService;

@RestController("/")
public class CurdController {

	@Autowired
	CurdService curdService;

	@GetMapping(value = "studentinfo")
	public ResponseEntity<List<String>> getStudentDetails() {

		List<Student> listStudents = curdService.getStudentAll();
		
		Function<Student, String> function = (std) -> std.getName();

		List<String> listNames = listStudents.stream().filter((std) -> std.getAddress().equals("KADIRI"))
				.map(function).collect(Collectors.toList());

		return ResponseEntity.ok(listNames);
	}

}
