/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 *
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/
 *
 * algorithms
 * Easy (49.77%)
 * Total Accepted:    40.9K
 * Total Submissions: 82.2K
 * Testcase Example:  '[0,2,1,-6,6,-7,9,1,2,0,1]'
 *
 * Given an array A of integers, return true if and only if we can partition
 * the array into three non-empty parts with equal sums.
 * 
 * Formally, we can partition the array if we can find indexes i+1 < j with
 * (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1]
 * + ... + A[A.length - 1])
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * 
 * 
 */
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++)
            A[i] += A[i-1];
        if (A[n-1]%3 != 0)
            return false;
        boolean first = false;
        int val = A[n-1]/3;
        for (int i = 0; i < n-1; i++) {
            if (!first && val == A[i])
                first = true;
            else if (first && val*2 == A[i])
                return true;
        }
        return false;
    }
}
