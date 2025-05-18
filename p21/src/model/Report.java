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

    private int idForReport;
    private int totalOfCourse;

    public Report(int idForReport, int totalOfCourse, String stuentID, String name, Semester semester, Course course, int id) {
        super(stuentID, name, semester, course, id);
        this.idForReport = idForReport;
        this.totalOfCourse = totalOfCourse;
    }

    public int getIdForReport() {
        return idForReport;
    }

    public void setIdForReport(int idForReport) {
        this.idForReport = idForReport;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }

    @Override
    public String toString() {
        return "Report{" + "idForReport=" + idForReport + ", totalOfCourse=" + totalOfCourse + '}';
    }

}
