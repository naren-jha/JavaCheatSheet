package com.njha;

import java.math.BigInteger;

public class BigIntegerCheatSheet {

    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789987654321");
        BigInteger bi2 = BigInteger.valueOf(23456);
        
        // ADDITION
        BigInteger res = bi1.add(bi2);
        System.out.println(res); // 123456789987677777
        
        // SUBTRACTION
        res = bi1.subtract(bi2);
        System.out.println(res); // 123456789987630865
        
        // MULTIPLICATION
        res = bi1.multiply(BigInteger.TWO);
        System.out.println(res); // 246913579975308642
        
        // DIVISION
        res = bi1.divide(BigInteger.TWO);
        System.out.println(res); // 61728394993827160
        
        // REMAINDER
        res = bi2.remainder(bi1);
        System.out.println(res); // 23456
        
        // differs from remainder() in that it always returns a non-negative BigInteger
        res = bi2.mod(bi1);
        System.out.println(res); // 23456

        if (bi1.remainder(BigInteger.TWO) != BigInteger.ZERO) {
            // To increment a variable, you also need to assign it back to the same object
            // because BigInteger is immutable, and therefore every attempt to modify
            // an existing object results in creation of an entirely new object
            bi1 = bi1.add(BigInteger.ONE);
        }
        
        res = bi1.max(bi2);
        System.out.println(res); // 123456789987654322
        
        res = bi1.min(bi2);
        System.out.println(res); // 23456
        
        res = bi1.abs();
        System.out.println(res); // 123456789987654322
        
        res = bi1.gcd(bi2);
        System.out.println(res); // 2
        
        res = bi1.negate();
        System.out.println(res); // -123456789987654322
        
        res = bi1.sqrt();
        System.out.println(res); // 351364184
        
        System.out.println(bi1.isProbablePrime(32)); // false
        System.out.println(bi1.modInverse(BigInteger.ONE)); // 0
    }

}
