package com.student.ranking.ranking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "StudentGrade")
public class StudentGrade {
		@Id
		private String id;
		private String name;
		private String studentId;
		private Subject subject1;
		private Subject subject2;
		@JsonIgnore
		private String grade;
		
		public void setGrade(String grade) {
			this.grade = grade;
		}
		
		public String getGrade() {
			return grade;
		}
}
