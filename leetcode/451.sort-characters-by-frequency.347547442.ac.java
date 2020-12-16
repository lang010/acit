/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (63.94%)
 * Total Accepted:    228K
 * Total Submissions: 356.6K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> [] ls = new ArrayList[s.length()+1];
        for (char c : map.keySet()) {
            int n = map.get(c);
            if (ls[n] == null)
                ls[n] = new ArrayList<Character>();
            ls[n].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (ls[i] == null)
                continue;
            for (char c : ls[i]) {
                for (int j = 0; j < i; j++)
                    sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
