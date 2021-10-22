package com.javaproject.javaproject;

public class OnlineCourse extends Course{

    private String courseAddress;


    public OnlineCourse(String courseName, String teacherName, String courseAddress) {
        super(courseName, teacherName);
        this.courseAddress=courseAddress;
    }

    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }


    @Override
    public boolean addStudentToCourse(Student s, Course c) {
        c.getStudentList().add(s);
        return true;
    }
    
    @Override
    public String toString() {
        return String.format(getCourseName());
    }
}
