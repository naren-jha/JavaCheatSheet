package com.njha;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringCheatSheet {

    public static void main(String[] args) {
        /* BUILD A STRING OF DELIMITED ITEMS FROM LIST OF INTEGERS */
        List<Integer> l = new ArrayList<Integer>();
        l.add(1); l.add(2); l.add(3); l.add(4);
        
        StringJoiner joiner = new StringJoiner(", ");
        for (Integer cs: l) {
            joiner.add(cs.toString());
        }
        System.out.println(joiner.toString()); // 1, 2, 3, 4
        
        /* BUILD A STRING OF DELIMITED ITEMS FROM LIST OF STRINGS */
        List<String> sl = new ArrayList<String>();
        sl.add("ab"); sl.add("cd"); sl.add("ef"); sl.add("gh");
        String resultString = String.join(", ", sl);
        System.out.println(resultString); // ab, cd, ef, gh

    }
    
}
