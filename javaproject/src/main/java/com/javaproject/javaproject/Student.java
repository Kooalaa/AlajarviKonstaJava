package com.javaproject.javaproject;

public class Student {
    private long studentId;
    private String sukuNimi;
    private String etuNimi;
    private static long IdCounter = 0;

    
    public Student(String etuNimi, String sukuNimi) {
        this.sukuNimi = sukuNimi;
        this.etuNimi = etuNimi;
        this.studentId = IdCounter++;
        
    }

    @Override
    public String toString() {
        return String.format(etuNimi + " " + sukuNimi);
    }

    public String getEtuNimi() {
        return etuNimi;
    }

    public String getSukuNimi() {
        return sukuNimi;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setEtuNimi(String etuNimi) {
        this.etuNimi = etuNimi;
    }

    public void setSukuNimi(String sukuNimi) {
        this.sukuNimi = sukuNimi;
    }
}
