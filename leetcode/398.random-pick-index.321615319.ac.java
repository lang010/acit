/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 *
 * https://leetcode.com/problems/random-pick-index/description/
 *
 * algorithms
 * Medium (57.32%)
 * Total Accepted:    106.9K
 * Total Submissions: 186.6K
 * Testcase Example:  '["Solution","pick"]\n[[[1,2,3,3,3]],[3]]'
 *
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Note:
 * The array size can be very large. Solution that uses too much extra space
 * will not pass the judge.
 * 
 * Example:
 * 
 * 
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should
 * have equal probability of returning.
 * solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * 
 * 
 */
class Solution {
    
    Map<Integer, List<Integer>> map = new HashMap<>();
    
    Random rand = new Random();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            List<Integer> ls;
            ls = map.get(x);
            if (ls == null) {
                ls = new ArrayList<>();
                map.put(x, ls);
            }
            ls.add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> ls = map.get(target);
        return ls.get(rand.nextInt(ls.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
