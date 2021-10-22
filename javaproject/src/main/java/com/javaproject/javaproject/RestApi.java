package com.javaproject.javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
    @Autowired
    MyCourseService myCourseController;

    @GetMapping("students")
    public List<Student> getStudents(){
        return myCourseController.getStudents();
    }
        
    @GetMapping("courses")
    public List<Course> getCourses(){
        return myCourseController.getCourses();
    }

    @GetMapping("onlinecourses")
    public List<Course> getOnlineCourses(){
        List<Course> onlineCoursesList = new ArrayList<>();
        for (Course course : myCourseController.courses) {
            if (course instanceof OnlineCourse) {
                onlineCoursesList.add(course);
            }
        }
        return onlineCoursesList;
    }
    
    @GetMapping("students/{id}")
    public String student(@PathVariable long id){
        return myCourseController.getStudentById(id).toString() + 
        myCourseController.getCoursesOfStudent(id).toString();
    }

    @GetMapping("courses/{id}")
    public String course(@PathVariable long id){
        return myCourseController.getCourseById(id).toString() + 
        myCourseController.getCourseById(id).getStudentList().toString();
        
    }

    @PostMapping("add")
    public String addStudentToCourse(@RequestBody Map<String, Object> jsonMapping){
        String cIdConvert = jsonMapping.get("cId").toString();
        String sIdConvert = jsonMapping.get("sId").toString();

        // Tarkistetaan onko sama opiskelija jo tällä kurssilla
        if (myCourseController.getCourseById(Long.parseLong(cIdConvert)).getStudentList().contains(myCourseController.getStudentById(Long.parseLong(sIdConvert)))) {
            return "Opiskelija on jo kurssilla";
        }
        if (myCourseController.addStudentToCourse(Long.parseLong(sIdConvert), Long.parseLong(cIdConvert)) == true) {
            return "Opiskelijan lisäys onnistui";
        }
    return "Kurssi täynnä, opiskelijaa ei voitu lisätä kurssille";
    }

}
