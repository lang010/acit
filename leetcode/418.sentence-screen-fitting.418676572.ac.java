/*
 * @lc app=leetcode id=418 lang=java
 *
 * [418] Sentence Screen Fitting
 *
 * https://leetcode.com/problems/sentence-screen-fitting/description/
 *
 * algorithms
 * Medium (32.88%)
 * Total Accepted:    47.4K
 * Total Submissions: 144.1K
 * Testcase Example:  '["hello","world"]\n2\n8'
 *
 * Given a rows x cols screen and a sentence represented by a list of non-empty
 * words, find how many times the given sentence can be fitted on the screen.
 * 
 * 
 * Note:
 * 
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word is greater than 0 and won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * 
 * 
 * 
 * 
 * Example 1: 
 * 
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]
 * 
 * Output: 
 * 1
 * 
 * Explanation:
 * hello---
 * world---
 * 
 * The character '-' signifies an empty space on the screen.
 * 
 * 
 * 
 * 
 * Example 2: 
 * 
 * Input:
 * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * 
 * Output: 
 * 2
 * 
 * Explanation:
 * a-bcd- 
 * e-a---
 * bcd-e-
 * 
 * The character '-' signifies an empty space on the screen.
 * 
 * 
 * 
 * 
 * Example 3: 
 * 
 * Input:
 * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * 
 * Output: 
 * 1
 * 
 * Explanation:
 * I-had
 * apple
 * pie-I
 * had--
 * 
 * The character '-' signifies an empty space on the screen.
 * 
 * 
 */
class Solution {
    
    Map<Integer, int[]> map = new HashMap<>();
    String[] words;
    int len;
    int w;
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int ans = 0;
        words = sentence;
        if (words[0].length() > cols)
            return ans;
        w = cols;
        int r = 0;
        int l = 0;
        for (String s : words)
            len += s.length()+1;
        while (r <= rows) {
            ans += l/len;
            l %= len;
            int[] d = helper(l);
            r += d[0];
            l = d[1];
            ans++;
        }
        return ans-1;
    }
    
    int[] helper(int l) {
        if (map.containsKey(l))
            return map.get(l);
        int[] ans = { 0, 0 };
        map.put(l, ans);
        for (String s : words) {
            if (s.length()+1 <= l)
                l -= s.length() + 1;
            else {
                l = w - s.length();
                ans[0]++;
            }
        }
        ans[1] = l;
        return ans;
    }
}
