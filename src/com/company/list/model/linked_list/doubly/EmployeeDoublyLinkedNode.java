package com.company.list.model.linked_list.doubly;

import com.company.list.model.Employee;

import java.util.Objects;

public class EmployeeDoublyLinkedNode {
    private Employee employee;
    private EmployeeDoublyLinkedNode next;
    private EmployeeDoublyLinkedNode previous;

    public EmployeeDoublyLinkedNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoublyLinkedNode getNext() {
        return next;
    }

    public EmployeeDoublyLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyLinkedNode previous) {
        this.previous = previous;
    }

    public void setNext(EmployeeDoublyLinkedNode next) {
        this.next = next;
    }

    public String toString() {
        return employee.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDoublyLinkedNode that = (EmployeeDoublyLinkedNode) o;
        return employee.equals(that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee);
    }
}
