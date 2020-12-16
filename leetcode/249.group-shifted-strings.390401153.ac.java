/*
 * @lc app=leetcode id=249 lang=java
 *
 * [249] Group Shifted Strings
 *
 * https://leetcode.com/problems/group-shifted-strings/description/
 *
 * algorithms
 * Medium (57.22%)
 * Total Accepted:    89.1K
 * Total Submissions: 155.7K
 * Testcase Example:  '["abc","bcd","acef","xyz","az","ba","a","z"]'
 *
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the
 * sequence:
 * 
 * 
 * "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of non-empty strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 * 
 * Example:
 * 
 * 
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output: 
 * [
 * ⁠ ["abc","bcd","xyz"],
 * ⁠ ["az","ba"],
 * ⁠ ["acef"],
 * ⁠ ["a","z"]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s : strings) {
            String k = key(s);
            if (!map.containsKey(k)) {
                List<String> ls = new ArrayList<>();
                map.put(k, ls);
                ans.add(ls);
            }
            map.get(k).add(s);
        }
        return ans;
    }
    
    String key(String s) {
        if (s == null || s.equals(""))
            return s;
        if (s.length() == 1)
            return "a";
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        int d = (26 - (s.charAt(0)-'a'))%26;
        for (int i = 1; i < s.length(); i++)
            sb.append("." + ((s.charAt(i)-'a' + d)%26));
        return sb.toString();
    }
}
