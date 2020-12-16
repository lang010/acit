/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 *
 * https://leetcode.com/problems/monotonic-array/description/
 *
 * algorithms
 * Easy (58.03%)
 * Total Accepted:    131.9K
 * Total Submissions: 227.3K
 * Testcase Example:  '[1,2,2,3]'
 *
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 * 
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array
 * A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * 
 * Return true if and only if the given array A is monotonic.
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
 * Input: [1,2,2,3]
 * Output: true
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [6,5,4,4]
 * Output: true
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [1,3,2]
 * Output: false
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: [1,2,4,5]
 * Output: true
 * 
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: [1,1,1]
 * Output: true
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length < 3)
            return true;
        return check(A, 1) || check(A, -1);
    }
    
    boolean check(int[] A, int f) {
        for (int i = 1; i < A.length; i++) {
            if (f > 0 && A[i] >= A[i-1])
                continue;
            if (f < 0 && A[i] <= A[i-1])
                continue;
            return false;
        }
        return true;
    }
}
