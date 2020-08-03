package com.njha;

import java.util.Collections;
import java.util.PriorityQueue;

public class JavaPriorityQueue {

    public static void main(String[] args) {
        // Default implementation of Java PriorityQueue is MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq.poll()); // 1
        
        // getting MaxHeap
        pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq.poll()); // 3
        
        // String: Natural alphabetical order
        PriorityQueue<String> pq2 = new PriorityQueue<>();
        pq2.add("Apple");
        pq2.add("PineApple");
        pq2.add("Custard Apple");
        while (!pq2.isEmpty())
            System.out.println(pq2.poll());
        /*
        Apple
        Custard Apple
        PineApple
        */
        
        // String: Reverse alphabetical order
        pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add("Apple");
        pq2.add("PineApple");
        pq2.add("Custard Apple");
        while (!pq2.isEmpty())
            System.out.println(pq2.poll());
        /*
        PineApple
        Custard Apple
        Apple
        */
        
        // String: Custom logic (increasing length order)
        pq2 = new PriorityQueue<>((a, b) -> a.length() - b.length());
        pq2.add("Apple");
        pq2.add("PineApple");
        pq2.add("Custard Apple");
        while (!pq2.isEmpty())
            System.out.println(pq2.poll());
        /*
        Apple
        PineApple
        Custard Apple
        */
        
        // String: Reverse custom logic (decreasing length order)
        pq2 = new PriorityQueue<>(Collections.reverseOrder((a, b) -> a.length() - b.length()));
        pq2.add("Apple");
        pq2.add("PineApple");
        pq2.add("Custard Apple");
        while (!pq2.isEmpty())
            System.out.println(pq2.poll());
        /*
        Custard Apple
        PineApple
        Apple
        */
        
        // For complex logic in comparator
        pq2 = new PriorityQueue<>((a, b) -> {
            // blah blah
            // blah blah
            return a.length() - b.length();
        });
        
        // We can also use comparable objects.
        // We will not have to pass comparator to PQ constructor 
        // for custom objects, if it implements Comparable
    }
}
