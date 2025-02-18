package string;

public class Permutations {

//first way
    public String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }
//second way


    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; // Assumption: ASCII character set

        for (char c : s.toCharArray()) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }




}
