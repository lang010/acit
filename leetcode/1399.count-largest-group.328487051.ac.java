/*
 * @lc app=leetcode id=1399 lang=java
 *
 * [1399] Count Largest Group
 *
 * https://leetcode.com/problems/count-largest-group/description/
 *
 * algorithms
 * Easy (65.34%)
 * Total Accepted:    18.7K
 * Total Submissions: 28.6K
 * Testcase Example:  '13\r'
 *
 * Given an integer n. Each number from 1 to n is grouped according to the sum
 * of its digits. 
 * 
 * Return how many groups have the largest size.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of
 * its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups
 * with largest size.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 15
 * Output: 6
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 24
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */
class Solution {
    public int countLargestGroup(int n) {
        int[] cnt = new int[40];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ++cnt[digit(i)]);
            
        }
        int ans = 0;
        for (int i = 36; i > 0; i--)
            if (cnt[i] == max)
                ans++;
        return ans;
    }
    
    int digit(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x%10;
            x /= 10;
        }
        return ans;
    }
}
