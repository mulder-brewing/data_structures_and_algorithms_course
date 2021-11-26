package com.company.queue;

import com.company.model.Employee;
import com.company.queue.model.ArrayQueue;
import com.company.queue.model.CircularQueue;

public class QueueUtil {

    public static void arrayQueue() {
        ArrayQueue queue = new ArrayQueue(10);

        queue.add(new Employee("John", "Doe", 1));
        queue.add(new Employee("Jane", "Doe", 2));
        queue.add(new Employee("John", "Wick", 3));
        queue.add(new Employee("Tony", "Montanna", 4));

        queue.printQueue();

        System.out.println("Removed " + queue.remove());
        queue.printQueue();

        System.out.println("Peak " + queue.peak());
        queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.printQueue();
    }

    public static void circularQueue() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoe = new Employee("Jane", "Doe", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);


        CircularQueue queue = new CircularQueue(5);

        queue.add(johnDoe);
        queue.add(janeDoe);
        queue.add(johnWick);
        queue.add(tonyMontanna);
        queue.add(tonyMontanna);

        queue.printQueue();
    }
}
