/*
 * @lc app=leetcode id=1087 lang=java
 *
 * [1087] Brace Expansion
 *
 * https://leetcode.com/problems/brace-expansion/description/
 *
 * algorithms
 * Medium (63.04%)
 * Total Accepted:    24.2K
 * Total Submissions: 38.5K
 * Testcase Example:  '"{a,b}c{d,e}f"'
 *
 * A string S represents a list of words.
 * 
 * Each letter in the word has 1 or more options.  If there is one option, the
 * letter is represented as is.  If there is more than one option, then curly
 * braces delimit the options.  For example, "{a,b,c}" represents options ["a",
 * "b", "c"].
 * 
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde",
 * "bdf", "cde", "cdf"].
 * 
 * Return all words that can be formed in this manner, in lexicographical
 * order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "abcd"
 * Output: ["abcd"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= S.length <= 50
 * There are no nested curly brackets.
 * All characters inside a pair of consecutive opening and ending curly
 * brackets are different.
 * 
 * 
 */
class Solution {
    public String[] expand(String s) {
        List<String> ans = new ArrayList<>();
        ans.add("");
        while (!"".equals(s)) {
            int st = s.indexOf("{");
            if (st < 0) {
                ans = add(ans, new String[] {s});
                break;
            } else {
                ans = add(ans, new String[] {s.substring(0, st)});
                int end = s.indexOf("}");
                String[] arr = s.substring(st+1, end).split(",");
                Arrays.sort(arr);
                ans = add(ans, arr);
                s = s.substring(end+1);
            }
        }
        return ans.toArray(new String[0]);
    }
    
    List<String> add(List<String> ls, String[] arr) {
        List<String> ans = new ArrayList<>();
        for (String f : ls)
            for (String s : arr)
                ans.add(f+s);
        return ans;
    }
}
