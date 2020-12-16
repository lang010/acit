/*
 * @lc app=leetcode id=1324 lang=java
 *
 * [1324] Print Words Vertically
 *
 * https://leetcode.com/problems/print-words-vertically/description/
 *
 * algorithms
 * Medium (58.73%)
 * Total Accepted:    17K
 * Total Submissions: 29K
 * Testcase Example:  '"HOW ARE YOU"'
 *
 * Given a string s. Return all the words vertically in the same order in which
 * they appear in s.
 * Words are returned as a list of strings, complete with spaces when is
 * necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will
 * be only one word.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "HOW ARE YOU"
 * Output: ["HAY","ORO","WEU"]
 * Explanation: Each word is printed vertically. 
 * ⁠"HAY"
 * "ORO"
 * "WEU"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "TO BE OR NOT TO BE"
 * Output: ["TBONTB","OEROOE","   T"]
 * Explanation: Trailing spaces is not allowed. 
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "CONTEST IS COMING"
 * Output: ["CIC","OSO","N M","T I","E N","S G","T"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 200
 * s contains only upper case English letters.
 * It's guaranteed that there is only one space between 2 words.
 * 
 */
class Solution {
    public List<String> printVertically(String s) {
        //List<StringBuilder> ls = new ArrayList<>();
        String[] arr = s.split(" ");
        int max = 0;
        for (String str : arr) {
            max = Math.max(max, str.length());
        }
        int n = arr.length;
        char[][] chs = new char[max][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < max; j++)
                chs[j][i] = arr[i].length() > j ? arr[i].charAt(j) : ' ';
        List<String> ans = new ArrayList<>();
        for (char[] sa : chs) {
            int l = n-1;
            while (sa[l] == ' ')
                l--;
            ans.add(new String(sa).substring(0, ++l));
        }
        return ans;
    }
}
