package string;

public class StringCompression {

    public String compressBad(String str) {
        String mystr = "";
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) { // Found repeated character
                count++;
            } else {
                mystr += last + "" + count; // Append character and count
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr += last + "" + count; // Append last set of characters

        return mystr.length() < str.length() ? mystr : str;
    }
    public String compressBetter(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str; // Return original if compression is not beneficial
        }

        StringBuilder mystr = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        mystr.append(last);
        mystr.append(count);

        return mystr.toString();
    }
    public String compressAlternate(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }

        index = setChar(array, last, index, count);
        return String.valueOf(array);
    }

    private int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        char[] cnt = String.valueOf(count).toCharArray();
        for (char ch : cnt) {
            array[index] = ch;
            index++;
        }

        return index;
    }
    int countCompression(String str) {
        if (str == null || str.isEmpty()) return 0; // Edge case: Empty or null string

        char last = str.charAt(0); // Store the first character
        int size = 0; // Track compressed string length
        int count = 1; // Count occurrences of each character

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++; // Increment count if the same character repeats
            } else {
                size += 1 + String.valueOf(count).length(); // Add character + count length
                last = str.charAt(i); // Move to next character
                count = 1; // Reset count
            }
        }
        size += 1 + String.valueOf(count).length(); // Include the last character set

        return size; // Return the length of the compressed string
    }


}
