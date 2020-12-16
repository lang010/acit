/*
 * @lc app=leetcode id=1131 lang=java
 *
 * [1131] Maximum of Absolute Value Expression
 *
 * https://leetcode.com/problems/maximum-of-absolute-value-expression/description/
 *
 * algorithms
 * Medium (52.17%)
 * Total Accepted:    10.2K
 * Total Submissions: 19.6K
 * Testcase Example:  '[1,2,3,4]\n[-1,4,5,6]'
 *
 * Given two arrays of integers with equal lengths, return the maximum value
 * of:
 * 
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * 
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 * 
 * 
 */
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        int n = arr1.length;
        int[] P = {-1, 1};
        int[] Q = {-1, 1};
        for (int p : P)
            for (int q : Q) {
                int min = arr1[0] * p + arr2[0] * q;
                for (int i = 1; i < n; i++) {
                    int v = arr1[i] * p + arr2[i] * q + i;
                    min = Math.min(min, v);
                    ans = Math.max(ans, v - min);
                }
            }
        
        return ans;
    }
}
