/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Hard (39.05%)
 * Total Accepted:    215K
 * Total Submissions: 550.7K
 * Testcase Example:  '3\n3'
 *
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * 
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 * Example 3:
 * Input: n = 3, k = 1
 * Output: "123"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 1 <= k <= n!
 * 
 * 
 */
class Solution {
    
    public String getPermutation(int n, int k) {
        int[] factor = new int[n+1];
        factor[0] = 1;
        for (int i = 1; i <= n; i++)
            factor[i] = i*factor[i-1];
        List<Integer> ls = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            ls.add(i);
        k--;
        for (int i = n; i > 0; i--) {
            int id = k/factor[i-1];
            sb.append(ls.get(id));
            ls.remove(id);
            k %= factor[i-1];
        }
        return sb.toString();
    }
}
