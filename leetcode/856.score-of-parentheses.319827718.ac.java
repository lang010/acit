/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 *
 * https://leetcode.com/problems/score-of-parentheses/description/
 *
 * algorithms
 * Medium (61.95%)
 * Total Accepted:    46.9K
 * Total Submissions: 75.7K
 * Testcase Example:  '"()"'
 *
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 * 
 * 
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: 1
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "(())"
 * Output: 2
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "()()"
 * Output: 2
 * 
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "(()(()))"
 * Output: 6
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 * 
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int scoreOfParentheses(String S) {
        return comp(S, 0, S.length()-1);
    }
    
    int comp(String s, int l, int r) {
        if (l >= r)
            return 0;
        if (l+1 == r)
            return 1;
        int sum = 0;
        int cnt = 0;
        int beg = l+1;
        for (int i = l; i <= r; i++) {
            cnt += s.charAt(i) == '(' ? 1 : -1;
            if (cnt == 0) {
                if (i == l+1)
                    sum++;
                else
                    sum += 2 * comp(s, l+1, i);
                l = i+1;
            }
        }
        return sum;
    }
}
