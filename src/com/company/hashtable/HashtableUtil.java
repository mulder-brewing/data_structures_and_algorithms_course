package com.company.hashtable;

import com.company.hashtable.model.ChainHashtable;
import com.company.hashtable.model.ProbeHashtable;
import com.company.model.Employee;

import java.util.*;

public class HashtableUtil {

    public static void probeHashTable() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoy = new Employee("Jane", "Doy", 2);
        Employee rickBob = new Employee("Rick", "Bob", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        ProbeHashtable<Employee> ht = new ProbeHashtable<>();
        ht.put(johnDoe.getLastName(), johnDoe);
        ht.put(janeDoy.getLastName(), janeDoy);
        ht.put(rickBob.getLastName(), rickBob);
        ht.put(johnWick.getLastName(), johnWick);
        ht.put(tonyMontanna.getLastName(), tonyMontanna);

        ht.printHashTable();

        System.out.println("Retrieving Montanna: " + ht.get(tonyMontanna.getLastName()));
        System.out.println("Retrieving Jane Doy: " + ht.get(janeDoy.getLastName()));
        System.out.println("Retrieving Rick Bob: " + ht.get(rickBob.getLastName()));

        System.out.println("Removing Jane Doy");
        ht.remove(janeDoy.getLastName());
        System.out.println("Removing John Doe");
        ht.remove(johnDoe.getLastName());
        System.out.println("Retrieving Rick Bob: " + ht.get(rickBob.getLastName()));
        ht.printHashTable();
    }

    public static void chainHashTable() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoy = new Employee("Jane", "Doy", 2);
        Employee rickBob = new Employee("Rick", "Bob", 2);
        Employee johnWick = new Employee("John", "Wick", 3);
        Employee tonyMontanna = new Employee("Tony", "Montanna", 4);

        ChainHashtable<Employee> ht = new ChainHashtable<>();
        ht.put(johnDoe.getLastName(), johnDoe);
        ht.put(janeDoy.getLastName(), janeDoy);
        ht.put(rickBob.getLastName(), rickBob);
        ht.put(johnWick.getLastName(), johnWick);
        ht.put(tonyMontanna.getLastName(), tonyMontanna);

        ht.printHashTable();

        System.out.println("Getting Rick Bob: " + ht.get(rickBob.getLastName()));
        System.out.println("Removing Rick Bob: " + ht.remove(rickBob.getLastName()));
        System.out.println("Getting Rick Bob: " + ht.get(rickBob.getLastName()));
        System.out.println("Getting Jane Doy: " + ht.get(janeDoy.getLastName()));

        ht.printHashTable();
    }

    public static void hashMap() {
        Employee johnDoe = new Employee("John", "Doe", 1);
        Employee janeDoy = new Employee("Jane", "Doy", 2);
        Employee rickBob = new Employee("Rick", "Bob", 2);

        Map<String, Employee> hashMap = new HashMap<>();
        hashMap.put(johnDoe.getLastName(), johnDoe);
        hashMap.put(janeDoy.getLastName(), janeDoy);
        hashMap.put(rickBob.getLastName(), rickBob);
        Employee employee = hashMap.putIfAbsent(johnDoe.getLastName(), johnDoe);
        System.out.println("John Doe was already there: " + employee);

//        Iterator<Employee> itr = hashMap.values().iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
//        }

        System.out.println(hashMap);

        System.out.println(hashMap.containsKey(johnDoe.getLastName()));
        System.out.println(hashMap.containsValue(johnDoe));

        System.out.println(hashMap.get("Doesn't exist"));

        System.out.println("Removing: " + hashMap.remove(johnDoe.getLastName()));
    }

    public static int[] bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i : input) {
            buckets[bucketHash(i)].add(i);
        }

        int[] sorted = new int[input.length];
        int i = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (Integer val : bucket) {
                sorted[i++] = val;
            }
        }
        return sorted;
    }

    private static int bucketHash(int num) {
        return num / 10 % 10;
    }

    public static List removeDuplicates(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        return list.stream().filter(e -> map.put(e.getId(), e) == null).toList();
    }

}
