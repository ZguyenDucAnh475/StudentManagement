/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.StudentController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private StudentController studentController = new StudentController();

    private void run() {
        //studentController.generateDB();
        while (true) {
            studentController.getMenu();
            int choice = studentController.getChoice("Your choice: ",1, 6);
            if (studentController.isDBEmpty() && (choice != 1) && (choice != 5)) {
                System.err.println(String.format("You cant choose %d", choice));
                continue;
            }
            switch (choice) {
                case 1: // create
                    studentController.addStudent();
                    break;
                case 2: // find and sort
                    studentController.findStudent();
                    break;
                case 3: // update/delete
                    studentController.deleteStudent();
                    break;
                case 4: // report
                    studentController.reportCountCourse();
                    break;
                case 5: // exit
                    System.out.println("Exiting ..");
                    return;
                case 6:
                    studentController.displayReportList();
                    studentController.displayStudentList();
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
