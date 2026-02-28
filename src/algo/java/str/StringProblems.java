package algo.java.str;


public class StringProblems {

    /*
    Leet code: https://leetcode.com/problems/reverse-string/
    Submission: https://leetcode.com/problems/reverse-string/submissions/1933229289/

    Write a function that reverses a string. The input string is given as an array of characters
    */
    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        char[] strArray = str.toCharArray();
        for(int index = 0; index < strArray.length / 2; index++){
            char tmp = strArray[index];
            strArray[index] = strArray[strArray.length - index - 1];
            strArray[strArray.length - index - 1] = tmp;
        }
        return new String(strArray);
    }
}
