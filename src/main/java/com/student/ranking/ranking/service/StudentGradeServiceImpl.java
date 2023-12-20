package com.student.ranking.ranking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.ranking.ranking.model.StudentGrade;
import com.student.ranking.ranking.model.Subject;
import com.student.ranking.ranking.repository.StudentGradeRepository;

@Service
public class StudentGradeServiceImpl implements StudentGradeService {
	
	@Autowired
	StudentGradeRepository repo;

	@Override
	public StudentGrade add(StudentGrade student_grade) {
		return repo.save(student_grade);
	}

	@Override
	public StudentGrade update(StudentGrade student_grade) {
		return repo.save(student_grade);
	}

	@Override
	public void delete(StudentGrade student_grade) {
		repo.delete(student_grade);
	}

	@Override
	public Optional<StudentGrade> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public List<StudentGrade> findAll() {
		return repo.findAll();
	}

	@Override
	public List<StudentGrade> calculateAndUpdateGradesForAll() {
	    List<StudentGrade> allStudents = repo.findAll();
	    
	    for(StudentGrade studentGrade : allStudents) {
	    	Subject subject1 = studentGrade.getSubject1();
	        Subject subject2 = studentGrade.getSubject2();
	        // Calculate total marks
	        int totalMarks = subject1.getMarks() + subject2.getMarks();

	        // Calculate and return the grade based on total marks
	        studentGrade.setGrade(calculateGrade(totalMarks));
	         
	         repo.save(studentGrade);
	    }
	    return allStudents;
	}

	private String calculateGrade(int totalMarks) {
	    if (totalMarks > 190) {
	        return "A+";
	    } else if (totalMarks >= 170) {
	        return "A-";
	    } else if (totalMarks >= 150) {
	        return "B+";
	    } else if (totalMarks >= 130) {
	        return "B-";
	    } else if (totalMarks >= 100) {
	        return "C";
	    } else if (totalMarks >= 80) {
	        return "D";
	    } else {
	        return "F";
	    }
	}
}
