/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (38.09%)
 * Total Accepted:    104.5K
 * Total Submissions: 274.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies:
 * 
 * Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * 
 * 
 * 
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];
        List<Integer> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = i;
        }
        Arrays.sort(nums);
        int max = 1;
        int maxI = 0;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[i]%nums[j] == 0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                    if (dp[i] > max) {
                        max = dp[i];
                        maxI = i;
                    }
                }
        ans.add(nums[maxI]);
        while (maxI != pre[maxI]) {
            maxI = pre[maxI];
            ans.add(nums[maxI]);
        }
        return ans;
    }
}
