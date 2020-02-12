/*
@Author: Kareem El Assad
@Date: 2/11/2020
*/

import java.util.List;

public class countStringInText {
    
    /*
     * Returns the lowest index at which substring pattern begins in text (or else
     * -1).
     */

    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index
            // within text
            int k = 0; // k is index into pattern
            while (k < m && text.get(i + k) == pattern.get(k))
                // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }
    /* 
    */

    public static void main(String[] args) {

    }
}
