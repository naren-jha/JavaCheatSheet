package com.njha;

import java.math.BigInteger;

public class BigIntegerCheatSheet {

    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("123456789987654321");
        BigInteger bi2 = BigInteger.valueOf(23456);
        
        BigInteger res = bi1.add(bi2);
        res = bi1.subtract(bi2);
        res = bi1.multiply(BigInteger.TWO);
        res = bi1.divide(BigInteger.TWO);
        
        res = bi1.remainder(BigInteger.TWO);
        // differs from remainder() in that it always returns a non-negative BigInteger
        res = bi1.mod(BigInteger.TWO);

        if (bi1.remainder(BigInteger.TWO) != BigInteger.ZERO) {
            // To increment value by, you also need to assign it back to the same object
            // because BigInteger is immutable, and therefore every attempt to modify
            // an existing object results in creation of an entirely new object
            bi1 = bi1.add(BigInteger.ONE);
        }
        
        res = bi1.max(bi2); res = bi1.min(bi2);
        res = bi1.abs(); res = bi1.gcd(bi2); 
        res = bi1.negate(); res = bi1.sqrt();
        
        System.out.println(bi1.isProbablePrime(32));
        System.out.println(bi1.modInverse(BigInteger.ONE));
    }

}
