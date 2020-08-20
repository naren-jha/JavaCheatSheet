package com.njha;

public class BitTwiddling {

    public static void main(String[] args) {
        testNextPowerOfTwo();
        
        testIsPowOfTwo();
        
        System.out.println(Integer.toBinaryString(4));
    }

    private static void testIsPowOfTwo() {
        System.out.println(isPowOfTwo(8)); // true
        System.out.println(isPowOfTwo(7)); // false
        System.out.println(isPowOfTwo(5)); // false
        System.out.println(isPowOfTwo(4)); // true
    }

    private static void testNextPowerOfTwo() {
        System.out.println(nextPowerOfTwo(4)); // 4
        System.out.println(nextPowerOfTwo(5)); // 8
        System.out.println(nextPowerOfTwo(7)); // 8
        System.out.println(nextPowerOfTwo(8)); // 8
        System.out.println(nextPowerOfTwo(9)); // 16
    }
    
    // Calculates next power of two for given n, is = 2^ceil(lgn))
    // Equivalent to: Math.pow(2, (int) Math.ceil(Math.log(n) / Math.log(2)));
    public static int nextPowerOfTwo(int n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n |= n >> 32;
        n++;
        return n;
    }
    
    public static boolean isPowOfTwo(int n) {
        if (n == 0) return false;
        return (n & (n - 1)) == 0;
    }

}
