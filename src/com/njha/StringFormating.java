package com.njha;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StringFormating {

    public static void main(String[] args) {
        simple();
        
        aurgument();
        
        string();
        
        integer();
        
        floatingPoint();
        
        integerToBinaryString();
        
        dateTime();
    }

    private static void dateTime() {
        /*
        %tA     Full name of the day of the week, e.g. "Sunday", "Monday"
        %ta     Abbreviated name of the week day e.g. "Sun", "Mon", etc.
        %tB     Full name of the month e.g. "January", "February", etc.
        %tb     Abbreviated month name e.g. "Jan", "Feb", etc.
        %tC     Century part of year formatted with two digits e.g. "00" through "99".
        %tc     Date and time formatted with "%ta %tb %td %tT %tZ %tY" e.g. "Fri Feb 17 07:45:42 PST 2017"
        %tD     Date formatted as "%tm/%td/%ty"
        %td     Day of the month formatted with two digits. e.g. "01" to "31".
        %te     Day of the month formatted without a leading 0 e.g. "1" to "31".
        %tF     ISO 8601 formatted date with "%tY-%tm-%td".
        %tH     Hour of the day for the 24-hour clock e.g. "00" to "23".
        %th     Same as %tb.
        %tI     Hour of the day for the 12-hour clock e.g. "01" – "12".
        %tj     Day of the year formatted with leading 0s e.g. "001" to "366".
        %tk     Hour of the day for the 24 hour clock without a leading 0 e.g. "0" to "23".
        %tl     Hour of the day for the 12-hour click without a leading 0 e.g. "1" to "12".
        %tM     Minute within the hour formatted a leading 0 e.g. "00" to "59".
        %tm     Month formatted with a leading 0 e.g. "01" to "12".
        %tN     Nanosecond formatted with 9 digits and leading 0s e.g. "000000000" to "999999999".
        %tp     Locale specific "am" or "pm" marker.
        %tQ     Milliseconds since epoch Jan 1 , 1970 00:00:00 UTC.
        %tR     Time formatted as 24-hours e.g. "%tH:%tM".
        %tr     Time formatted as 12-hours e.g. "%tI:%tM:%tS %Tp".
        %tS     Seconds within the minute formatted with 2 digits e.g. "00" to "60". "60" is required to support leap seconds.
        %ts     Seconds since the epoch Jan 1, 1970 00:00:00 UTC.
        %tT     Time formatted as 24-hours e.g. "%tH:%tM:%tS".
        %tY     Year formatted with 4 digits e.g. "0000" to "9999".
        %ty     Year formatted with 2 digits e.g. "00" to "99".
        %tZ     Time zone abbreviation. e.g. "UTC", "PST", etc.
        %tz     Time Zone Offset from GMT e.g. "-0800"
       */
        
        String longDate = String.format("Today is %tA %<tB %<td, %<tY", new Date());
        System.out.println(longDate); // Today is Saturday August 01, 2020
        
        // day - %td
        System.out.println(String.format("%td", new Date())); // 01
        
        // month - %tm
        System.out.println(String.format("%tm", new Date())); // 08
        
        // year - %tY
        System.out.println(String.format("%tY", new Date())); // 2020
        
        // short year - %ty
        System.out.println(String.format("%ty", new Date())); // 20
        
        // date in default format: mm/dd/yy
        System.out.println(String.format("%tD", new Date())); // 08/01/20
        
        // time in default format: hh/mm/ss
        System.out.println(String.format("%tT", new Date())); // 13:11:53
        
        System.out.println(String.format("%tc", new Date())); // Sat Aug 01 13:11:53 IST 2020
        
        System.out.println(String.format("%tF", new Date())); // 2020-08-01
        
        System.out.println(String.format("%tr", new Date())); // 01:27:30 PM
        
        System.out.println(String.format("%tz", new Date())); // +0530
    }

    private static void integerToBinaryString() {
        // 1100100
        String result1 = String.format("%s", Integer.toBinaryString(100));

        // 00000000000000000000000001100100
        String result2 = String.format("%32s", Integer.toBinaryString(100)).replace(" ", "0");

        // 00000000000000011110001001000000
        String result3 = String.format("%32s", Integer.toBinaryString(123456)).replace(" ", "0");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private static void floatingPoint() {
        double pi = Math.PI;

        // default
        String result1 = String.format("%f", pi); // 3.141593

        // 2 decimal points
        String result2 = String.format("%.2f", pi); // 3.14

        String result3 = String.format("%e", pi); // 3.141593e+00

        String result4 = String.format("%a", pi); // 0x1.921fb54442d18p1

        // right
        String result5 = String.format("|%20f|", pi); // |            3.141593|

        // left
        String result6 = String.format("|%-20f|", pi); // |3.141593            |
        
        String result7 = String.format("|%20.2f|", pi); // |                3.14|

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        
        float k = 1000f;
        float m = 1000000f;
        float t = 1000000000f;
         
        System.out.format("One thousand: %.1e %n", k); // One thousand: 1.0e+03
        System.out.format("One million: %.1E %n", m); // One million: 1.0E+06
        System.out.format("One billion: %.2g %n", t); // One billion: 1.0e+09 
        // g -> decimal number, possibly in scientific notation depending on the precision and value
    }

    private static void integer() {
        // default
        String result1 = String.format("|%d|", 100); // |100|

        // this %d has length of 20, format as %20d, pad 20 characters
        // default right-justified
        String result2 = String.format("|%20d|", 100); // |                 100|

        // left-justified
        String result3 = String.format("|%-20d|", 100); // |100                 |

        // left pad with 0
        String result4 = String.format("|%020d|", 100); // |00000000000000000100|

        // prefix with +
        String result5 = String.format("|%+20d|", 100); // |                +100|

        // negative
        String result6 = String.format("|%20d|", -100); // |                -100|

        // octal
        String result7 = String.format("|%20o|", 100); // |                 144|

        // hex
        String result8 = String.format("|%20x|", 30); // |                  1e|

        // prefix 0x with #
        String result9 = String.format("|%#20x|", 30); // |                0x1e|
        
        // locale-specific thousands separator 
        // default: US locale
        String result10 = String.format("|%,d|", 10000000); // prints: |10,000,000|
        
        // locale override
        String result11 = String.format(Locale.FRENCH, "|%,d|", 10000000); // prints: |10 000 000|

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);
        System.out.println(result11);
    }

    private static void string() {
        String input = "Hello World";

        // default
        String result1 = String.format("|%s|", input); // |Hello World|

        // this %s has length of 20, format as %20s, pad 20 characters
        // default right-justified
        String result2 = String.format("|%20s|", "Hello World"); // |         Hello World|

        // left-justified
        String result3 = String.format("|%-20s|", "Hello World"); // |Hello World         |

        // max length = 5
        String result4 = String.format("|%.5s|", "Hello World"); // |Hello|

        // left pad with $
        String result5 = String.format("|%20s|", "Hello World").replace(' ', '$'); // |$$$$$$$$$Hello$World|

        // left pad with $, ignore spaces in string
        String result6 = padLeft("Hello World", 20, "$"); // $$$$$$$$$Hello World

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        
        List<String> listBook = Arrays.asList(
                "Head First Java",
                "Effective Java",
                "The Passionate Programmer",
                "Head First Design Patterns"
            );
         
        for (String book : listBook) {
            System.out.format("%-30s - In Stock%n", book);
        }
        /*
         * Head First Java                - In Stock
         * Effective Java                 - In Stock
         * The Passionate Programmer      - In Stock
         * Head First Design Patterns     - In Stock
         */
        
        String specifiers = "%-30s %-20s %-5.2f%n";
        System.out.format(specifiers, "Head First Java", "Kathy Sierra", 23.99f);
        System.out.format(specifiers, "Thinking in Java", "Bruce Eckel", 25.69f);
        System.out.format(specifiers, "Effective Java", "Joshua Bloch", 27.88f);
        System.out.format(specifiers, "The Passionate Programmer", "Chad Fowler", 41.99f);
        System.out.format(specifiers, "Code Complete", "Steve McConnell", 38.42f);
        /*
        Head First Java                Kathy Sierra         23.99
        Thinking in Java               Bruce Eckel          25.69
        Effective Java                 Joshua Bloch         27.88
        The Passionate Programmer      Chad Fowler          41.99
        Code Complete                  Steve McConnell      38.42
        */
        
        System.out.format("%20s %s %n", "Full Name: ", "John");
        System.out.format("%20s %s %n", "E-mail Address: ", "john@gmail.com");
        System.out.format("%20s %s %n", "City: ", "New York");
        System.out.format("%20s %s %n", "Country: ", "United States");
        /*
                 Full Name:  John 
            E-mail Address:  john@gmail.com 
                      City:  New York 
                   Country:  United States
        */
    }
    
    private static String padLeft(String str, int width, String padWith) {

        String result = "";
        String temp = String.format("%" + width + "s", str);
        if (temp.length() > str.length()) {
            result = temp.substring(0, temp.length() - str.length()).replace(" ", padWith);
        }
        result += str;
        return result;

    }

    private static void aurgument() {
        /*
         * We can reorder the arguments with %{index}${conversion}.
         * 
         * %1$ – first argument
         * %2$ – second argument
         * %3$ – third argument
         * %{index}$ – {index} argument
         */
        String a1 = "hello1";
        String a2 = "hello2";
        Integer a3 = 333;

        String result = String.format("Test: %3$d, %1$s, %1$s, %2$s", a1, a2, a3);
        // Test: 333, hello1, hello1, hello2

        System.out.println(result);
    }

    private static void simple() {
        String result = String.format("%s is %d", "John", 38); // John is 38
        System.out.println(result);

        String result2 = String.format("%d + %d = %d", 1, 1, 1 + 1); // 1 + 1 = 2
        System.out.println(result2);

        String result3 = String.format("%s = %f", "PI", Math.PI); // PI = 3.141593
        String result4 = String.format("%s = %.3f", "PI", Math.PI); // PI = 3.142
        System.out.println(result3);
        System.out.println(result4);
    }
}
