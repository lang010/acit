/*
 * @lc app=leetcode id=1616 lang=java
 *
 * [1616] Split Two Strings to Make Palindrome
 *
 * https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/
 *
 * algorithms
 * Medium (36.29%)
 * Total Accepted:    10.3K
 * Total Submissions: 28.4K
 * Testcase Example:  '"x"\n"y"'
 *
 * You are given two strings a and b of the same length. Choose an index and
 * split both strings at the same index, splitting a into two strings: aprefix
 * and asuffix where a = aprefix + asuffix, and splitting b into two strings:
 * bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix
 * or bprefix + asuffix forms a palindrome.
 * 
 * When you split a string s into sprefix and ssuffix, either ssuffix or
 * sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc",
 * "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
 * 
 * Return true if it is possible to form a palindrome string, otherwise return
 * false.
 * 
 * Notice that x + y denotes the concatenation of strings x and y.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: a = "x", b = "y"
 * Output: true
 * Explaination: If either a or b are palindromes the answer is true since you
 * can split in the following way:
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: a = "abdef", b = "fecab"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: a = "ulacfd", b = "jizalu"
 * Output: true
 * Explaination: Split them at index 3:
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: a = "xbdef", b = "xecab"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length, b.length <= 10^5
 * a.length == b.length
 * a and b consist of lowercase English letters
 * 
 * 
 */
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        String ar = new StringBuilder(a).reverse().toString();
        String br = new StringBuilder(b).reverse().toString();
        return check(a, b) || check(b, a) || check(ar, br) || check(br, ar);
    }
    
    boolean check(String a, String b) {
        int l = 0, r = a.length() - 1;
        boolean use = true;
        boolean useA = false;
        boolean useB = false;
        while (l < r) {
            if (use) {
                if (a.charAt(l) != b.charAt(r)) {
                    if (b.charAt(l) != b.charAt(r))
                        return false;
                    use = false;
                }
            } else if (b.charAt(l) != b.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
