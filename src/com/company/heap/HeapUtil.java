package com.company.heap;

import com.company.heap.model.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapUtil {

    public static void heap() {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(5);
        heap.printHeap();

        System.out.println(heap.peak());
    }

    public static void priorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        Object[] ints = pq.toArray();
        System.out.println(Arrays.toString(ints));

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq.remove(54));

        System.out.println(pq.peek());
        System.out.println(pq.add(-1));
        System.out.println(pq.peek());
    }

    public static void heapSort() {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
        System.out.println("Non-destructive sort");
        System.out.println(Arrays.toString(heap.sorted()));
        heap.printHeap();


        System.out.println("Destructive sort");
        System.out.println(Arrays.toString(heap.sort()));
        heap.printHeap();
    }
}
