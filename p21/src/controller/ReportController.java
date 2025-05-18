/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Report;
import model.Student;

/**
 *
 * @author NguyenDucAnh
 */
public class ReportController {

    ArrayList<Report> reportList = new ArrayList<>();

    protected ArrayList<Report> setReportList(ArrayList<Student> studentList) {
        int idReport = 1;
        if (!reportList.isEmpty()) {
            idReport = reportList.get(reportList.size() - 1).getId() + 1;
        }
        try {
            for (Student o : studentList) {
                reportList.add(new Report(idReport++, o.getStuentID(), o.getName(), o.getSemester(), o.getCourse(), o.getId()));
            }
            System.out.println("Add to report list successfull!");
        } catch (Exception e) {
            System.err.println("Add to report list fail!");
        }

        return reportList;
    }

    protected ArrayList<Report> countStudentCourse(ArrayList<Report> reportList) {
        return new ArrayList<>();
    }

}
