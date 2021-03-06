/*
 * @lc app=leetcode id=484 lang=java
 *
 * [484] Find Permutation
 *
 * https://leetcode.com/problems/find-permutation/description/
 *
 * algorithms
 * Medium (64.00%)
 * Total Accepted:    24.1K
 * Total Submissions: 37.6K
 * Testcase Example:  '"DDIIDI"'
 *
 * 
 * By now, you are given a secret signature consisting of character 'D' and
 * 'I'. 'D' represents a decreasing relationship between two numbers, 'I'
 * represents an increasing relationship between two numbers. And our secret
 * signature was constructed by a special integer array, which contains
 * uniquely all the different number from 1 to n (n is the length of the secret
 * signature plus 1). For example, the secret signature "DI" can be constructed
 * by array [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or
 * [2,1,3,4], which are both illegal constructing special string that can't
 * represent the "DI" secret signature.
 * 
 * 
 * 
 * On the other hand, now your job is to find the lexicographically smallest
 * permutation of [1, 2, ... n] could refer to the given secret signature in
 * the input.
 * 
 * 
 * Example 1:
 * 
 * Input: "I"
 * Output: [1,2]
 * Explanation: [1,2] is the only legal initial spectial string can construct
 * secret signature "I", where the number 1 and 2 construct an increasing
 * relationship.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "DI"
 * Output: [2,1,3]
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature
 * "DI", but since we want to find the one with the smallest lexicographical
 * permutation, you need to output [2,1,3]
 * 
 * 
 * 
 * Note:
 * The input string will only contain the character 'D' and 'I'.
 * The length of input string is a positive integer and will not exceed 10,000
 * 
 */
class Solution {
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] ans = new int[n];
        int i = n-2;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c == 'I')
                ans[i+1] = i+2;
            else {
                int len = 1;
                while (i-len >= 0 && c == s.charAt(i-len))
                    len++;
                for (int j = 0; j <= len; j++)
                    ans[i+1-j] = i+2-len+j;
                i -= len;
            }
            i--;
        }
        if (ans[0] == 0)
            ans[0] = 1;
        
        return ans;
    }
}
