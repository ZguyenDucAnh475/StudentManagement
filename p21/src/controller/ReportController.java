/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import model.Report;
import model.Student;

/**
 *
 * @author NguyenDucAnh
 */
public class ReportController {

    private ArrayList<Report> reportList = new ArrayList<>();
    private StudentController studentController = new StudentController();

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

//    public Map<String, Integer> countCoursesBySemester(ArrayList<Student> students, String studentID) {
//        for (Student student : students) {
//            if (student.getStuentID().equals(studentID)) {
//                Map<String, Integer> semesterCount = new HashMap<>();
//                for (Student o : reportList) {
//                    String semester = o.getSemester().getSemester();
//                    semesterCount.put(semester, semesterCount.getOrDefault(semester, 0) + 1);
//                }
//                return semesterCount;
//            }
//        }
//        return Collections.emptyMap(); // Nếu không tìm thấy student
//    }
    private Report findStudentByReportID(int id) {
        for (Report o : reportList) {
            if (o.getIdForReport() == id) {
                return o;
            }
        }
        return null;
    }

    protected void deleteStudent() {
        int idInput = 1;
        Report reDel = findStudentByReportID(idInput);
        while (reDel == null) {
            System.err.println("Can't find this id!");
            System.out.print("Enter new id to del: ");
            idInput = 1;
            reDel = findStudentByReportID(idInput);
        }

        // Remove report
        Iterator<Report> itReport = reportList.iterator();
        while (itReport.hasNext()) {
            Report report = itReport.next();
            if (report.getIdForReport() == idInput) {
                itReport.remove();
                break;
            }
        }
        ArrayList<Student> data = studentController.getList();
        // Remove corresponding student
        Iterator<Student> itStudent = data.iterator();
        while (itStudent.hasNext()) {
            Student student = itStudent.next();
            if (student.getId() == reDel.getId()) {
                itStudent.remove();
                break;
            }
        }

        // Reset idProcess in order
        for (int i = 0; i < reportList.size(); i++) {
            reportList.get(i).setIdForReport(i + 1);
        }

        System.out.println("Remove successful!");
    }

}
