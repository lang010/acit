/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (44.75%)
 * Total Accepted:    250.6K
 * Total Submissions: 559.9K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * 
 * Input: "hello"
 * Output: "holle"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * 
 * 
 */
class Solution {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length-1;
        while (l < r) {
            while (l < r && !isVowel(chs[l]))
                l++;
            while (l < r && !isVowel(chs[r]))
                r--;
            if (l < r) {
                char c = chs[l];
                chs[l] = chs[r];
                chs[r] = c;
                l++;
                r--;
            }
        }
        return new String(chs);
    }
    
    boolean isVowel(char c) {
        switch (c) {
            case 'A':
            case 'a':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'O':
            case 'o':
            case 'U':
            case 'u':
                return true;
        }
        return false;
    }
}
