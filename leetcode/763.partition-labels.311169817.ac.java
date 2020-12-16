/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (77.74%)
 * Total Accepted:    209.7K
 * Total Submissions: 269.7K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * A string S of lowercase English letters is given. We want to partition this
 * string into as many parts as possible so that each letter appears in at most
 * one part, and return a list of integers representing the size of these
 * parts.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] r = new int[26];
        int n = S.length();
        for (int i = 0; i < n; i++) {
            int id = S.charAt(i) - 'a';
            r[id] = i;
        }
        int i = 0;
        while (i < n) {
            int beg = i;
            int end = i;
            while (true) {
                int id = S.charAt(i) - 'a';
                if (r[id] > end) {
                    end = r[id];
                }
                if (end == i)
                    break;
                i++;
            }
            ans.add(end - beg + 1);
            i++;
        }
        return ans;
    }
}
