/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 *
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
 *
 * algorithms
 * Medium (44.20%)
 * Total Accepted:    39.7K
 * Total Submissions: 89.9K
 * Testcase Example:  '3\n7'
 *
 * Return all non-negative integers of length n such that the absolute
 * difference between every two consecutive digits is k.
 * 
 * Note that every number in the answer must not have leading zeros except for
 * the number 0 itself. For example, 01 has one leading zero and is invalid,
 * but 0 is valid.
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading
 * zeroes.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 2, k = 0
 * Output: [11,22,33,44,55,66,77,88,99]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: n = 2, k = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: n = 2, k = 2
 * Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 9
 * 0 <= k <= 9
 * 
 * 
 */
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(ls, i, n-1, k);
        int[] ans = new int[ls.size()];
        int t = 0;
        for (int x : ls)
            ans[t++] = x;
        return ans;
    }
    
    void dfs(List<Integer> ls, int cur, int d, int k) {
        if (d == 0) {
            ls.add(cur);
            return;
        }
        int l = cur%10;
        if (l+k < 10)
            dfs(ls, cur*10 + l+k, d-1, k);
        if (l-k >= 0 && k > 0)
            dfs(ls, cur*10 + l-k, d-1, k);
    }
}
