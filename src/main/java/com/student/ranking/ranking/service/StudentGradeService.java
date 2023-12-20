package com.student.ranking.ranking.service;

import java.util.List;
import java.util.Optional;

import com.student.ranking.ranking.model.StudentGrade;


public interface StudentGradeService {
	// adding the list of students
		StudentGrade add(StudentGrade student_grade);
		
		// update the students
		StudentGrade update(StudentGrade student_grade);
		
		// deleting the records of the students
		void delete(StudentGrade student_grade);
		
		Optional<StudentGrade> findById(String id);

		List<StudentGrade> findAll();
		
		List<StudentGrade> calculateAndUpdateGradesForAll();

}
