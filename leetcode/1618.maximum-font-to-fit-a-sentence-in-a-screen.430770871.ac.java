/*
 * @lc app=leetcode id=1618 lang=java
 *
 * [1618] Maximum Font to Fit a Sentence in a Screen
 *
 * https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/description/
 *
 * algorithms
 * Medium (58.41%)
 * Total Accepted:    906
 * Total Submissions: 1.6K
 * Testcase Example:  '"helloworld"\n80\n20\n[6,8,10,12,14,16,18,24,36]'
 *
 * You are given a string text. We want to display text on a screen of width w
 * and height h. You can choose any font size from array fonts, which contains
 * the available font sizes in ascending order.
 * 
 * You can use the FontInfo interface to get the width and height of any
 * character at any available font size.
 * 
 * The FontInfo interface is defined as such:
 * 
 * 
 * interface FontInfo {
 * ⁠ // Returns the width of character ch on the screen using font size
 * fontSize.
 * ⁠ // O(1) per call
 * ⁠ public int getWidth(int fontSize, char ch);
 * 
 * ⁠ // Returns the height of any character on the screen using font size
 * fontSize.
 * ⁠ // O(1) per call
 * ⁠ public int getHeight(int fontSize);
 * }
 * 
 * The calculated width of text for some fontSize is the sum of every
 * getWidth(fontSize, text[i]) call for each 0 <= i < text.length (0-indexed).
 * The calculated height of text for some fontSize is getHeight(fontSize). Note
 * that text is displayed on a single line.
 * 
 * It is guaranteed that FontInfo will return the same value if you call
 * getHeight or getWidth with the same parameters.
 * 
 * It is also guaranteed that for any font size fontSize and any character
 * ch:
 * 
 * 
 * getHeight(fontSize) <= getHeight(fontSize+1)
 * getWidth(fontSize, ch) <= getWidth(fontSize+1, ch)
 * 
 * 
 * Return the maximum font size you can use to display text on the screen. If
 * text cannot fit on the display with any font size, return -1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text = "helloworld", w = 80, h = 20, fonts =
 * [6,8,10,12,14,16,18,24,36]
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text = "leetcode", w = 1000, h = 50, fonts = [1,2,4]
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text = "easyquestion", w = 100, h = 100, fonts = [10,15,20,25]
 * Output: -1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text.length <= 50000
 * text contains only lowercase English letters.
 * 1 <= w <= 10^7
 * 1 <= h <= 10^4
 * 1 <= fonts.length <= 10^5
 * 1 <= fonts[i] <= 10^5
 * fonts is sorted in ascending order and does not contain duplicates.
 * 
 */
/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0, r = fonts.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            if (check(text, w, h, fonts[m], fontInfo))
                l = m+1;
            else
                r = m-1;
        }
        return r < 0 ? -1 : fonts[r];
    }
    
    boolean check(String txt, int w, int h, int fs, FontInfo fontInfo) {
        h /= fontInfo.getHeight(fs);
        if (h > 0)
            h = 1;
        else
            return false;
        int len = 0;
        for (char c : txt.toCharArray()) {
            int lc = fontInfo.getWidth(fs, c);
            len += lc;
            if (len > w) {
                len = lc;
                if (--h <= 0)
                    break;
            }
        }
        return h > 0;
    }
}
