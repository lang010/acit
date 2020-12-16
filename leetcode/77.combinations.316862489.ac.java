/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (56.46%)
 * Total Accepted:    327.9K
 * Total Submissions: 580.7K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k < 1)
            return ans;
        List<Integer> ls = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            ls.add(i);
        
        backtracking(1, n, 0, k, ls, ans);
        
        return ans;
    }
    
    void backtracking(int beg, int end, int cur, int k, List<Integer> ls, List<List<Integer>> ans) {
        if (cur == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = beg; i <= end - (k-cur-1); i++) {
            ls.set(cur, i);
            backtracking(i+1, end, cur+1, k, ls, ans);
        }
    }
}
