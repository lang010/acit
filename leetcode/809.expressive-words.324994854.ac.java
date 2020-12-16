/*
 * @lc app=leetcode id=809 lang=java
 *
 * [809] Expressive Words
 *
 * https://leetcode.com/problems/expressive-words/description/
 *
 * algorithms
 * Medium (46.63%)
 * Total Accepted:    57.3K
 * Total Submissions: 123K
 * Testcase Example:  '"heeellooo"\n["hello", "hi", "helo"]'
 *
 * Sometimes people repeat letters to represent extra feeling, such as "hello"
 * -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have
 * groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 * 
 * For some given string S, a query word is stretchy if it can be made to be
 * equal to S by any number of applications of the following extension
 * operation: choose a group consisting of characters c, and add some number of
 * characters c to the group so that the size of the group is 3 or more.
 * 
 * For example, starting with "hello", we could do an extension on the group
 * "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has
 * size less than 3.  Also, we could do another extension like "ll" -> "lllll"
 * to get "helllllooo".  If S = "helllllooo", then the query word "hello" would
 * be stretchy because of these two extension operations: query = "hello" ->
 * "hellooo" -> "helllllooo" = S.
 * 
 * Given a list of query words, return the number of words that are
 * stretchy. 
 * 
 * 
 * 
 * 
 * Example:
 * Input: 
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation: 
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size
 * 3 or more.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 * 
 * 
 */
class Solution {
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        List<Pair<Character, Integer>> sls = convert(S);
        for (String str : words) {
            List<Pair<Character, Integer>> ls = convert(str);
            if (check(sls, ls))
                ans++;
        }
        return ans;
    }
    
    List<Pair<Character, Integer>> convert(String s) {
        List<Pair<Character, Integer>> ans = new ArrayList<>();
        char pre = s.charAt(0);
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (pre == s.charAt(i)) {
                cur++;
            } else {
                ans.add(new Pair<>(pre, cur));
                pre = s.charAt(i);
                cur = 1;
            }
        }
        ans.add(new Pair<>(pre, cur));
        return ans;
    }
    
    boolean check(List<Pair<Character, Integer>> first, List<Pair<Character, Integer>> sec) {
        if (first.size() != sec.size())
            return false;
        for (int i = 0; i < first.size(); i++) {
            Pair<Character, Integer> f = first.get(i);
            Pair<Character, Integer> s = sec.get(i);
            if (f.getKey() != s.getKey())
                return false;
            int fcnt = f.getValue();
            int scnt = s.getValue();
            if (fcnt < scnt)
                return false;
            if (fcnt > scnt && fcnt < 3)
                return false;
        }
        return true;
    }
}
