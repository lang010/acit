/*
 * @lc app=leetcode id=884 lang=java
 *
 * [884] Uncommon Words from Two Sentences
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * algorithms
 * Easy (63.84%)
 * Total Accepted:    65.8K
 * Total Submissions: 103K
 * Testcase Example:  '"this apple is sweet"\n"this apple is sour"'
 *
 * We are given two sentences A and B.  (A sentence is a string of space
 * separated words.  Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words. 
 * 
 * You may return the list in any order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 * 
 * 
 * 
 * 
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        String[] al = A.split(" ");
        String[] bl = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : al)
            map.put(s, map.getOrDefault(s, 0)+1);
        for (String s : bl)
            map.put(s, map.getOrDefault(s, 0)+1);
        for (String s : map.keySet())
            if (map.get(s) == 1)
                ans.add(s);
        return ans.toArray(new String[0]);
    }
}
