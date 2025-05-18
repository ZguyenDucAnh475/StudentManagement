/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Comparator;
import model.Course;
import model.IReport;
import model.IProcess;
import model.Semester;
import model.Student;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentController implements IProcess<Student>, IReport<Student> {

    private ProgramView view = new ProgramView();
    private ArrayList<Student> studentList = new ArrayList<>();

    // ---------------------------------------- VIEW ---------------------------------------------------
    private void displayFindAndSorted(ArrayList<Student> list) {
        for (Student o : list) {
            System.out.println(o.toString());
        }
    }

    // ---------------------------------------- XU LY ---------------------------------------------------
    @Override
    public void addStudent() {
        String newStudentID = "";
        String newName = "";
        Semester newSemester = null;
        Course newCourse = null;
        addToList(newStudentID, newName, newSemester, newCourse);
    }

    @Override
    public void findStudent() {
        ArrayList<Student> newList = new ArrayList<>();
        String studentGetID = "";
        Student studentFound = findStudentByID(studentGetID);
        sortStudent(newList);
        while (studentFound == null) {
            System.err.println("");
            studentGetID = "";
            studentFound = findStudentByID(studentGetID);
        }

        for (Student o : studentList) {
            if (o.getStuentID().equals(studentFound.getStuentID())) {
                newList.add(o);
            }
        }

        displayFindAndSorted(newList);

    }

    @Override
    public ArrayList<Student> sortStudent(ArrayList<Student> newList) {
        newList.sort(Comparator.comparing(Student::getName));
        return newList;
    }

    @Override
    public ArrayList<Student> report() {
        return new ArrayList<>();
    }

    // ---------------------------------------- SUPPORT FUNCTION --------------------------------------------------
    private Student findStudentByID(String studentGetID) {
        for (Student o : studentList) {
            if (o.getStuentID().equals(studentGetID)) {
                return o;
            }
        }
        return null;
    }

    private boolean isDuplicatedStudentCode(String studentGetID) {
        for (Student o : studentList) {
            if (o.getStuentID().equals(studentGetID)) {
                return true;
            }
        }
        return false;
    }

    private void addToList(String newStudentID, String newName, Semester newSemester, Course newCourse) {
        int id = 1;
        if (!studentList.isEmpty()) {
            id = studentList.get(studentList.size() - 1).getId() + 1;
        }
        try {
            Student newStudent = new Student(newStudentID, newName, newSemester, newCourse, id++);
            studentList.add(newStudent);
            System.out.println("Add Successfull!");

        } catch (Exception e) {
            System.err.println("Add Fail!");
        }
    }

    // -------------------------------------------------- INPUT --------------------------------------------------
    private String setStudentID() {
        return "";
    }

    private String setName() {
        return "";
    }

    private Semester setSemester() {
        return null;
    }

    private Course setCourse() {
        return null;
    }
}
