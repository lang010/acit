/*
 * @lc app=leetcode id=1550 lang=java
 *
 * [1550] Three Consecutive Odds
 *
 * https://leetcode.com/problems/three-consecutive-odds/description/
 *
 * algorithms
 * Easy (65.56%)
 * Total Accepted:    25.6K
 * Total Submissions: 39K
 * Testcase Example:  '[2,6,4,1]'
 *
 * Given an integer array arr, return true if there are three consecutive odd
 * numbers in the array. Otherwise, return false.
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 
 * 
 */
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr == null || arr.length < 3)
            return false;
        int c = 0;
        for (int x : arr)
            if (x%2 == 1) {
                c++;
                if (c == 3)
                    return true;
            } else
                c = 0;
        return false;
    }
}
