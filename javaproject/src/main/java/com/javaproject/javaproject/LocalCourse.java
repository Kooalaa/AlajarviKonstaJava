package com.javaproject.javaproject;


public class LocalCourse extends Course{
    private String classRoom;
    

    public LocalCourse(String courseName, String teacherName, String classRoom) {
        super(courseName, teacherName);
        this.classRoom=classRoom;
    }
    
    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public boolean addStudentToCourse(Student s, Course c) {
        if (c.getStudentList().size() >= 25) {
            return false;
        }
        c.getStudentList().add(s);
        return true;
    }

    @Override
    public String toString() {
        return String.format(getCourseName());
    }
}
