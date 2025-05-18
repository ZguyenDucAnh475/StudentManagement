/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.ReportController;
import controller.StudentController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private StudentController studentController = new StudentController();
    private ReportController reportController = new ReportController();

    private void run() {
        while (true) {
            studentController.getMenu();
            int choice = studentController.getChoice(1, 6);
            switch (choice) {
                case 1: // create
                    studentController.addStudent();
                    break;
                case 2: // find and sort
                    studentController.findStudent();
                    break;
                case 3: // update/delete
                    break;
                case 4: // report
                    break;
                case 5: // exit
                    System.out.println("Exiting ..");
                    return;
                case 6:
                    studentController.display();
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().run();
    }

}
