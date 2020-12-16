/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (65.55%)
 * Total Accepted:    715.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * 
 * 
 */
class Solution {
    boolean[] flag;
    public List<List<Integer>> permute(int[] nums) {
        flag = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        int[] selected = new int[nums.length];
        backtracking(nums, 0, selected, ans);
        return ans;
    }
    
    void backtracking(int[] nums, int cur, int[] selected, List<List<Integer>> ans) {
        if (cur == nums.length) {
            List<Integer> ls = new ArrayList<>(cur);
            for (int id : selected)
                ls.add(nums[id]);
            ans.add(ls);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                selected[cur] = i;
                backtracking(nums, cur+1, selected, ans);
                flag[i] = false;
            }
        }
    }
}
