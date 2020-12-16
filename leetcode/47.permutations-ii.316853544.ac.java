/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (48.65%)
 * Total Accepted:    413.6K
 * Total Submissions: 850K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * ⁠[1,2,1],
 * ⁠[2,1,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length < 1)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> ls = new ArrayList<>(nums.length);
        for(int x : nums)
            ls.add(x);
        
        backtracking(nums, 0, visited, ls, ans);
        return ans;
    }
    
    void backtracking(int[] nums, int cur, boolean[] visited, List<Integer> ls, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i-1] == nums[i] && !visited[i-1]) 
                continue;
            if (!visited[i]) {
                visited[i] = true;
                ls.set(cur, nums[i]);
                backtracking(nums, cur+1, visited, ls, ans);
                visited[i] = false;
            }
        }
    }
}
