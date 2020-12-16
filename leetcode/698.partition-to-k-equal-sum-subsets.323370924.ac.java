/*
 * @lc app=leetcode id=698 lang=java
 *
 * [698] Partition to K Equal Sum Subsets
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (45.46%)
 * Total Accepted:    106.9K
 * Total Submissions: 235.2K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * 
 * 
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < 1)
            return false;
        int sum = 0;
        for (int x : nums)
            sum += x;
        if (sum%k != 0)
            return false;
        Arrays.sort(nums);
        int end = nums.length - 1;
        int target = sum/k;
        while (end >= 0 && --k > 0) {
            end = can(nums, target, end);
        }
        
        return k < 1;
    }
    
    int can(int[] nums, int target, int end) {
        if (target < nums[end])
            return -1;
        target -= nums[end];
        if (target == 0)
            return --end;
        int[] dp = new int[target+1];
        for (int i = 0; i < end; i++) {
            int x = nums[i];
            for (int j = target; j > x; j--) {
                if (dp[j-x] > 0)
                    dp[j] = i+1;
            }
            if (target >= x)
                dp[x] = i+1;
        }
        if (dp[target] == 0)
            return -1;
        Set<Integer> set = new HashSet<>();
        while (target > 0) {
            set.add(dp[target]-1);
            target -= nums[dp[target]-1];
        }
        int beg = 0;
        for (int i = 0; i < end; i++) {
            if (!set.contains(i)) {
                nums[beg++] = nums[i];
            }
        }
        return beg-1;
    }
}
