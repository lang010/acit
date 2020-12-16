/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (47.09%)
 * Total Accepted:    52.6K
 * Total Submissions: 111.7K
 * Testcase Example:  '[4,6,7,7]'
 *
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also
 * be considered as a special case of increasing sequence.
 * 
 * 
 */
class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return new ArrayList<>(set);
    }
    
    void dfs(int i, int[] nums, List<Integer> ls) {
        if (i == nums.length) {
            if (ls.size() > 1)
                set.add(new ArrayList<>(ls));
            return;
        }
        dfs(i+1, nums, ls);
        int n = ls.size();
        if (n == 0 || ls.get(n-1) <= nums[i]) {
            ls.add(nums[i]);
            dfs(i+1, nums, ls);
            ls.remove(n);
        }
    }
}
