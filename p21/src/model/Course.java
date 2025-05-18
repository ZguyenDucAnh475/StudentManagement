/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Course {
    JAVA(1, "Java"),
    PYTHON(2, "Python"),
    NET(3, ".Net"),
    C(4, "C"),
    CPP(5, "CPP");
    
    private int number;
    private String course;

    private Course(int number, String course) {
        this.number = number;
        this.course = course;
    }

    public int getNumber() {
        return number;
    }

    public String getCourse() {
        return course;
    }

    public static Course fromCourse(int number) {
        for (Course course : Course.values()) {
            if (course.getNumber() == number) {
                return course;
            }
        }
        return null;
    }
}
