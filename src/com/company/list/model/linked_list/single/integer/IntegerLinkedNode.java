package com.company.list.model.linked_list.single.integer;

import java.util.Objects;

public class IntegerLinkedNode {
    private Integer integer;
    private IntegerLinkedNode next;

    public IntegerLinkedNode(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public IntegerLinkedNode getNext() {
        return next;
    }

    public void setNext(IntegerLinkedNode next) {
        this.next = next;
    }

    public String toString() {
        return integer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerLinkedNode that = (IntegerLinkedNode) o;
        return integer.equals(that.integer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(integer);
    }
}
