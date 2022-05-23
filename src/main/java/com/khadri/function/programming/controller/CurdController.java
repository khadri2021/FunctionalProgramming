package com.khadri.function.programming.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
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

	@GetMapping(value = "student/names")
	public ResponseEntity<List<String>> getStudentDetails() {

		List<Student> listStudents = curdService.getStudentAll();

		// Predicate used for address condition
		Predicate<Student> predicate = (std) -> std.getAddress().equals("KADIRI");

		// Function used for to map the name of the students
		Function<Student, String> function = (std) -> std.getName();

		// Passing predicate to filter and Passing function to map
		List<String> listNames = listStudents.stream().filter(predicate).map(function).collect(Collectors.toList());

		return ResponseEntity.ok(listNames);
	}

	@GetMapping(value = "student/change/names")
	public ResponseEntity<List<Student>> getModifiedStudents() {

		List<Student> listStudents = curdService.getStudentAll();

		// Predicate used for condition check for student name
		Predicate<Student> predicate = (std) -> std.getName().equalsIgnoreCase("Max");

		// Function used for change the name of student which you filter before
		Function<Student, Student> function = (std) -> {

			std.setName("ALLEN");

			return std;
		};

		List<Student> modifiedStudents = listStudents.stream().filter(predicate).map(function)
				.collect(Collectors.toList());

		return ResponseEntity.ok(modifiedStudents);
	}

	@GetMapping(value = "student/map")
	public ResponseEntity<Map<String, String>> getDetailsAsMap() {

		List<Student> listStudents = curdService.getStudentAll();

		// Collecting student uuid and name as map
		Map<String, String> mapDetails = listStudents.stream()
				.collect(Collectors.toMap(Student::getUuid, Student::getName));

		return ResponseEntity.ok(mapDetails);
	}

	@GetMapping(value = "student/findone")
	public ResponseEntity<Student> findFirstStram() {

		List<Student> listStudents = curdService.getStudentAll();
		// Predicate used for condition check name and get the first record in the
		// stream
		Predicate<Student> predicate = (std) -> std.getName().equalsIgnoreCase("Harshini");

		Optional<Student> student = listStudents.stream().filter(predicate).findFirst();

		return ResponseEntity.ok(student.get());
	}

	@GetMapping(value = "student/count")
	public ResponseEntity<String> findStudentsCount() {

		List<Student> listStudents = curdService.getStudentAll();

		// used count() method to return the no of student records
		long countOfStudents = listStudents.stream().count();

		String message = "The No of Student Records " + countOfStudents;

		return ResponseEntity.ok(message);
	}

	@GetMapping(value = "student/dsc/order")
	public ResponseEntity<List<Student>> findStudentsDsc() {

		List<Student> listStudents = curdService.getStudentAll();

		// The comparator used for descending order based on student name
		Comparator<Student> comparator = (std1, std2) -> {

			return -std1.getName().compareTo(std2.getName());
		};

		List<Student> listSortedStudents = listStudents.stream().sorted(comparator).collect(Collectors.toList());

		return ResponseEntity.ok(listSortedStudents);
	}

}
