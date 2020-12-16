/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (29.79%)
 * Total Accepted:    78.5K
 * Total Submissions: 263.5K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings A and B of lowercase letters, return true if you can swap
 * two letters in A so the result is equal to B, otherwise, return false.
 * 
 * Swapping letters is defined as taking two indices i and j (0-indexed) such
 * that i != j and swapping the characters at A[i] and A[j]. For example,
 * swapping at indices 0 and 2 in "abcd" results in "cbad".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = "ab", B = "ba"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is
 * equal to B.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "ab", B = "ab"
 * Output: false
 * Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b',
 * which results in "ba" != B.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: A = "aa", B = "aa"
 * Output: true
 * Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is
 * equal to B.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: A = "", B = "aa"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist of lowercase letters.
 * 
 * 
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        int n = A.length();
        if (n != B.length())
            return false;
        int l, r;
        l = r = -1;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == B.charAt(i))
                cnt[c-'a']++;
            else {
                if (l < 0)
                    l = i;
                else if (r < 0)
                    r = i;
                else
                    return false;
            }
        }
        if (l >= 0 && r >= 0)
            return A.charAt(l) == B.charAt(r) && A.charAt(r) == B.charAt(l);
        if (l < 0 && r < 0)
            for (int i = 0; i < 26; i++)
                if (cnt[i] > 1)
                    return true;
        return false;
    }
}
