/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 *
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 *
 * algorithms
 * Medium (36.61%)
 * Total Accepted:    22.6K
 * Total Submissions: 61.8K
 * Testcase Example:  '"123456579"'
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a
 * Fibonacci-like sequence [123, 456, 579].
 * 
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers
 * such that:
 * 
 * 
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 * 
 * 
 * Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 * 
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot
 * be done.
 * 
 * Example 1:
 * 
 * 
 * Input: "123456579"
 * Output: [123,456,579]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not
 * valid.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= S.length <= 200
 * S contains only digits.
 * 
 * 
 */
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
        for (int i = 1; i <= n/2 && i < 12; i++)
            for (int j = 1; i+j < n && j < 12; j++) {
                List<Integer> ans = new ArrayList<>();
                if (check(S, i, j, ans))
                    return ans;
            }
        return new ArrayList<>();
    }
    
    boolean check(String s, int i, int j , List<Integer> ans) {
        if (i > 1 && s.charAt(0) == '0' || j > 1 && s.charAt(i) == '0')
            return false;
        long x = Long.valueOf(s.substring(0, i));
        long y = Long.valueOf(s.substring(i, i+j));
        if (x >= Integer.MAX_VALUE || y >= Integer.MAX_VALUE)
            return false;
        ans.add((int) x);
        ans.add((int) y);
        s = s.substring(i+j);
        while (!"".equals(s)) {
            long v = x+y;
            if (v >= Integer.MAX_VALUE)
                break;
            String z = String.valueOf(v);
            if (s.startsWith(z)) {
                ans.add((int) v);
                s = s.substring(z.length());
                x = y;
                y = v;
            } else {
                break;
            }
        }
        return "".equals(s);
    }
}
