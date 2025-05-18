/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Semester {

    FALL(1, "Fall"),
    SPRING(2, "Spring"),
    SUMMER(3, "Summer");

    private int number;
    private String semester;

    private Semester(int number, String semester) {
        this.number = number;
        this.semester = semester;
    }

    public int getNumber() {
        return number;
    }

    public String getSemester() {
        return semester;
    }

    public static Semester fromSemester(int number) {
        for (Semester semester : Semester.values()) {
            if (semester.getNumber() == number) {
                return semester;
            }
        }
        return null;
    }
}
