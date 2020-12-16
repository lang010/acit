/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (48.86%)
 * Total Accepted:    100.9K
 * Total Submissions: 206.5K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int st = 0;
        while (st < arr.length) {
            reverse(arr, st, st+k-1);
            st += k * 2;
        }
        return new String(arr);
    }
    
    void reverse(char[] arr, int l, int r) {
        r = Math.min(r, arr.length-1);
        while (l < r) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++;
            r--;
        }
    }
}
