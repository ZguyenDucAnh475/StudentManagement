/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public class Report extends Student {

    private int totalOfCourse;

    public Report(int totalOfCourse, String stuentID, String name, Semester semester, Course course, int id) {
        super(stuentID, name, semester, course, id);
        this.totalOfCourse = totalOfCourse;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }

}
