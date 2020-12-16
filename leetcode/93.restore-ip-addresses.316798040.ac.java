/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (36.92%)
 * Total Accepted:    217.3K
 * Total Submissions: 588.5K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string s containing only digits, return all possible valid IP
 * addresses that can be obtained from s. You can return them in any order.
 * 
 * A valid IP address consists of exactly four integers, each integer is
 * between 0 and 255, separated by single dots and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and
 * "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP
 * addresses. 
 * 
 * 
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 3000
 * s consists of digits only.
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(0, "", s, ans);
        return ans;
    }
    
    void dfs(int depth, String cur, String in, List<String> ans) {
        if (depth == 4) {
            if (in.equals(""))
                ans.add(cur);
            return;
        }
        int n = Math.min(3, in.length());
        for (int i = 1; i <= n; i++) {
            String sub = in.substring(0, i);
            if (sub.charAt(0) == '0' && sub.length() > 1)
                break;
            if (Integer.valueOf(sub) <= 255) {
                String next = cur + sub;
                if (depth < 3)
                    next = next + ".";
                dfs(depth+1, next, in.substring(i), ans);
            }
        }
    }
}
