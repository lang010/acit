/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (49.58%)
 * Total Accepted:    370.4K
 * Total Submissions: 746.9K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: 
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        
        backtracking(candidates, visited, 0, target, ls, ans);
        
        return ans;
    }
    
    void backtracking(int[] candidates, boolean[] visited, int s, int target, List<Integer> ls, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (i > 0 && candidates[i-1] == candidates[i] && !visited[i-1])
                continue;
            if (target < candidates[i])
                break;
            if (visited[i])
                continue;
            visited[i] = true;
            ls.add(candidates[i]);
            backtracking(candidates, visited, i+1, target-candidates[i], ls, ans);
            ls.remove(ls.size()-1);
            visited[i] = false;
        }
    }
}
