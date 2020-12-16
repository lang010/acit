/*
 * @lc app=leetcode id=420 lang=java
 *
 * [420] Strong Password Checker
 *
 * https://leetcode.com/problems/strong-password-checker/description/
 *
 * algorithms
 * Hard (13.77%)
 * Total Accepted:    14.3K
 * Total Submissions: 103.9K
 * Testcase Example:  '"a"'
 *
 * A password is considered strong if the below conditions are all met:
 * 
 * 
 * It has at least 6 characters and at most 20 characters.
 * It contains at least one lowercase letter, at least one uppercase letter,
 * and at least one digit.
 * It does not contain three repeating characters in a row (i.e., "...aaa..."
 * is weak, but "...aa...a..." is strong, assuming other conditions are met).
 * 
 * 
 * Given a string password, return the minimum number of steps required to make
 * password strong. if password is already strong, return 0.
 * 
 * In one step, you can:
 * 
 * 
 * Insert one character to password,
 * Delete one character from password, or
 * Replace one character of password with another character.
 * 
 * 
 * 
 * Example 1:
 * Input: password = "a"
 * Output: 5
 * Example 2:
 * Input: password = "aA1"
 * Output: 3
 * Example 3:
 * Input: password = "1337C0d3"
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= password.length <= 50
 * password consists of letters, digits, dot '.' or exclamation mark '!'.
 * 
 * 
 */
class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a%3 - b%3);
        int mask = 0;
        int len = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                mask |= 1;
            else if (c >= 'a' && c <= 'z')
                mask |= 2;
            else if (c >= 'A' && c <= 'Z')
                mask |= 4;
            if (i+1 == n || s.charAt(i+1) != c) {
                if (len > 2)
                    pq.offer(len);
                len = 1;
            } else
                len++;
        }
        int t1 = 3-Integer.bitCount(mask);
        if (n < 6) {
            return Math.max(t1, 6-n);
        }
        int t2 = n > 20 ? n-20 : 0;
        int t3 = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            int l = pq.poll();
            if (t2 > 0) {
                int d = Math.min(t2, l%3+1);
                t2 -= d;
                ans += d;
                l -= d;
                if (l > 2)
                    pq.offer(l);
                continue;
            }
            t3 += l/3;
        }
        ans += Math.max(t1, t3) + t2;
        
        return ans;
    }
}
