/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public class Student {

    private String stuentID;
    private String name;
    private Semester semester;
    private Course course;
    private int id;

    public Student(String stuentID, String name, Semester semester, Course course, int id) {
        this.stuentID = stuentID;
        this.name = name;
        this.semester = semester;
        this.course = course;
        this.id = id;
    }

    public String getStuentID() {
        return stuentID;
    }

    public void setStuentID(String stuentID) {
        this.stuentID = stuentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "stuentID=" + stuentID + ", name=" + name + ", semester=" + semester + ", course=" + course + ", id=" + id + '}';
    }

}
