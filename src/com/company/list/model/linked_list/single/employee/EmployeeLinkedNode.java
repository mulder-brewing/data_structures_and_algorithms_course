package com.company.list.model.linked_list.single.employee;

import com.company.list.model.Employee;

public class EmployeeLinkedNode {
    private Employee employee;
    private EmployeeLinkedNode next;

    public EmployeeLinkedNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeLinkedNode getNext() {
        return next;
    }

    public void setNext(EmployeeLinkedNode next) {
        this.next = next;
    }

    public String toString() {
        return employee.toString();
    }
}
