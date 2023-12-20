package com.student.ranking.ranking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.ranking.ranking.model.StudentGrade;

public interface StudentGradeRepository extends MongoRepository<StudentGrade, String> {
	Optional<StudentGrade> findByStudentId(String studentId);
}
