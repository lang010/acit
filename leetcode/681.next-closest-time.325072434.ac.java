/*
 * @lc app=leetcode id=681 lang=java
 *
 * [681] Next Closest Time
 *
 * https://leetcode.com/problems/next-closest-time/description/
 *
 * algorithms
 * Medium (45.61%)
 * Total Accepted:    72K
 * Total Submissions: 158K
 * Testcase Example:  '"19:34"'
 *
 * Given a time represented in the format "HH:MM", form the next closest time
 * by reusing the current digits. There is no limit on how many times a digit
 * can be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: time = "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is
 * 19:39, which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: time = "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is
 * 22:22.
 * It may be assumed that the returned time is next day's time since it is
 * smaller than the input time numerically.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * time.length == 5
 * time is a valid time in the form "HH:MM".
 * 0 <= HH < 24
 * 0 <= MM < 60
 * 
 * 
 */
class Solution {
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        set.add(time.charAt(0));
        set.add(time.charAt(1));
        set.add(time.charAt(3));
        set.add(time.charAt(4));
        String ans = null;
        int min = Integer.MAX_VALUE;
        for (char c1 : set)
            for (char c2 : set)
                for (char c3: set)
                    for (char c4: set) {
                        String cur = "" + c1 + c2 + ":" + c3 + c4;
                        int val = diff(time, cur);
                        if (val < min) {
                            min = val;
                            ans = cur;
                        }
                    }
        return ans;
    }
    
    int diff(String t1, String t2) {
        int c1 = cnt(t1);
        int c2 = cnt(t2);
        if (c2 > c1)
            return c2 - c1;
        return c2 + 60 * 24 - c1;
    }
    
    int cnt(String tm) {
        int h = Integer.valueOf(tm.substring(0, 2));
        int m = Integer.valueOf(tm.substring(3, 5));
        if (h > 23 || m > 59)
            return 6000;
        return h*60+m;
    }
}
