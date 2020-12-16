/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (48.22%)
 * Total Accepted:    311.9K
 * Total Submissions: 646.8K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> ls = new ArrayList<>();
        ans.add(new ArrayList<>());
        
        for (int i = 1; i <= nums.length; i++) {
            backtracking(nums, visited, 0, i, ls, ans);
        }
        
        return ans;
    }
    
    void backtracking(int[] nums, boolean[] visited, int st, int cnt, List<Integer> ls, List<List<Integer>> ans) {
        if (ls.size() == cnt) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        int curSz = ls.size();
        for (int i = st; i < nums.length - (cnt-curSz-1); i++) {
            if (i > 0 && nums[i-1] == nums[i] && !visited[i-1])
                continue;
            visited[i] = true;
            ls.add(nums[i]);
            backtracking(nums, visited, i+1, cnt, ls, ans);
            visited[i] = false;
            ls.remove(curSz);
        }
    }
}
