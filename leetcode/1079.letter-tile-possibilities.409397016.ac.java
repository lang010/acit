/*
 * @lc app=leetcode id=1079 lang=java
 *
 * [1079] Letter Tile Possibilities
 *
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 *
 * algorithms
 * Medium (75.65%)
 * Total Accepted:    40.7K
 * Total Submissions: 53.8K
 * Testcase Example:  '"AAB"'
 *
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 * 
 * Return the number of possible non-empty sequences of letters you can make
 * using the letters printed on those tiles.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB",
 * "ABA", "BAA".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tiles = "AAABBC"
 * Output: 188
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tiles = "V"
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= tiles.length <= 7
 * tiles consists of uppercase English letters.
 * 
 * 
 */
class Solution {
    Set<String> set = new HashSet<>();
    boolean[] visited;
    public int numTilePossibilities(String tiles) {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[tiles.length()];
        dfs(tiles, sb, tiles.length());
        return set.size();
    }
    
    void dfs(String s, StringBuilder sb, int cur) {
        if (cur == 0) {
            return;
        }
        for (int i = 0; i < s.length(); i++)
            if (!visited[i]) {
                visited[i] = true;
                sb.append(s.charAt(i));
                set.add(sb.toString());
                dfs(s, sb, cur-1);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
    }
}
