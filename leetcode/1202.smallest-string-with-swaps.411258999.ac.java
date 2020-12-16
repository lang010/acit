/*
 * @lc app=leetcode id=1202 lang=java
 *
 * [1202] Smallest String With Swaps
 *
 * https://leetcode.com/problems/smallest-string-with-swaps/description/
 *
 * algorithms
 * Medium (47.66%)
 * Total Accepted:    19.3K
 * Total Submissions: 40.6K
 * Testcase Example:  '"dcab"\n[[0,3],[1,2]]'
 *
 * You are given a string s, and an array of pairs of indices in the string
 * pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * 
 * You can swap the characters at any pair of indices in the given pairs any
 * number of times.
 * 
 * Return the lexicographically smallest string that s can be changed to after
 * using the swaps.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination: 
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination: 
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * 
 * Example 3:
 * 
 * 
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination: 
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 * 
 * 
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i;
        for (List<Integer> ls : pairs)
            union(set, ls.get(0), ls.get(1));
        Map<Integer, List<Integer>> ids = new HashMap<>();
        Map<Integer, List<Character>> chs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(set, i);
            if (!ids.containsKey(p)) {
                ids.put(p, new ArrayList<>());
                chs.put(p, new ArrayList<>());
            }
            ids.get(p).add(i);
            chs.get(p).add(s.charAt(i));
        }
        chs.forEach((k, v) -> {
            Collections.sort(v);
        });
        StringBuilder sb = new StringBuilder(s);
        ids.forEach((k, v) -> {
            for (int i = 0; i < v.size(); i++) {
                sb.setCharAt(v.get(i), chs.get(k).get(i));
            }
        });
        return sb.toString();
    }
    
    void union(int[] set, int x, int y) {
        x = find(set, x);
        y = find(set, y);
        if (x != y)
            set[x] = y;
    }
    
    int find(int[] set, int x) {
        if (set[x] == x)
            return x;
        return set[x] = find(set, set[x]);
    }
}
