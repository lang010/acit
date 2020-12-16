/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (48.36%)
 * Total Accepted:    357.2K
 * Total Submissions: 738.5K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {
    public int numSquares(int n) {
        int[] ans = new int[n+1];
        List<Integer> ls = squares(n);
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = i;
            for (int x : ls) {
                if (x > i)
                    break;
                min = Math.min(min, ans[i-x]+1);
            }
            ans[i] = min;
        }
        return ans[n];
    }
    
    List<Integer> squares(int n) {
        List<Integer> ans = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            ans.add(i*i);
            i++;
        }
        
        return ans;
    }
}
