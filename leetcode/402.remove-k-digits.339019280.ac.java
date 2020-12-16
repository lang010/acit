/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (28.54%)
 * Total Accepted:    164.2K
 * Total Submissions: 575.4K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !dq.isEmpty() && dq.peekLast() > c) {
                dq.pollLast();
                k--;
            }
            if (dq.isEmpty() && c == '0')
                continue;
            dq.offer(c);
        }
        while (k > 0 && !dq.isEmpty()) {
            k--;
            dq.pollLast();
        }
        if (dq.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = dq.iterator();
        while (it.hasNext())
            sb.append(it.next());
        return sb.toString();
    }
}
