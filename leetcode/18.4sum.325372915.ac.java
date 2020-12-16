/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * algorithms
 * Medium (34.39%)
 * Total Accepted:    372.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 * 
 * Notice that the solution set must not contain duplicate quadruplets.
 * 
 * 
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * Input: nums = [], target = 0
 * Output: []
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */
class Solution {
    List<List<Integer>> ans;
    int[] buf = new int[4];
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backtracking(nums, 0, 0, target);
        
        return ans;
    }
    
    void backtracking(int[] nums, int depth, int st, int tar) {
        if (depth == 4) {
            if (tar == 0) {
                List<Integer> ls = new ArrayList<>();
                for (int x : buf)
                    ls.add(x);
                ans.add(ls);
            }
            return;
        }
        int n = nums.length;
        int cnt = 4 - depth;
        if (st + cnt > n)
            return;
        if (tar < sum(nums, st, cnt))
            return;
        if (tar > sum(nums, n-cnt, cnt))
            return;
        while (st < n) {
            buf[depth] = nums[st];
            backtracking(nums, depth+1, st+1, tar-nums[st]);
            st++;
            while (st < n && nums[st-1] == nums[st])
                st++;
        }
    }
    
    int sum(int[] nums, int st, int cnt) {
        int ans = 0;
        int k = 0;
        while (k < cnt) {
            ans += nums[st+k];
            k++;
        }

        return ans;
    }
}
