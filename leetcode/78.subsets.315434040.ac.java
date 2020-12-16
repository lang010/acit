/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (64.00%)
 * Total Accepted:    680.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array nums, return all possible subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 
 * 
 */
class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> ls = new LinkedList<>();
        subset(nums, 0, ls);
        return ans;
    }
    
    void subset(int[] nums, int len, LinkedList<Integer> ls) {
        if (len == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        subset(nums, len+1, ls);
        ls.addFirst(nums[len]);
        subset(nums, len+1, ls);
        ls.removeFirst();
    }
}
