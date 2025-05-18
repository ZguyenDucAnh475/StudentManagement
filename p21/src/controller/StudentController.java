/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import model.Course;
import model.IReport;
import model.IProcess;
import model.Semester;
import model.Student;
import utils.InputHandle;
import view.ProgramView;
import model.Report;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentController implements IProcess<Student>, IReport<Student> {

    private ProgramView view = new ProgramView();
    private InputHandle inputHandle = new InputHandle();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Report> reportList = new ArrayList<>();

    protected ArrayList<Student> getList() {
        return studentList;
    }

    public void generateDB() {
        studentList.add(new Student("W 1", "Nguyen A", Semester.SUMMER, Course.JAVA, 1));
        studentList.add(new Student("W 2", "Nguyen B", Semester.SUMMER, Course.NET, 2));
        studentList.add(new Student("W 1", "Nguyen A", Semester.SPRING, Course.PYTHON, 3));
        studentList.add(new Student("W 3", "Nguyen C", Semester.SUMMER, Course.JAVA, 4));
        studentList.add(new Student("W 1", "Nguyen A", Semester.SUMMER, Course.JAVA, 5));
        studentList.add(new Student("W 2", "Nguyen B", Semester.SUMMER, Course.NET, 6));
        studentList.add(new Student("W 3", "Nguyen C", Semester.SUMMER, Course.JAVA, 7));
        studentList.add(new Student("W 1", "Nguyen A", Semester.SPRING, Course.PYTHON, 8));
        studentList.add(new Student("W 4", "Nguyen D", Semester.FALL, Course.C, 9));
        studentList.add(new Student("W 1", "Nguyen A", Semester.SUMMER, Course.JAVA, 10));
        studentList.add(new Student("W 5", "Nguyen E", Semester.FALL, Course.CPP, 11));

    }

    // ---------------------------------------- VIEW ---------------------------------------------------
    private void displayFindAndSorted(ArrayList<Student> list) {
        for (Student o : list) {
            System.out.println(o.toString());
        }
    }

    public void displayStudentList() {
        for (Student o : studentList) {
            System.out.println(o.toString());
        }
    }

    public void displayReportList() {
        for (Report o : reportList) {
            System.out.println(o.toString());
        }
    }

    public void getMenu() {
        view.printMenuTitle("Student Management");
        view.printMenu();
    }

    // ---------------------------------------- XU LY ---------------------------------------------------
    @Override
    public void addStudent() {

        view.printTitle("Create Student");
        String newStudentID = inputHandle.validateGetString("Enter Student ID: ", "W \\d+");
        String newName = inputHandle.validateGetString("Enter new Name: ", "[a-zA-Z ]+");
        while (isDuplicatedStudentCode(newStudentID) && !isDuplicatedStudentName(newName)) {
            System.err.println("Your input is duplicated! re-input:");
            newStudentID = inputHandle.validateGetString("Enter Student ID: ", "W \\d+");
            newName = inputHandle.validateGetString("Enter new Name: ", "[a-zA-Z ]+");
        }
        Semester newSemester = getSemesterUserInput();
        Course newCourse = getCourseUserInput();
        addToList(newStudentID, newName, newSemester, newCourse);

    }

    @Override
    public void findStudent() {
        view.printTitle("Find and Sort");
        ArrayList<Student> newList = new ArrayList<>();
        String studentGetID = inputHandle.validateGetString("Enter Student ID: ", "W \\d+");
        Student studentFound = findStudentByID(studentGetID);
        sortStudent(newList);
        while (studentFound == null) {
            System.err.println(String.format("No student CODE [%s] found!", studentGetID));
            studentGetID = inputHandle.validateGetString("Enter Student ID: ", "W \\d+");
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

    private ArrayList<Report> setReportList(ArrayList<Student> studentList) {
        reportList.clear();
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

    public void updateORdelete() {
        displayReportList();
        boolean getUD = inputHandle.checkUD("Do you want to Update/Delete student? ");
        boolean getYN = inputHandle.checkYN("Do you want to Continue? ");
        if (getUD) {
            if (getYN) {
                updateStudent();
            } else {
                System.out.println("Update Cancel!");
            }
        } else {
            if (getYN) {
                deleteStudent();
            } else {
                System.out.println("Delete Cancel!");
            }
        }
    }

    private void updateStudent() {
        view.printTitle("Update");
        int idInput = getChoice("Enter ID to update: ", 1, reportList.size());
        Report reUpdate = findStudentByReportID(idInput);
        while (reUpdate == null) {
            System.err.println("Can't find this id!");
            idInput = getChoice("Enter ID to update: ", 1, reportList.size());
            reUpdate = findStudentByReportID(idInput);
        }

        Semester newSemester = getSemesterUserInput();
        Course newCourse = getCourseUserInput();

        // Remove report
        Iterator<Report> itReport = reportList.iterator();
        while (itReport.hasNext()) {
            Report report = itReport.next();
            if (report.getIdForReport() == idInput) {
                report.setSemester(newSemester);
                report.setCourse(newCourse);
                break;
            }
        }

        // Remove corresponding student
        Iterator<Student> itStudent = studentList.iterator();
        while (itStudent.hasNext()) {
            Student student = itStudent.next();
            if (student.getId() == reUpdate.getId()) {
                student.setCourse(reUpdate.getCourse());
                student.setCourse(reUpdate.getCourse());
                break;
            }
        }

        // Reset idProcess in order
        for (int i = 0; i < reportList.size(); i++) {
            reportList.get(i).setIdForReport(i + 1);
        }

        System.out.println("Update successful!");
    }

    private void deleteStudent() {
        view.printTitle("Delete");
        int idInput = getChoice("Enter ID to delete: ", 1, reportList.size());
        Report reDel = findStudentByReportID(idInput);
        while (reDel == null) {
            System.err.println("Can't find this id!");
            System.out.print("Enter new id to del: ");
            idInput = getChoice("Enter ID to delete: ", 1, reportList.size());
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

        // Remove corresponding student
        Iterator<Student> itStudent = studentList.iterator();
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

    public void reportCountCourse() {

        // Map lưu key: "id|name|semester", value: another map lưu course -> count
        HashMap<String, HashMap<String, Integer>> reportMap = new HashMap<>();

        for (Student student : studentList) {
            String studentKey = student.getStuentID() + "|" + student.getName() + "|" + student.getSemester();
            String course = student.getCourse().getCourse();

            // Nếu chưa có studentKey trong reportMap, tạo mới 1 map course-count cho nó
            reportMap.putIfAbsent(studentKey, new HashMap<>());

            // Lấy map course-count của student này ra
            HashMap<String, Integer> courseCount = reportMap.get(studentKey);

            // Tăng count cho course
            courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
        }

        // In kết quả
        System.out.printf("%-10s|%-15s|%-10s|%-10s|%-5s\n", "ID", "Name", "Semester", "Course", "Total");
        for (String studentKey : reportMap.keySet()) {
            String[] parts = studentKey.split("\\|");
            String id = parts[0];
            String name = parts[1];
            String semester = parts[2];
            HashMap<String, Integer> courseCount = reportMap.get(studentKey);

            for (String course : courseCount.keySet()) {
                int total = courseCount.get(course);
                System.out.printf("%-10s|%-15s|%-10s|%-10s|%-5d\n", id, name, semester, course, total);
            }
        }
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

    private Report findStudentByReportID(int id) {
        for (Report o : reportList) {
            if (o.getIdForReport() == id) {
                return o;
            }
        }
        return null;
    }

    private boolean isDuplicatedStudentName(String studentGetName) {
        for (Student o : studentList) {
            if (o.getName().toLowerCase().equalsIgnoreCase(studentGetName.toLowerCase())) {
                return true;
            }
        }
        return false;
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
            setReportList(studentList);
            System.out.println("Add Successfull!");

        } catch (Exception e) {
            System.err.println("Add Fail!");
        }

    }

    // -------------------------------------------------- INPUT --------------------------------------------------
    private void printChoiceCoure() {
        System.out.println("Choose COURSE:");
        for (Course c : Course.values()) {
            System.out.println(c.getNumber() + " - " + c.getCourse());
        }
    }

    private void printChoiceSemester() {
        System.out.println("Choose SEMESTER:");
        for (Semester s : Semester.values()) {
            System.out.println(s.getNumber() + " - " + s.getSemester());
        }
    }

    private Semester getSemesterUserInput() {
        printChoiceSemester();
        int semesterChoiceNumber = inputHandle.getInt("Enter Semester Number: ");
        while (Semester.fromSemester(semesterChoiceNumber) == null) {
            System.err.println("Please input number choice in SEMESTER list:");
            printChoiceSemester();
            semesterChoiceNumber = inputHandle.getInt("Enter Semester Number: ");
        }

        return Semester.fromSemester(semesterChoiceNumber);
    }

    private Course getCourseUserInput() {
        printChoiceCoure();
        int courseChoiceNumber = inputHandle.getInt("Enter Course Number: ");
        while (Course.fromCourse(courseChoiceNumber) == null) {
            System.err.println("Please input number choice in COURSE list:");
            printChoiceCoure();
            courseChoiceNumber = inputHandle.getInt("Enter Course Number: ");
        }

        return Course.fromCourse(courseChoiceNumber);
    }

    public int getChoice(String msg, int min, int max) {
        return inputHandle.getUserLimit(msg, min, max);
    }

    public boolean isDBEmpty() {
        return studentList.isEmpty();
    }

}
