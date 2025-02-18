package string;

import java.util.HashSet;

public class StringUniqueAndReverse {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String sample = "Hello World";
        System.out.println("Reversed: " + reverseString(sample));
    }
    /*
      asci or unicode
     if its not asci we need to increse storage size
     asci 128
    */

    //unicode
    public static boolean isUniqueChars(String str) {
            if (str.length() > 128) return false;

            HashSet<Character> charSet = new HashSet<>();
            for (char c : str.toLowerCase().toCharArray()) { // Convert to lowercase
                if (!charSet.add(c)) {
                    return false; // Duplicate found
                }
            }
            return true;
        }
    //asci
    public boolean isUniqueChars1(String str) {
        if (str.length() > 128) return false; // Optimization for ASCII limit

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); // Get ASCII value of character
            if (char_set[val]) { // If already seen, return false
                return false;
            }
            char_set[val] = true;
        }
        return true; // All characters are unique
    }
    //lower case
    public boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a'; // Get position relative to 'a'
            if ((checker & (1 << val)) > 0) { // Check if bit is already set
                return false;
            }
            checker |= (1 << val); // Set the bit
        }
        return true;
    }



}
