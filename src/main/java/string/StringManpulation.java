package string;

public class StringManpulation {


//Write a method to replace all spaces in a string with "%20". Assume that the string has sufficient space at the end to hold the additional characters, and you are given the "true" length of the string. (In Java, use a character array so you can perform this operation in place

    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength, i;

        // First pass: Count the number of spaces
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        // Compute the new length of the modified string
        newLength = length + spaceCount * 2;
        str[newLength] = '\0'; // End of the new string

        // Second pass: Replace spaces from the end
        for (i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength - 1] = str[i];
                newLength--;
            }
        }
    }

}
