/*
 * @lc app=leetcode id=320 lang=java
 *
 * [320] Generalized Abbreviation
 *
 * https://leetcode.com/problems/generalized-abbreviation/description/
 *
 * algorithms
 * Medium (53.08%)
 * Total Accepted:    50.7K
 * Total Submissions: 95.6K
 * Testcase Example:  '"word"'
 *
 * A word's generalized abbreviation can be constructed by taking any number of
 * non-overlapping substrings and replacing them with their respective lengths.
 * For example, "abcde" can be abbreviated into "a3e" ("bcd" turned into "3"),
 * "1bcd1" ("a" and "e" both turned into "1"), and "23" ("ab" turned into "2"
 * and "cde" turned into "3").
 * 
 * Given a string word, return a list of all the possible generalized
 * abbreviations of word. Return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: word = "word"
 * Output:
 * ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
 * Example 2:
 * Input: word = "a"
 * Output: ["1","a"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word.length <= 15
 * word consists of only lowercase English letters.
 * 
 * 
 */
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char c : word.toCharArray()) {
            int n = ans.size();
            for (int i = 0; i < n; i++) {
                String s = ans.get(i);
                ans.add(s+c);
                int v = 1;
                int j = s.length()-1;
                while (j >= 0) {
                    char k = s.charAt(j);
                    if (k >= '0' && k <= '9') {
                        v = (int) Math.pow(10, s.length()-1-j) * (k-'0') + v;
                        j--;
                    } else
                        break;
                }
                ans.set(i, s.substring(0, j+1) + v);
            }
        }
        return ans;
    }
}
