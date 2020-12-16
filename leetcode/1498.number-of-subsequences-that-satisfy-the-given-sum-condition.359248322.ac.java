/*
 * @lc app=leetcode id=1498 lang=java
 *
 * [1498] Number of Subsequences That Satisfy the Given Sum Condition
 *
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 *
 * algorithms
 * Medium (38.26%)
 * Total Accepted:    12.3K
 * Total Submissions: 32K
 * Testcase Example:  '[3,5,6,7]\n9'
 *
 * Given an array of integers nums and an integer target.
 * 
 * Return the number of non-empty subsequences of nums such that the sum of the
 * minimum and maximum element on it is less or equal to target. Since the
 * answer may be too large, return it modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [3,5,6,7], target = 9
 * Output: 4
 * Explanation: There are 4 subsequences that satisfy the condition.
 * [3] -> Min value + max value <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,3,6,8], target = 10
 * Output: 6
 * Explanation: There are 6 subsequences that satisfy the condition. (nums can
 * have repeated numbers).
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [2,3,3,4,6,7], target = 12
 * Output: 61
 * Explanation: There are 63 non-empty subsequences, two of them don't satisfy
 * the condition ([6,7], [7]).
 * Number of valid subsequences (63 - 2 = 61).
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nums = [5,2,4,1,7,6,8], target = 16
 * Output: 127
 * Explanation: All non-empty subset satisfy the condition (2^7 - 1) = 127
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * 1 <= target <= 10^6
 * 
 * 
 */
class Solution {
    int mod = 1000000007;
    int[] buf;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int ans = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
                continue;
            }
            ans = (ans + cnt(r-l))%mod;
            l++;
        }
        return ans;
    }
    
    int cnt(int n) {
        if (buf == null)
            buf = new int[n+1];
        else
            return buf[n];
        buf[0] = 1;
        for (int i = 1; i <= n; i++) {
            buf[i] = buf[i-1]*2%mod;
        }
        return buf[n];
    }
}
