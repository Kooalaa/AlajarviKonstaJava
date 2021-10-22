package com.javaproject.javaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyCourseService implements CourseController{
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    File studentFile = new File("students.txt");
    File courseFile = new File("courses.txt");

    @Autowired
    MyCourseFileService fileService;

    @PostConstruct
    public void init() throws FileNotFoundException{
        try {
            courses = fileService.readCoursesFromFile(courseFile.getPath());
            students = fileService.readStudentsFromFile(studentFile.getPath());   
        } catch (Exception e) {
            System.out.println("Tiedostoa ei löydy");
        }   
    }
    
    
    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            studentList.add(student);
        }
        return studentList;
    }

    @Override
    public List<Course> getCourses() {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public Student getStudentById(long studentId) {
        int i = (int)studentId;
        return students.get(i);
    }

    @Override
    public Course getCourseById(long courseId) {
        int i = (int)courseId;
        return courses.get(i);
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        int i = (int)studentId;
        List<Course> studentsCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStudentList().contains(getStudentById(i))){
                studentsCourses.add(course);
            }
        }
        return studentsCourses;
        
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId) {
        if (getCourseById(courseId).addStudentToCourse(getStudentById(studentId), getCourseById(courseId)) == true) {
            return true;
        }
        return false;
    }
}    
