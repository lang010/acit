/*
 * @lc app=leetcode id=444 lang=java
 *
 * [444] Sequence Reconstruction
 *
 * https://leetcode.com/problems/sequence-reconstruction/description/
 *
 * algorithms
 * Medium (23.31%)
 * Total Accepted:    33.6K
 * Total Submissions: 144.3K
 * Testcase Example:  '[1,2,3]\r\n[[1,2],[1,3]]\r'
 *
 * Check whether the original sequence org can be uniquely reconstructed from
 * the sequences in seqs. The org sequence is a permutation of the integers
 * from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest
 * common supersequence of the sequences in seqs (i.e., a shortest sequence so
 * that all sequences in seqs are subsequences of it). Determine whether there
 * is only one sequence that can be reconstructed from seqs and it is the org
 * sequence.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: org = [1,2,3], seqs = [[1,2],[1,3]]
 * Output: false
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed,
 * because [1,3,2] is also a valid sequence that can be reconstructed.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: org = [1,2,3], seqs = [[1,2]]
 * Output: false
 * Explanation: The reconstructed sequence can only be [1,2].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Output: true
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct
 * the original sequence [1,2,3].
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * org is a permutation of {1,2,...,n}.
 * 1 <= segs[i].length <= 10^5
 * seqs[i][j] fits in a 32-bit signed integer.
 * 
 * 
 * 
 * 
 * UPDATE (2017/1/8):
 * The seqs parameter had been changed to a list of list of strings (instead of
 * a 2d array of strings). Please reload the code definition to get the latest
 * changes.
 * 
 */
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < org.length; i++)
            map.put(org[i], i);
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        for (List<Integer> ls : seqs) {
            if (ls.size() < 1)
                continue;
            if (!map.containsKey(ls.get(0)))
                return false;
            int pre = map.get(ls.get(0));
            for (int i = 1; i < ls.size(); i++) {
                int cur = ls.get(i);
                if (!map.containsKey(cur) || pre >= map.get(cur))
                    return false;
                pre = map.get(cur);
                set.add(new Pair<>(ls.get(i-1), cur));
            }
        }
        if (set.size() == 0) {
            if (org.length == 1) {
                for (List<Integer> ls : seqs)
                    if (ls.size() == 1 && ls.get(0) == 1)
                        return true;
            }
            return false;
        }

        for (int i = 1; i < org.length; i++)
            if (!set.contains(new Pair<>(org[i-1], org[i])))
                return false;
        
        return true;
    }
}
