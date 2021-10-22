package com.javaproject.javaproject;

import java.io.FileNotFoundException;
import java.util.List;

public interface CourseFileController {
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;
    
    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
