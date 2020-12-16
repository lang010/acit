/*
 * @lc app=leetcode id=247 lang=java
 *
 * [247] Strobogrammatic Number II
 *
 * https://leetcode.com/problems/strobogrammatic-number-ii/description/
 *
 * algorithms
 * Medium (48.16%)
 * Total Accepted:    84.8K
 * Total Submissions: 176.1K
 * Testcase Example:  '2'
 *
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * Example:
 * 
 * 
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 * 
 * 
 */
class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ls;
        int i;
        if (n%2 == 1) {
            ls = Arrays.asList(new String[] {"0", "1", "8"});
            i = 1;
        } else {
            ls = Arrays.asList(new String[] {""});
            i = 0;
        }
        while (i < n) {
            i += 2;
            List<String> nxt = new ArrayList<>();
            for (String s : ls) {
                if (i < n)
                    nxt.add("0" + s + "0");
                nxt.add("1" + s + "1");
                nxt.add("8" + s + "8");
                nxt.add("6" + s + "9");
                nxt.add("9" + s + "6");
            }
            ls = nxt;
        }
        return ls;
    }
}
