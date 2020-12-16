/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (59.61%)
 * Total Accepted:    208.7K
 * Total Submissions: 350.1K
 * Testcase Example:  '3\n7'
 *
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * 
 * 
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1
 * is used twice.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * ​​​​​​​There are no other valid combinations.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= k <= 9
 * 1 <= n <= 60
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > 9 || n > (n + n - k + 1) * k/2)
            return ans;
        List<Integer> ls = new ArrayList<>();
        backtracking(k, 1, n, ls, ans);
        return ans;
    }
    
    void backtracking(int k, int s, int n, List<Integer> ls, List<List<Integer>> ans) {
        if (n == 0) {
            if (k == 0)
                ans.add(new ArrayList<>(ls));
            return;
        }
        if (k == 0)
            return;
        for (int i = s; i < 10; i++)
            if (i <= n) {
                ls.add(i);
                backtracking(k-1, i+1, n-i, ls, ans);
                ls.remove(ls.size()-1);
            } else
                break;
    }
}
