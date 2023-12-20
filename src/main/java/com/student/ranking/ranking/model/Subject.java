package com.student.ranking.ranking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document
public class Subject {
	@Id
	private String sub_id;
    private String subName;
    private int marks;
}
