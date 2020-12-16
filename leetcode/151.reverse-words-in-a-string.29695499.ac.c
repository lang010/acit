/*
 * @lc app=leetcode id=151 lang=c
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (23.03%)
 * Total Accepted:    477.5K
 * Total Submissions: 2.1M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single
 * space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces
 * between two words. The returned string should only have a single space
 * separating the words. Do not include any extra spaces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * Could you solve it in-place with O(1) extra space?
 * 
 * 
 * 
 * 
 */

void reverse(char *s, int l, int r) {
  if (l < 0 || r < 0)
    return ;
  while (l < r) {
    char t = s[l];
    s[l] = s[r];
    s[r] = t;
    l++;
    r--;
  }
  return ;
}

void trim(char *s) {
  if (s[0] == 0)
    return ;
  int cnt = s[0] == ' ' ? 1 : 0;
  int i = 0;
  for (i = 1; s[i] != 0; i++) {
    if (s[i] == ' ' && s[i-1] == ' ')
      cnt++;
    else if (cnt > 0) {
      s[i-cnt] = s[i];
    }
  }
  if (s[i-cnt-1] == ' ')
    s[i-cnt-1] = 0;
  else
    s[i-cnt] = 0;
  return ;
}

void reverseWords(char *s) {
  int l = 0;
  int r = 0;
  trim(s);
  while (s[r] != 0) {
    r++;
    while (s[r] != ' ' && s[r] != 0) {
      r++;
    }
    reverse(s, l, r-1);
    l = r+1;
  }
  reverse(s, 0, r-1);
  return ;
}


