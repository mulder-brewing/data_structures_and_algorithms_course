package com.company.list;

import com.company.list.model.linked_list.doubly.EmployeeDoublyLinkedList;
import com.company.list.model.linked_list.single.employee.EmployeeLinkedList;
import com.company.model.Employee;

import java.util.*;

public class ListUtil {

    public static void arrayListBasics() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("John", "Doe", 1));
        employeeList.add(new Employee("Jane", "Doe", 2));
        employeeList.add(new Employee("John", "Wick", 3));
        employeeList.add(new Employee("Tony", "Montanna", 4));

        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("New", "Employee", 5));
        employeeList.add(3, new Employee("Inserted", "Employee", 4788));
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.size());

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("John", "Wick", 3)));
        System.out.println(employeeList.indexOf(new Employee("Inserted", "Employee", 4788)));

        employeeList.remove(3);
        employeeList.forEach(employee -> System.out.println(employee));
    }

    /**
     * Same as ArrayList but synchronized
     */
    public static void vectorBasics() {
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("John", "Doe", 1));
        employeeList.add(new Employee("Jane", "Doe", 2));
        employeeList.add(new Employee("John", "Wick", 3));
        employeeList.add(new Employee("Tony", "Montanna", 4));

        employeeList.forEach(employee -> System.out.println(employee));
    }

    public static void linkedList() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        EmployeeLinkedList employees = new EmployeeLinkedList();
        System.out.println(employees.isEmpty());
        employees.addToFront(johnDoe);
        employees.addToFront(janeDoe);
        employees.addToFront(johnWick);
        employees.addToFront(tonyMontanna);
        System.out.println(employees.isEmpty());

        employees.printList();

        System.out.println(employees.getSize());

        employees.removeFromFront();
        System.out.println(employees.getSize());
        employees.printList();

    }

    public static void doublyLinkedList() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        EmployeeDoublyLinkedList employees = new EmployeeDoublyLinkedList();

        employees.addToFront(johnDoe);
        employees.addToFront(janeDoe);
        employees.addToFront(johnWick);
        employees.addToFront(tonyMontanna);

        employees.printList();

        Employee addToEnd = new Employee("Added", "To End", 88774);
        employees.addToEnd(addToEnd);
        employees.printList();

        employees.removeFromFront();
        employees.printList();
        System.out.println(employees.getSize());

        employees.removeFromEnd();
        employees.printList();
        System.out.println(employees.getSize());
    }

    public static void jdkLinkedList() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        LinkedList<Employee> employees = new LinkedList<>();
        employees.addFirst(johnDoe);
        employees.addFirst(janeDoe);
        employees.addFirst(johnWick);
        employees.addFirst(tonyMontanna);

        printLinkedList(employees);

        Employee addToEnd = new Employee("Added", "To End", 88774);
        employees.addLast(addToEnd);
        printLinkedList(employees);

        employees.removeFirst();
        printLinkedList(employees);

        employees.removeLast();
        printLinkedList(employees);
    }

    private static void printLinkedList(List<Employee> employees) {
        Iterator iter = employees.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(" <=> ");
            } else {
                System.out.println();
            }
        }
    }

}
