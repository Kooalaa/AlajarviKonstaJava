package com.javaproject.javaproject;

import java.util.List;
import java.util.ArrayList;

public abstract class Course {
    private long Id;
    private String courseName;
    private String teacherName;
    private List<Student> studentList = new ArrayList<>();
    private static long IdCounter = 0;

    public Course(String courseName, String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.Id = IdCounter++;
    }
    
    public long getId() {
        return Id;
    }

    public List<Student> getStudentList(){
        return studentList;
    }
    
    public String getCourseName() {
        return courseName;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public abstract boolean addStudentToCourse(Student s, Course c);

    public void removeSudent(Student s){
        studentList.remove(s);
    }
    
    @Override
    public String toString() {
        return String.format(getCourseName());
    }
}
