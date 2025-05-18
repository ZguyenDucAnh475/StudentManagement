/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Course;
import model.IProcess;
import model.Semester;
import model.Student;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentController implements IProcess {

    private ProgramView view = new ProgramView();
    private ArrayList<Student> studentList = new ArrayList<>();

    // ---------------------------------------- XU LY ---------------------------------------------------
    @Override
    public void addStudent() {
        String newStudentID = "";
        String newName = "";
        Semester newSemester = null;
        
    }

    @Override
    public ArrayList<Student> findStudent() {
        ArrayList<Student> newList = new ArrayList<>();
        String studentGetID = "";

        return newList;
    }

    @Override
    public ArrayList<?> sortStudent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<?> report() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            Student newStudent = new Student(newStudentID, newName, newSemester, newCourse, id);
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
