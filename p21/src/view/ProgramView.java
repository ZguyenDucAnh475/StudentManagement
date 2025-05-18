/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class ProgramView {

    private String createView = "Create Student";
    private String findAndSortView = "Find and sort";
    private String updateORdeleteView = "Update/Delete";
    private String reportView = "Report";
    private String symbolTitleMenu = " =============== ";
    private String symbolTitle = " --------------- ";

    public String getCreateView() {
        return createView;
    }

    public String getFindAndSortView() {
        return findAndSortView;
    }

    public String getUpdateORdeleteView() {
        return updateORdeleteView;
    }

    public String getReportView() {
        return reportView;
    }

    public String getSymbolTitleMenu() {
        return symbolTitleMenu;
    }

    public String getSymbolTitle() {
        return symbolTitle;
    }

    public void printMenuTitle(String title) {
        System.out.println(symbolTitleMenu + title + symbolTitleMenu);
    }

    public void printTitle(String title) {
        System.out.println(symbolTitle + title + symbolTitle);
    }

    public void printMenu() {
        String menu[] = {createView, findAndSortView, updateORdeleteView,
            reportView, "Exit"};
        for (int i = 0; i < menu.length; i++) {
            System.out.println(String.format("%d. %s", i+1,menu[i]));
        }
    }
}
