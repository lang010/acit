/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (58.47%)
 * Total Accepted:    807.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s : strs) {
            String key = convert(s);
            if (!maps.containsKey(key)) {
                List<String> ls = new ArrayList<>();
                maps.put(key, ls);
                ans.add(ls);
            }
            maps.get(key).add(s);
        }
        
        return ans;
    }
    
    String convert(String s) {
        if ("".equals(s))
            return "";
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnts[i] > 0) {
                sb.append((char)('a' + i));
                sb.append(cnts[i]);
            }
        }
        
        return sb.toString();
    }
}
