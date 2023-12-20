package com.student.ranking.ranking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.ranking.ranking.model.StudentGrade;
import com.student.ranking.ranking.service.StudentGradeService;

@RestController
public class StudentGradeController {
	@Autowired
	StudentGradeService service;
	
	// List of all students
	@GetMapping("/students")
	public List<StudentGrade> listStudents() {
		return service.findAll();
	}
	
	// List of students by id
	@GetMapping("/students/{id}")
	public StudentGrade listAllStudents(@PathVariable String id) {
		Optional<StudentGrade> grade_Opt = service.findById(id);
		if(grade_Opt.isPresent()) {
			return grade_Opt.get();
			}
		return null;
		}
	//Deleting the student record
	@DeleteMapping("/students/{id}")
	public void deleteStudentById(@PathVariable String id) {
		Optional<StudentGrade> grade_Opt = service.findById(id);
		if(grade_Opt.isPresent()) {
			service.delete(grade_Opt.get());
			}
		}
	
	// Post of all student
	@PostMapping("/students")
	public StudentGrade saveStudents(@RequestBody StudentGrade student_grade) {
		return service.add(student_grade);
	}
	
	// List all students with calculated grades
	@GetMapping("/students/grades")
	public List<StudentGrade> listAllStudentsWithGrades() {
	    // Calculate and update grades for all students
	    List<StudentGrade> allStudentsWithGrades = service.calculateAndUpdateGradesForAll();
	    // Display or return the list of all students with calculated grades
	    return allStudentsWithGrades;
	}

}
