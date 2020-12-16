/*
 * @lc app=leetcode id=1647 lang=java
 *
 * [1647] Minimum Deletions to Make Character Frequencies Unique
 *
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
 *
 * algorithms
 * Medium (53.27%)
 * Total Accepted:    10K
 * Total Submissions: 18.8K
 * Testcase Example:  '"aab"'
 *
 * A string s is called good if there are no two different characters in s that
 * have the same frequency.
 * 
 * Given a string s, return the minimum number of characters you need to delete
 * to make s good.
 * 
 * The frequency of a character in a string is the number of times it appears
 * in the string. For example, in the string "aab", the frequency of 'a' is 2,
 * while the frequency of 'b' is 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aab"
 * Output: 0
 * Explanation: s is already good.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaabbbcc"
 * Output: 2
 * Explanation: You can delete two 'b's resulting in the good string "aaabcc".
 * Another way it to delete one 'b' and one 'c' resulting in the good string
 * "aaabbc".
 * 
 * Example 3:
 * 
 * 
 * Input: s = "ceabaacb"
 * Output: 2
 * Explanation: You can delete both 'c's resulting in the good string "eabaab".
 * Note that we only care about characters that are still in the string at the
 * end (i.e. frequency of 0 is ignored).
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s contains only lowercase English letters.
 * 
 * 
 */
class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            cnt[c-'a']++;
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 24; i >= 0 && cnt[i] > 0; i--)
            if (cnt[i] >= cnt[i+1]) {
                int v = Math.max(0, cnt[i+1]-1);
                ans += cnt[i]-v;
                cnt[i] = v;
            }
        return ans;
    }
}
