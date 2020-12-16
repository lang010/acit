/*
 * @lc app=leetcode id=1002 lang=java
 *
 * [1002] Find Common Characters
 *
 * https://leetcode.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (67.94%)
 * Total Accepted:    88.3K
 * Total Submissions: 130K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 
 * 
 * 
 */
class Solution {
    public List<String> commonChars(String[] A) {
        int[][] map = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                map[i][c - 'a']++;
            }
        }
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = 1000;
            for (int j = 0; j < A.length; j++) {
                if (map[j][i] == 0) {
                    min = 0;
                    break;
                }
                if (map[j][i] < min) {
                    min = map[j][i];
                }
            }
            for (int j = 0; j < min; j++) {
                ls.add(String.valueOf((char)('a' + i)));
            }
        }
        return ls;
    }
}
