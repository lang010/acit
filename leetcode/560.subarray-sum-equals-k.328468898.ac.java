/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (43.88%)
 * Total Accepted:    410K
 * Total Submissions: 934.3K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * continuous subarrays whose sum equals to k.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                nums[i] += nums[i-1];
            List<Integer> ls = map.get(nums[i]);
            if (ls == null) {
                ls = new ArrayList<>();
                map.put(nums[i], ls);
            }
            ls.add(i);
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = nums[i] - k;
            if (left == 0)
                ans++;
            List<Integer> ls = map.get(left);
            if (ls != null) {
                for (int j = 0; j < ls.size() && ls.get(j) < i; j++)
                    ans++;
            }
        }
        return ans;
    }
}
