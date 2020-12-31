package com.njha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtilityMethods {

    public static void main(String[] args) {
        copyOf();
        
        asList();
        
        binarySearch();
        
        equals();
        
        mismatch();
        
        minMaxSumUsingStream();
        
        // OTHER USEFUL METHODS
        
        // Arrays.hashCode(a)
        // Arrays.deepHashCode(a3)
        
        // Arrays.toString(a)
        // Arrays.deepToString(a3)
        
        // Arrays.fill(a, -1)
        // Arrays.sort(a)
        // Arrays.sort(a, from, to)
        // Arrays.sort(a, comparator)
        // Arrays.sort(a, from, to, comparator)
        
        // System.arraycopy(src, srcPos, dest, destPos, numOfElements);
    }

    private static void minMaxSumUsingStream() {
        int[] a = {10, 20, 30, 40, 50};
        int sum = Arrays.stream(a).sum();
        System.out.println(sum); // 150
        
        int min = Arrays.stream(a).min().getAsInt();
        System.out.println(min); // 10
        
        int max = Arrays.stream(a).max().getAsInt();
        System.out.println(max); // 50
        
        // 2D array
        int[][] b = { {10, 20}, {5, 7}, {30}};
        sum = Arrays.stream(b).flatMapToInt(Arrays::stream).sum();
        System.out.println(sum); // 72
        
        min = Arrays.stream(b).flatMapToInt(Arrays::stream).min().getAsInt();
        System.out.println(min); // 5
        
        max = Arrays.stream(b).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println(max); // 30
    }

    private static void mismatch() {
        // Find the index of the first unmatched element between the two arrays
        int[] a = {10, 20, 30, 40, 50};
        int[] b = {10, 80, 30, 40, 50};
        int index = Arrays.mismatch(a, b);
        System.out.println(index); // 1
        
        b = new int[]{10, 20, 30, 40, 50};
        index = Arrays.mismatch(a, b);
        System.out.println(index); // -1
    }

    private static void equals() {
        int[] a = {10, 20, 30, 40, 50};
        int[] a2 = {10, 20, 30, 40, 50};
        
        // two arrays are equal if they contain the same elements in the same order
        boolean areEqual = Arrays.equals(a, a2);
        System.out.println(areEqual); // true
        
        a2 = new int[]{10, 20, 30, 50, 40};
        areEqual = Arrays.equals(a, a2);
        System.out.println(areEqual); // false
        
        a = null;
        areEqual = Arrays.equals(a, a2);
        System.out.println(areEqual); // false
        
        a = null;
        a2 = null;
        areEqual = Arrays.equals(a, a2);
        System.out.println(areEqual); // true
        
        // multi-dimensional array
        int[][] a3 = {
                        {10, 20, 30, 40, 50},
                        {100, 200, 300, 400, 500}
                     };
        
        int[][] a4 = {
                        {10, 20, 30, 40, 50},
                        {100, 200, 300, 400, 500}
                     };
        
        areEqual = Arrays.equals(a3, a4);
        System.out.println(areEqual); // false
        
        areEqual = Arrays.deepEquals(a3, a4);
        System.out.println(areEqual); // true
        
        a4 = new int[][] {
                            {10, 20, 30, 40, 50},
                            {900, 200, 300, 400, 500}
                         };
                         
        areEqual = Arrays.deepEquals(a3, a4);
        System.out.println(areEqual); // false
    }

    private static void binarySearch() {
        int[] a = {10, 20, 30, 40, 50}; // must be sorted
        int index = Arrays.binarySearch(a, 20);
        System.out.println(index); // 1
        
        index = Arrays.binarySearch(a, 90);
        System.out.println(index); // -6
        // index = insertion point for element 90
        
        index = Arrays.binarySearch(a, 5);
        System.out.println(index); // -1
        
        index = Arrays.binarySearch(a, 25);
        System.out.println(index); // -3
        
        // Binary search in range
        // search for element 40 in the index range [1, 4)
        index = Arrays.binarySearch(a, 1, 4, 40);
        System.out.println(index); // 3
        
        // 'from' index is inclusive, and 'to' index is exclusive
        index = Arrays.binarySearch(a, 1, 3, 40);
        System.out.println(index); // -4
    }

    private static void asList() {
        Integer[] a = {1, 2, 3};
        List<Integer> l = Arrays.asList(a);
        System.out.println(l); // [1, 2, 3]
        
        l = Arrays.asList(10, 20, 30);
        System.out.println(l); // [10, 20, 30]
        
        // https://stackoverflow.com/questions/16748030/difference-between-arrays-aslistarray-and-new-arraylistintegerarrays-aslist
        
        // l.add(4); 
        // above will throw java.lang.UnsupportedOperationException
        // because Arrays.asList(a) does not return java.util.ArrayList
        
        // To get a standard java.util.ArrayList where 
        // adding or removing elements are allowed, do following
        l = new ArrayList<Integer>(Arrays.asList(a));
        l.add(4);
        System.out.println(l); // [1, 2, 3, 4]
    }

    private static void copyOf() {
        int[] a = {1, 2, 3};
        System.out.println(Arrays.toString(a)); // [1, 2, 3]
        
        // creating a new array from old array and doubling the length
        int[] a2 = Arrays.copyOf(a, 2*a.length);
        System.out.println(Arrays.toString(a)); // [1, 2, 3]
        System.out.println(Arrays.toString(a2)); // [1, 2, 3, 0, 0, 0]
        
        // doubling the length of an existing array
        a = Arrays.copyOf(a, 2*a.length);
        System.out.println(Arrays.toString(a)); // [1, 2, 3, 0, 0, 0]
        
        // create a copy of the index range [1, 3)
        a2 = Arrays.copyOfRange(a, 1, 3);
        System.out.println(Arrays.toString(a2)); // [2, 3]
    }
}
