/*
 * @lc app=leetcode id=824 lang=java
 *
 * [824] Goat Latin
 *
 * https://leetcode.com/problems/goat-latin/description/
 *
 * algorithms
 * Easy (66.22%)
 * Total Accepted:    105.6K
 * Total Submissions: 159.5K
 * Testcase Example:  '"I speak Goat Latin"'
 *
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word.
 * For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first
 * letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets
 * "aa" added to the end and so on.
 * 
 * 
 * Return the final sentence representing the conversion from S to Goat
 * Latin. 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
 * hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * S contains only uppercase, lowercase and spaces. Exactly one space between
 * each word.
 * 1 <= S.length <= 150.
 * 
 * 
 */
class Solution {
    public String toGoatLatin(String S) {
        char[] ls = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> set = new HashSet<>();
        for (char c : ls)
            set.add(c);
        int cnt = 1;
        String[] strs = S.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i > 0)
                ans.append(' ');
            if (!"".equals(strs[i])) {
                StringBuilder sb = new StringBuilder();
                if (!set.contains(strs[i].charAt(0))) {
                    sb.append(strs[i].substring(1));
                    sb.append(strs[i].charAt(0));
                } else
                    sb.append(strs[i]);
                sb.append("ma");
                for (int j = 0; j <= i; j++)
                    sb.append('a');
                ans.append(sb.toString());
            }
        }
        return ans.toString();
    }
}
