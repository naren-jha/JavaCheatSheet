package com.njha;

import java.util.regex.Pattern;

public class IsStringNumber {
    
    public static void main(String[] args) {
        
        System.out.println(isNumeric2("22")); // true
        System.out.println(isNumeric2("5.05")); // true
        System.out.println(isNumeric2("-200")); // true
        System.out.println(isNumeric2("   22   ")); // true
        System.out.println(isNumeric2("null")); // false
        System.out.println(isNumeric2("abc")); // false
        System.out.println(isNumeric2("")); // false
        
        
        System.out.println(isNumeric("22")); // true
        System.out.println(isNumeric("5.05")); // true
        System.out.println(isNumeric("-200")); // true
        System.out.println(isNumeric("   22   ")); // false
        System.out.println(isNumeric("null")); // false
        System.out.println(isNumeric("abc")); // false
        System.out.println(isNumeric("")); // false
       
        
        System.out.println(isPositiveInteger("22")); // true
        System.out.println(isPositiveInteger("5.05")); // false
        System.out.println(isPositiveInteger("-200")); // false
        System.out.println(isPositiveInteger("   22   ")); // false
        System.out.println(isPositiveInteger("null")); // false
        System.out.println(isPositiveInteger("abc")); // false
        System.out.println(isPositiveInteger("")); // false
        
        System.out.println(isInteger("22")); // true
        System.out.println(isInteger("5.05")); // false
        System.out.println(isInteger("-200")); // true
        System.out.println(isInteger("   22   ")); // false
        System.out.println(isInteger("null")); // false
        System.out.println(isInteger("abc")); // false
        System.out.println(isInteger("")); // false
    }
    
    // Using exception - Not good for performance
    // If you're calling this function a lot, and you expect many of the checks 
    // to fail due to not being a number, then performance of this mechanism will 
    // not be great, since you're relying upon exceptions being thrown for each 
    // failure, which is a fairly expensive operation.
    // An alternative approach may be to use a regular expression.
    private static boolean isNumeric2(String strNum) {
        if (strNum == null) return false;
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    /*
    -? : this part identifies if the given number is negative, the dash “–” searches for dash literally and the question mark “?” marks its presence as an optional one
    \d+ : this searches for one or more digits
    (\.\d+)? : this part of regex is to identify float numbers. Here we're searching for one or more digits followed by a period. The question mark, in the end, signifies that this complete group is optional
    */
    private static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(strNum).matches();
    }
    
    private static boolean isPositiveInteger(String strNum) {
        if (strNum == null) return false;
        Pattern pattern = Pattern.compile("\\d+");
        return pattern.matcher(strNum).matches();
    }
    
    private static boolean isInteger(String strNum) {
        if (strNum == null) return false;
        Pattern pattern = Pattern.compile("-?\\d+");
        return pattern.matcher(strNum).matches();
    }

}
