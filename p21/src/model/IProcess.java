/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author NguyenDucAnh
 */
public interface IProcess<T> {

    void addStudent();

    void findStudent();

    ArrayList<T> sortStudent(ArrayList<T> newList);

}
