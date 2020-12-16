/*
 * @lc app=leetcode id=1641 lang=java
 *
 * [1641] Count Sorted Vowel Strings
 *
 * https://leetcode.com/problems/count-sorted-vowel-strings/description/
 *
 * algorithms
 * Medium (75.92%)
 * Total Accepted:    13.3K
 * Total Submissions: 17.5K
 * Testcase Example:  '1'
 *
 * Given an integer n, return the number of strings of length n that consist
 * only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * 
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are
 * ["a","e","i","o","u"].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * 
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the
 * alphabet.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 33
 * Output: 66045
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 50 
 * 
 * 
 */
class Solution {
    public int countVowelStrings(int n) {
        int[] dp = {1, 1, 1, 1, 1};
        for (int i = 2; i <= n; i++) {
            for (int j = 4; j > 0; j--)
                for (int k = 0; k < j; k++)
                    dp[j] += dp[k];
        }
        int sum = 0;
        for (int x : dp)
            sum += x;
        return sum;
    }
}
