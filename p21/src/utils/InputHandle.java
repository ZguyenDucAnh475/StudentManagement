/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    public String validateGetString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cant be empty!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println(String.format("Invalid format! please input follow up %s", regex));
            }

        }
    }

    public int getUserLimit(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cant be empty!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("This value must > 0");
                    continue;
                }

                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.err.println(String.format("Please input from %d to %d!", min, max));
                }

            } catch (NumberFormatException e) {
                System.err.println("This value must a integer!");
            }
        }
    }

    public int getInt(String msg) {
        while (true) {
            System.out.print(msg);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cant be empty!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);

                if (number <= 0) {
                    System.err.println("This value must > 0");
                    continue;
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("This value must a integer!");
            }
        }
    }

    public boolean checkYN(String msg) {
        while (true) {
            System.out.print(msg+"(Yes[Y]/No[N]): ");
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            if (value.equalsIgnoreCase("y")) {
                return true;
            }

            if (value.equalsIgnoreCase("n")) {
                return false;
            }

            System.err.println("Please input 'y' or 'n'!");

        }
    }

    public boolean checkUD(String msg) {
        while (true) {
            System.out.print(msg + "(Upadte[U]/Delete[D]): ");
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            if (value.equalsIgnoreCase("u")) {
                return true;
            }

            if (value.equalsIgnoreCase("d")) {
                return false;
            }

            System.err.println("Please input 'u' or 'd'!");

        }
    }

}
