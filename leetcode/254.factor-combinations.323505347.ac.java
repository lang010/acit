/*
 * @lc app=leetcode id=254 lang=java
 *
 * [254] Factor Combinations
 *
 * https://leetcode.com/problems/factor-combinations/description/
 *
 * algorithms
 * Medium (47.13%)
 * Total Accepted:    77.7K
 * Total Submissions: 164.7K
 * Testcase Example:  '1'
 *
 * Numbers can be regarded as product of its factors. For example,
 * 
 * 
 * 8 = 2 x 2 x 2;
 * ⁠ = 2 x 4.
 * 
 * 
 * Write a function that takes an integer n and return all possible
 * combinations of its factors.
 * 
 * Note:
 * 
 * 
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * 
 * 
 * Example 1: 
 * 
 * 
 * Input: 1
 * Output: []
 * 
 * 
 * Example 2: 
 * 
 * 
 * Input: 37
 * Output:[]
 * 
 * Example 3: 
 * 
 * 
 * Input: 12
 * Output:
 * [
 * ⁠ [2, 6],
 * ⁠ [2, 2, 3],
 * ⁠ [3, 4]
 * ]
 * 
 * Example 4: 
 * 
 * 
 * Input: 32
 * Output:
 * [
 * ⁠ [2, 16],
 * ⁠ [2, 2, 8],
 * ⁠ [2, 2, 2, 4],
 * ⁠ [2, 2, 2, 2, 2],
 * ⁠ [2, 4, 4],
 * ⁠ [4, 8]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> getFactors(int n) {
        LinkedList<List<Integer>> ans = helper(n, 2);
        ans.removeFirst();
        return ans;
    }
    
    LinkedList<List<Integer>> helper(int n, int st) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(n);
        ans.add(ls);
        int cnt = (int) Math.sqrt(n);
        for (int i = st; i <= cnt; i++)
            if (n % i == 0) {
                LinkedList<List<Integer>> list = helper(n/i, i);
                for (List<Integer> l : list) {
                    l.add(i);
                }
                ans.addAll(list);
            }
        return ans;
    }
}
