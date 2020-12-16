/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 *
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 *
 * algorithms
 * Medium (57.46%)
 * Total Accepted:    54.2K
 * Total Submissions: 94.4K
 * Testcase Example:  '"abcd"\n2'
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and
 * equal letters from s and removing them causing the left and the right side
 * of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made.
 * 
 * It is guaranteed that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * 
 * Example 2:
 * 
 * 
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation: 
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 * 
 * 
 */
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> cnt = new Stack<>();
        for (char c : s.toCharArray()) {
            char pre = stack.isEmpty() ? 0 : stack.peek();
            if (pre != c) {
                stack.push(c);
                cnt.push(1);
            } else {
                int cur = cnt.pop();
                cur++;
                if (cur < k)
                    cnt.push(cur);
                else
                    stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int n = cnt.pop();
            char c = stack.pop();
            for (int i = 0; i < n; i++)
                sb.append(c);
        }
        return sb.reverse().toString();
    }
}
