package com.epam.javase.units.unit2.t03_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeList {
    private List<Employee> listEmployees = new ArrayList<>();
    private int indexSelectedEmployee = -1;

    public static void main(String[] args) {
        EmployeeList employees = new EmployeeList();
        employees.readCommand(employees);
    }

    public int getIndexSelectedEmployee() {
        return indexSelectedEmployee;
    }

    public void setIndexSelectedEmployee(int indexSelectedEmployee) {
        this.indexSelectedEmployee = indexSelectedEmployee;
    }

    /** Add a new employee at the listEmployees */
    public void addNewEmployee(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Lastname: ");
            String lastname = sc.nextLine();

            listEmployees.add(new Employee(name, lastname));
        }
        catch(Exception ex){
            System.out.println("You entered the wrong value!");
        }
    }

    /** Remove the employee form listEmployees by index */
    public void removeEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index: ");
        int index = sc.nextInt();
        if(index < 1 || index > listEmployees.size()) {
            System.out.println("Thing with this index is absent!");
            return;
        }
        System.out.println("Thing successfully deleted!");
        listEmployees.remove(index - 1);
    }

    /** Select the employee by the index */
    public void selectEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index: ");
        int index = sc.nextInt();
        if(index < 1 || index > listEmployees.size()) {
            System.out.println("Thing with this index is absent!");
            return;
        }
        setIndexSelectedEmployee(index - 1);
    }

    /** Watch all employees in the listEmployees */
    public void watchListEmployees(){
        System.out.println("================= List employees ====================");
        int count = 1;
        for (Employee employee : listEmployees) {
            System.out.println(count++ + ") " + employee);
            System.out.println("=================================================");
        }
    }

    /** Wait for a command in the console */
    public void readCommand(EmployeeList employees){
        while (true){
            if(indexSelectedEmployee == -1) {
                System.out.println("Enter the command number:");
                System.out.println("[1] Add a new employee");
                System.out.println("[2] Select the employee");
                System.out.println("[3] Remove the employee");
                System.out.println("[4] Watch the list of employees");
                System.out.println("[5] Exit");
                System.out.print("Command number: ");
                Scanner sc = new Scanner(System.in);
                int commandNumber = sc.nextInt();
                System.out.println();
                if (commandNumber == 5) break;
                switch (commandNumber) {
                    case 1:
                        employees.addNewEmployee();
                        break;
                    case 2:
                        employees.selectEmployee();
                        break;
                    case 3:
                        employees.removeEmployee();
                        break;
                    case 4:
                        employees.watchListEmployees();
                        break;
                    default:
                        System.out.println("You enter the wrong command number! Try again!");
                }
                System.out.println();
            }
            else{
                listEmployees.get(indexSelectedEmployee).getListGoods().readCommand(listEmployees.get(indexSelectedEmployee).getListGoods());
                indexSelectedEmployee = -1;
            }
        }
    }



}
