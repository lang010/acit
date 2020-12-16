/*
 * @lc app=leetcode id=830 lang=java
 *
 * [830] Positions of Large Groups
 *
 * https://leetcode.com/problems/positions-of-large-groups/description/
 *
 * algorithms
 * Easy (50.03%)
 * Total Accepted:    50.1K
 * Total Submissions: 100.2K
 * Testcase Example:  '"abbxxxxzzy"'
 *
 * In a string s of lowercase letters, these letters form consecutive groups of
 * the same character.
 * 
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb",
 * "xxxx", "z", and "yy".
 * 
 * A group is identified by an interval [start, end], where start and end
 * denote the start and end indices (inclusive) of the group. In the above
 * example, "xxxx" has the interval [3,6].
 * 
 * A group is considered large if it has 3 or more characters.
 * 
 * Return the intervals of every large group sorted in increasing order by
 * start index.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the only large group with start index 3 and end index
 * 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abc"
 * Output: []
 * Explanation: We have groups "a", "b", and "c", none of which are large
 * groups.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "aba"
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s contains lower-case English letters only.
 * 
 * 
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int st = 0;
        int cnt = 1;
        for (int i = 0; i < S.length(); i++) {
            if (i+1 < S.length() && S.charAt(i) == S.charAt(i+1)) {
                cnt++;
            } else {
                if (cnt > 2) {
                    ans.add(Arrays.asList(st, i));
                }
                st = i+1;
                cnt = 1;
            }
        }
        return ans;
    }
}
