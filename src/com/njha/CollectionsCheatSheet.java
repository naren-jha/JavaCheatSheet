package com.njha;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsCheatSheet {

    public static void main(String[] args) throws Exception {
        array();
        
        dynamicArray();
        
        linkedList();
        
        queue();
        
        stack();
        
        hashSet();
        
        treeSet();
        
        hashMap();
        
        treeMap();
    }

    private static void treeMap() {
        /* >>> Balanced BST - RedBlackTree - <key, value> <<< */
        Map<String, Integer> bstMap = new TreeMap<String, Integer>();
        bstMap.put("k3", 3); bstMap.put("k1", 1); bstMap.put("k2", 2);
        System.out.println(bstMap); // {k1=1, k2=2, k3=3}
        
        System.out.println(bstMap.containsKey("k1")); // true
        System.out.println(bstMap.containsValue(2)); // true
        System.out.println(bstMap.get("k2")); // 2
        
        System.out.println(bstMap.entrySet()); // [k1=1, k2=2, k3=3]
        System.out.println(bstMap.keySet()); // [k1, k2, k3]
        System.out.println(bstMap.values()); // [1, 2, 3]
        
        for (Map.Entry<String, Integer> entry : bstMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        /*
        k1 -> 1
        k2 -> 2
        k3 -> 3
        */
        
        for (String key : bstMap.keySet()) {
            System.out.println(key + " -> " + bstMap.get(key));
        }
        /*
        k1 -> 1
        k2 -> 2
        k3 -> 3
        */
    }

    private static void hashMap() {
        /* >>> Hashtable - <key, value> <<< */
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("k1", 1); map.put("k2", 2); map.put("k3", 3);
        System.out.println(map); // {k1=1, k2=2, k3=3}
        
        System.out.println(map.containsKey("k1")); // true
        System.out.println(map.containsValue(2)); // true
        System.out.println(map.get("k2")); // 2
        
        System.out.println(map.entrySet()); // [k1=1, k2=2, k3=3]
        System.out.println(map.keySet()); // [k1, k2, k3]
        System.out.println(map.values()); // [1, 2, 3]
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        /*
        k1 -> 1
        k2 -> 2
        k3 -> 3
        */
        
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        /*
        k1 -> 1
        k2 -> 2
        k3 -> 3
        */
    }

    private static void treeSet() {
        /* >>> Balanced BST - RedBlackTree <<< */
        Set<String> bst = new TreeSet<String>();
        bst.add("b"); bst.add("a"); bst.add("c");
        System.out.println(bst); // [a, b, c]
        
        for (String st : bst) {
            System.out.print(st + " ");
        }
        System.out.println();
        // a b c 
        
        System.out.println(bst.contains("a")); // true
        
        boolean isRemoved = bst.remove("a");
        System.out.println(isRemoved); // true
        System.out.println(bst); // [b, c]
        
        bst.clear();
        System.out.println(bst); // []
    }

    private static void hashSet() {
        /* >>> Hashtable <<< */
        Set<String> set = new HashSet<String>();
        set.add("abc"); set.add("ghi"); set.add("def");
        System.out.println(set); // [abc, def, ghi]
        
        for (String st : set) {
            System.out.print(st + " ");
        }
        System.out.println();
        // abc def ghi 
        
        System.out.println(set.contains("abc")); // true
        
        boolean isRemoved = set.remove("abc");
        System.out.println(isRemoved); // true
        System.out.println(set); // [def, ghi]
        
        set.clear();
        System.out.println(set); // []
    }

    private static void stack() {
        /* >>> Stack <<< */
        
        // Stack<Integer> s = new Stack<Integer>(); // avoid this
        
        Deque<Integer> s = new ArrayDeque<Integer>();
        
        // Deque<Integer> s = new LinkedList<Integer>(); // we can also use this
        
        s.push(1); s.push(2); s.push(3); 
        System.out.println(s); // [3, 2, 1]
        // using 
        // Stack<Integer> s = new Stack<Integer>();
        // would have printed [1, 2, 3]
        
        int e = s.peek();
        System.out.println(e); // 3
        System.out.println(s); // [3, 2, 1]
        
        e = s.pop();
        System.out.println(e); // 3
        System.out.println(s); // [2, 1]
        
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
        // 2 1
    }

    private static void queue() {
        /* >>> Queue <<< */
        // Array based implementation of queue
        // Note 1: ArrayDeque implements Deque, Deque implements Queue
        // Note 2: ArrayDeque implementation of Queue does not allow null insertion
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.add(1); q.add(2); q.add(3);
        System.out.println(q); // [1, 2, 3]
        
        boolean b = q.contains(2); 
        System.out.println(b); // true
        
        int f = q.peek();
        System.out.println(f); // 1
        System.out.println(q); // [1, 2, 3]
        
        f = q.poll();
        System.out.println(f); // 1
        System.out.println(q); // [2, 3]
        
        // q.add(null); // this will throw NPE
        
        // LinkedList based implementation of queue
        // Note 1: LinkedList implements Deque, Deque implements Queue
        // Note 2: LinkedList implementation of Queue allows null insertion
        Deque<Integer> q2 = new LinkedList<Integer>();
        q2.add(1); q2.add(2); q2.add(3); q2.add(null); 
        System.out.println(q2); // [1, 2, 3, null]
        
        b = q2.contains(2);
        System.out.println(b); // true
        
        f = q2.peek();
        System.out.println(f); // 1
        System.out.println(q2); // [1, 2, 3, null]
        
        f = q2.poll();
        System.out.println(f); // 1
        System.out.println(q2); // [2, 3, null]
        
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + " ");
        }
        System.out.println();
        // 2 3 null 
    }

    private static void linkedList() {
        /* >>> LinkedList <<< */
        LinkedList<Integer> ll = new  LinkedList<Integer>();
        ll.add(1); ll.addFirst(2); ll.addLast(3); ll.addLast(5); 
        ll.add(1, 4); // adds 4 at index 1
        
        for (int i = 0; i < ll.size(); ++i)
            System.out.print(ll.get(i) + " ");
        System.out.println();
        // 2 4 1 3 5 
        
        for (Integer n : ll)
            System.out.print(n + " ");
        System.out.println();
        // 2 4 1 3 5 
        
        Iterator<Integer> itr = ll.iterator();
        while (itr.hasNext()) {
            int e = itr.next();
            System.out.print(e + " ");
            if (e == 1) itr.remove();
        }
        System.out.println();
        // 2 4 1 3 5 
        
        System.out.println(ll); // [2, 4, 3, 5]
        
        int e = ll.remove(); // removes and returns first element
        System.out.println(e); // 2
        System.out.println(ll); // [4, 3, 5]
        // ll.removeFirst() does the same
        
        e = ll.remove(1); // removes and returns element at index 1
        System.out.println(e); // 3
        System.out.println(ll); // [4, 5]
        
        e = ll.removeLast();
        System.out.println(e); // 5
        System.out.println(ll); // [4]
        
        // removes first occurrence of given object.
        // need to call for Integer object instead of int,
        // because of overloaded method for removal by index
        boolean isRemoved = ll.remove(Integer.valueOf(1));
        System.out.println(isRemoved); // false
                                                           
        isRemoved = ll.removeFirstOccurrence(2);
        System.out.println(isRemoved); // false
        
        isRemoved = ll.removeLastOccurrence(3);
        System.out.println(isRemoved); // false
        
        Collections.reverse(ll);
    }

    private static void dynamicArray() {
        /* >>> Dynamic Array <<< */
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1); al.add(2); al.add(3);
        al.add(1, 4); // add 4 at index 1
        
        for (int i = 0; i < al.size(); ++i)
            System.out.print(al.get(i) + " ");
        System.out.println();
        // 1 4 2 3 
        
        for (Integer n : al)
            System.out.print(n + " ");
        System.out.println();
        // 1 4 2 3 
        
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            int e = itr.next();
            System.out.print(e + " ");
            if (e == 1) itr.remove();
        }
        System.out.println();
        // 1 4 2 3
        
        System.out.println(al); // [4, 2, 3]
        
        Collections.sort(al);
        System.out.println(al); // [2, 3, 4]
        
        Collections.sort(al, new Comp());
        System.out.println(al); // [4, 3, 2]
    }

    private static void array() {
        /* >>> Array <<< */
        Integer[] a = {6, 4, 5, 2, 3, 9};
        Arrays.sort(a); // sorts in ascending order
        System.out.println(Arrays.toString(a)); // [2, 3, 4, 5, 6, 9]
        
        Arrays.sort(a, new Comp()); // sorts in descending order
        System.out.println(Arrays.toString(a)); // [9, 6, 5, 4, 3, 2]
    }

}

class Comp implements Comparator<Integer> {

    @Override
    public int compare(Integer lhs, Integer rhs) {
        // to sort in descending order
        return rhs - lhs;
    }
    
}
