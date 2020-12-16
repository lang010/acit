/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * algorithms
 * Easy (58.46%)
 * Total Accepted:    69.6K
 * Total Submissions: 119K
 * Testcase Example:  '"ab-cd"'
 *
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their
 * positions.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "ab-cd"
 * Output: "dc-ba"
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int l = 0, r = S.length()-1;
        while (l < r) {
            while (l < r && check(arr[l]))
                l++;
            while (l < r && check(arr[r]))
                r--;
            if (l < r) {
                char c = arr[l];
                arr[l] = arr[r];
                arr[r] = c;
            }
            l++;
            r--;
        }
        return new String(arr);
    }
    
    boolean check(char c) {
        if (c >= 'a' && c <= 'z'
           || c >= 'A' && c <= 'Z')
            return false;
        return true;
    }
}
