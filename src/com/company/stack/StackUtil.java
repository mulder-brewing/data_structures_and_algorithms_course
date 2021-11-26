package com.company.stack;

import com.company.model.Employee;
import com.company.stack.model.ArrayStack;
import com.company.stack.model.LinkedStack;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class StackUtil {

    public static void stackArrayImplementation() {
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("John", "Doe", 1));
        stack.push(new Employee("Jane", "Doe", 2));
        stack.push(new Employee("John", "Wick", 3));
        stack.push(new Employee("Tony", "Montanna", 4));

        stack.printStack();

        System.out.println(stack.peek());
        System.out.println();
        stack.printStack();

        System.out.println("Popped " + stack.pop());
        System.out.println("Peak " + stack.peek());
    }

    public static void stackLinkedImplementation() {
        LinkedStack stack = new LinkedStack();

        stack.push(new Employee("John", "Doe", 1));
        stack.push(new Employee("Jane", "Doe", 2));
        stack.push(new Employee("John", "Wick", 3));
        stack.push(new Employee("Tony", "Montanna", 4));

        stack.printStack();

        System.out.println("Peak " + stack.peek());
        System.out.println();
        stack.printStack();

        System.out.println("Popped " + stack.pop());
        System.out.println("Peak " + stack.peek());
    }

    public static boolean isPalindrome(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        }

        // strip punctuation and whitespace & uppercase
        String beforeSplit = s.replaceAll("[^A-Za-z]+", "").toUpperCase();
        if (StringUtils.isBlank(beforeSplit)) {
            return false;
        }

        char[] cArr = beforeSplit.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (Character c : cArr) {
            stack.push(c);
        }

        for (Character c : cArr) {
            if (!c.equals(stack.pop())) {
                return false;
            }
        }

        return true;
    }


}
