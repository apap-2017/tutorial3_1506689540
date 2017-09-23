package com.example.tutorial3.service;

import com.example.tutorial3.model.StudentModel;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;


public class InMemoryStudentService implements StudentService {
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();

	@Override
	public StudentModel selectStudent(String npm) {
		for (int i = 0, n = studentList.size(); i < n; i++) {
			if (studentList.get(i).getNpm().equals(npm)){
				return studentList.get(i);
			}
		}
		return null;
	}
	public List<StudentModel> selectAllStudents(){
		return studentList;
	}

	public void addStudent(StudentModel student){
		studentList.add(student);
	}
}