/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 *
 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
 *
 * algorithms
 * Easy (70.07%)
 * Total Accepted:    108.7K
 * Total Submissions: 155.1K
 * Testcase Example:  '[4,2,5,7]'
 *
 * Given an array A of non-negative integers, half of the integers in A are
 * odd, and half of the integers are even.
 * 
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is
 * even, i is even.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been
 * accepted.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int e = 0;
        int o = 1;
        while (true) {
            while (e < A.length && A[e] % 2 == 0) {
                e += 2;
            }
            if (e >= A.length) {
                break;
            }
            while (A[o] % 2 == 1) {
                o += 2;
            }
            int x = A[e];
            A[e] = A[o];
            A[o] = x;
        }
        return A;
    }
}
