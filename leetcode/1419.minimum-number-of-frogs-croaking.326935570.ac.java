/*
 * @lc app=leetcode id=1419 lang=java
 *
 * [1419] Minimum Number of Frogs Croaking
 *
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/description/
 *
 * algorithms
 * Medium (47.01%)
 * Total Accepted:    14.3K
 * Total Submissions: 30.4K
 * Testcase Example:  '"croakcroak"'
 *
 * Given the string croakOfFrogs, which represents a combination of the string
 * "croak" from different frogs, that is, multiple frogs can croak at the same
 * time, so multiple “croak” are mixed. Return the minimum number of different
 * frogs to finish all the croak in the given string.
 * 
 * A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’
 * sequentially. The frogs have to print all five letters to finish a croak. If
 * the given string is not a combination of valid "croak" return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: croakOfFrogs = "croakcroak"
 * Output: 1 
 * Explanation: One frog yelling "croak" twice.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: croakOfFrogs = "crcoakroak"
 * Output: 2 
 * Explanation: The minimum number of frogs is two. 
 * The first frog could yell "crcoakroak".
 * The second frog could yell later "crcoakroak".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: croakOfFrogs = "croakcrook"
 * Output: -1
 * Explanation: The given string is an invalid combination of "croak" from
 * different frogs.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: croakOfFrogs = "croakcroa"
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= croakOfFrogs.length <= 10^5
 * All characters in the string are: 'c', 'r', 'o', 'a' or 'k'.
 * 
 * 
 */
class Solution {
    public int minNumberOfFrogs(String s) {
        if (s.length() % 5 != 0)
            return -1;
        int ans = 0;
        int[] buf = new int[5];
        for (char c : s.toCharArray()) {
            int n = id(c);
            if (n < 0)
                return -1;
            if (n == 0) {
                buf[0]++;
                int sum = 0;
                for (int i = 0; i < 4; i++)
                    sum += buf[i];
                ans = Math.max(ans, sum);
            } else {
                if (buf[n-1] == 0)
                    return -1;
                --buf[n-1];
                buf[n]++;
            }
        }
        for (int i = 0; i < 4; i++)
            if (buf[i] > 0)
                return -1;
        return ans;
    }
    
    char[] cs = { 'c', 'r', 'o', 'a', 'k'};
    
    int id(char c) {
        for (int i = 0; i < 5; i++)
            if (cs[i] == c)
                return i;
        return -1;
    }
}
