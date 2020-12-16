/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 *
 * https://leetcode.com/problems/reorder-data-in-log-files/description/
 *
 * algorithms
 * Easy (54.26%)
 * Total Accepted:    176.4K
 * Total Submissions: 325K
 * Testcase Example:  '["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]'
 *
 * You have an array of logs.  Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier.
 * Then, either:
 * 
 * 
 * Each word after the identifier will consist only of lowercase letters,
 * or;
 * Each word after the identifier will consist only of digits.
 * 
 * 
 * We will call these two varieties of logs letter-logs and digit-logs.  It is
 * guaranteed that each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties.  The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * 
 * Example 1:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5
 * 1","dig2 3 6"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the
 * identifier.
 * 
 * 
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        int l = 0;
        int r = logs.length - 1;
        
        for (int i = r; i >= 0 ; i--) {
            if (isDigitLog(logs[i])) {
                ans[r--] = logs[i];
            } else {
                ans[l++] = logs[i];
            }
        }
        
        Arrays.sort(ans, 0, l, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                int ai = 0;
                int bi = 0;
                while (ai < a.length() && ' ' != a.charAt(ai)) {
                    ai++;
                }
                while (bi < b.length() && ' ' != b.charAt(bi)) {
                    bi++;
                }
                while (ai < a.length() && bi < b.length() && a.charAt(ai) == b.charAt(bi)) {
                    ai++;
                    bi++;
                }
                if (ai == a.length() && bi == b.length()) {
                    return 0;
                }
                if (ai == a.length()) {
                    return -1;
                }
                if (bi == b.length()) {
                    return 1;
                }
                return a.charAt(ai) - b.charAt(bi);
            }
        });
        
        
        return ans;
    }
    
    boolean isDigitLog(String log) {
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == ' ') {
                char c = log.charAt(i+1);
                if (c >= '0' && c <= '9') 
                    return true;
                return false;
            }
        }
        return false;
    }
}
