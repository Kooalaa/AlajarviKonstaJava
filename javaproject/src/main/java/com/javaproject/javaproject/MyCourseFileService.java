package com.javaproject.javaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class MyCourseFileService implements CourseFileController{



    @Override
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        File sFile = new File(filePath);
        Scanner scanner = new Scanner(sFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                Student student = new Student(info[0], info[1]);
                students.add(student);
            }

        scanner.close();
        return students;
    }

    @Override
    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        List<Course> courses = new ArrayList<>();
        File cFile = new File(filePath);
        Scanner scanner = new Scanner(cFile);
       while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] info = line.split("-");
            if (info[3].matches("online")){
                OnlineCourse onlineCourse = new OnlineCourse(info[0], info[1], info[2]);
                courses.add(onlineCourse);
            }else{
                LocalCourse localCourse = new LocalCourse(info[0], info[1], info[2]);
                courses.add(localCourse);
            }
           
        }
        scanner.close();
        return courses;

    }
    
}
