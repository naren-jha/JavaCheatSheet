package com.njha;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class CollectionsCheatSheet {

    public static void main(String[] args) throws Exception {
        /* >>> Array <<< */
        Integer[] a = {6, 4, 5, 2, 3, 9};
        Arrays.sort(a); // sorts in ascending order
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new Comp()); // sorts in descending order
        System.out.println(Arrays.toString(a));
        
        /* >>> Dynamic Array <<< */
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1); al.add(2); al.add(3);
        al.add(1, 4); // add 4 at index 1
        
        for (int i = 0; i < al.size(); ++i)
            System.out.print(al.get(i) + " ");
        System.out.println();
        
        for (Integer n : al)
            System.out.print(n + " ");
        System.out.println();
        
        Iterator<Integer> alItr = al.iterator();
        while (alItr.hasNext()) {
            int e = alItr.next();
            System.out.print(e + " ");
            if (e == 1) alItr.remove();
        }
        System.out.println();
        
        Collections.sort(al, new Comp());
        System.out.println(al); // [4, 3, 2]
        
        /* >>> LinkedList <<< */
        LinkedList<Integer> ll = new  LinkedList<Integer>();
        ll.add(1); ll.addFirst(2); ll.addLast(3); ll.addLast(5); 
        ll.add(1, 4); // adds 4 at index 1
        
        for (int i = 0; i < ll.size(); ++i)
            System.out.print(ll.get(i) + " ");
        System.out.println();
        
        for (Integer n : ll)
            System.out.print(n + " ");
        System.out.println();
        
        Iterator<Integer> itr = ll.iterator();
        while (itr.hasNext()) {
            int e = itr.next();
            System.out.print(e + " ");
            if (e == 1) itr.remove();
        }
        System.out.println();
        
        int e = ll.remove(); // removes and returns first element
        e = ll.remove(1); // removes and returns element at index 1
        e = ll.removeFirst(); e = ll.removeLast();
        
        // removes first occurrence of given object
        boolean isRemoved = ll.remove(Integer.valueOf(1)); // need to call for Integer object instead of int
                                                           // because of overloaded method for removal by index
        isRemoved = ll.removeFirstOccurrence(2);
        isRemoved = ll.removeLastOccurrence(3);
        
        /* >>> Queue <<< */
        // Array based implementation of queue
        // Note 1: ArrayDeque implements Deque, Deque implements Queue
        // Note 2: ArrayDeque implementation of Queue does not allow null insertion
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(1); q.add(2); q.add(3); 
        boolean b = q.contains(2); int f = q.peek(); f = q.poll();
        // q.add(null); // this will throw NPE
        System.out.println(q); // [2, 3]
        
        // LinkedList based implementation of queue
        // Note 1: LinkedList implements Deque, Deque implements Queue
        // Note 2: LinkedList implementation of Queue allows null insertion
        Queue<Integer> q2 = new LinkedList<Integer>();
        q2.add(1); q2.add(2); q2.add(3); q2.add(null); 
        b = q2.contains(2); f = q2.peek(); f = q2.poll();
        System.out.println(q2); // [2, 3, null]
        
        while (!q2.isEmpty()) {
            System.out.print(q2.poll() + " ");
        }
        System.out.println();
        
        /* >>> Stack <<< */
        Stack<Integer> s = new Stack<Integer>();
        s.push(1); s.push(2); s.push(3); 
        e = s.peek(); e = s.pop();
        System.out.println(s); // [1, 2]
        
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        } // 2 1
        System.out.println();
        
        /* >>> Hashtable <<< */
        Set<String> set = new HashSet<String>();
        set.add("abc"); set.add("ghi"); set.add("def");
        System.out.println(set); // [abc, def, ghi]
        for (String st : set) {
            System.out.print(st + " ");
        }
        System.out.println();
        
        System.out.println(set.contains("abc"));
        isRemoved = set.remove("abc");
        System.out.println(isRemoved); // true
        set.clear();
        
        /* >>> Balanced BST - RedBlackTree <<< */
        Set<String> bst = new TreeSet<String>();
        bst.add("b"); bst.add("a"); bst.add("c");
        System.out.println(bst); // [a, b, c]
        for (String st : bst) {
            System.out.print(st + " ");
        }
        System.out.println();
        
        System.out.println(bst.contains("a"));
        isRemoved = bst.remove("a");
        bst.clear();
        
        /* >>> Hashtable - <key, value> <<< */
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("k1", 1); map.put("k2", 2); map.put("k3", 3);
        System.out.println(map.containsKey("k1"));
        System.out.println(map.containsValue(2));
        System.out.println(map.get("k2"));
        
        System.out.println(map.entrySet()); // [k1=1, k2=2, k3=3]
        System.out.println(map.keySet()); // [k1, k2, k3]
        System.out.println(map.values()); // [1, 2, 3]
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        
        /* >>> Balanced BST - RedBlackTree - <key, value> <<< */
        Map<String, Integer> bstMap = new HashMap<String, Integer>();
        bstMap.put("k3", 3); bstMap.put("k1", 1); bstMap.put("k2", 2);
        System.out.println(bstMap.containsKey("k1"));
        System.out.println(bstMap.containsValue(2));
        System.out.println(bstMap.get("k2"));
        
        System.out.println(bstMap.entrySet()); // [k1=1, k2=2, k3=3]
        System.out.println(bstMap.keySet()); // [k1, k2, k3]
        System.out.println(bstMap.values()); // [1, 2, 3]
        
        for (Map.Entry<String, Integer> entry : bstMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for (String key : bstMap.keySet()) {
            System.out.println(key + " -> " + bstMap.get(key));
        }
    }

}

class Comp implements Comparator<Integer> {

    @Override
    public int compare(Integer lhs, Integer rhs) {
        // to sort in descending order
        return rhs - lhs;
    }
    
}
