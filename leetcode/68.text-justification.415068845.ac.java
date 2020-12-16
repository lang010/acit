/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 *
 * https://leetcode.com/problems/text-justification/description/
 *
 * algorithms
 * Hard (28.90%)
 * Total Accepted:    151.8K
 * Total Submissions: 525.2K
 * Testcase Example:  '["This", "is", "an", "example", "of", "text", "justification."]\n16'
 *
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right)
 * justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only.
 * Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth.
 * The input array words contains at least one word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: words = ["This", "is", "an", "example", "of", "text",
 * "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * 
 * Example 2:
 * 
 * 
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth
 * = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall
 * be", because the last line must be left-justified instead of
 * fully-justified.
 * Note that the second line is also left-justified becase it contains only one
 * word.
 * 
 * Example 3:
 * 
 * 
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"],
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * ⁠ "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 * 
 * 
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int l = 0;
        int sum = words[0].length();
        for (int i = 1; i < n; i++) {
            if (sum + words[i].length() + 1 > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int diff = maxWidth - sum;
                for (int j = l; j < i; j++) {
                    if (j > l) {
                        int t = diff/(i-l-1) + 1;
                        t += (j-l) <= diff%(i-l-1) ? 1 : 0;
                        while (t-- > 0)
                            sb.append(' ');
                    }
                    sb.append(words[j]);
                }
                for (int j = sb.length(); j < maxWidth; j++)
                    sb.append(' ');
                
                ans.add(sb.toString());
                sum = words[i].length();
                l = i;
            } else {
                sum += words[i].length() + 1;
            }
        }
        StringBuilder sb = new StringBuilder(words[l++]);
        while (l < n) {
            sb.append(' ');
            sb.append(words[l++]);
        }
        for (int i = sb.length(); i < maxWidth; i++)
            sb.append(' ');
        ans.add(sb.toString());
        return ans;
    }
}
