/*
 * @lc app=leetcode id=1055 lang=java
 *
 * [1055] Shortest Way to Form String
 *
 * https://leetcode.com/problems/shortest-way-to-form-string/description/
 *
 * algorithms
 * Medium (57.08%)
 * Total Accepted:    38.7K
 * Total Submissions: 67.8K
 * Testcase Example:  '"abc"\n"abcbc"'
 *
 * From any string, we can form a subsequence of that string by deleting some
 * number of characters (possibly no deletions).
 * 
 * Given two strings source and target, return the minimum number of
 * subsequences of source such that their concatenation equals target. If the
 * task is impossible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are
 * subsequences of source "abc".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences
 * of source string due to the character "d" in target string.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" +
 * "xz".
 * 
 * 
 * Constraints:
 * 
 * 
 * Both the source and target strings consist of only lowercase English letters
 * from "a"-"z".
 * The lengths of source and target string are between 1 and 1000.
 * 
 */
class Solution {
    public int shortestWay(String source, String target) {
        List<Integer>[] map = new List[26];
        for (int i = 0; i < source.length(); i++) {
            int id = source.charAt(i) - 'a';
            if (map[id] == null)
                map[id] = new ArrayList<Integer>();
            map[id].add(i);
        }
        int cur = -1;
        int ans = 1;
        for (int i = 0; i < target.length(); i++) {
            int id = target.charAt(i) - 'a';
            if (map[id] == null)
                return -1;
            int next = map[id].size()-1;
            if (map[id].get(next) <= cur) {
                cur = map[id].get(0);
                ans++;
                continue;
            }
            next = Collections.binarySearch(map[id], cur);
            if (next >=0)
                cur = map[id].get(next+1);
            else {
                cur = map[id].get(-next-1);
            }
        }
        return ans;
    }
}
