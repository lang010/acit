/*
 * @lc app=leetcode id=948 lang=java
 *
 * [948] Bag of Tokens
 *
 * https://leetcode.com/problems/bag-of-tokens/description/
 *
 * algorithms
 * Medium (46.21%)
 * Total Accepted:    30.4K
 * Total Submissions: 65.7K
 * Testcase Example:  '[100]\n50'
 *
 * You have an initial power of P, an initial score of 0, and a bag of tokens
 * where tokens[i] is the value of the i^th token (0-indexed).
 * 
 * Your goal is to maximize your total score by potentially playing each token
 * in one of two ways:
 * 
 * 
 * If your current power is at least tokens[i], you may play the i^th token
 * face up, losing tokens[i] power and gaining 1 score.
 * If your current score is at least 1, you may play the i^th token face down,
 * gaining tokens[i] power and losing 1 score.
 * 
 * 
 * Each token may be played at most once and in any order. You do not have to
 * play all the tokens.
 * 
 * Return the largest possible score you can achieve after playing any number
 * of tokens.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tokens = [100], P = 50
 * Output: 0
 * Explanation: Playing the only token in the bag is impossible because you
 * either have too little power or too little score.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tokens = [100,200], P = 150
 * Output: 1
 * Explanation: Play the 0^th token (100) face up, your power becomes 50 and
 * score becomes 1.
 * There is no need to play the 1^st token since you cannot play it face up to
 * add to your score.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = [100,200,300,400], P = 200
 * Output: 2
 * Explanation: Play the tokens in this order to get a score of 2:
 * 1. Play the 0^th token (100) face up, your power becomes 100 and score
 * becomes 1.
 * 2. Play the 3^rd token (400) face down, your power becomes 500 and score
 * becomes 0.
 * 3. Play the 1^st token (200) face up, your power becomes 300 and score
 * becomes 1.
 * 4. Play the 2^nd token (300) face up, your power becomes 0 and score becomes
 * 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= tokens.length <= 1000
 * 0 <= tokens[i], P < 10^4
 * 
 */
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length-1;
        int sc = 0;
        int max = 0;
        if (r < 0 || tokens[0] > P)
            return 0;
        while (l <= r) {
            while (l <= r && P >= tokens[l]) {
                P -= tokens[l++];
                max = Math.max(max, ++sc);
            }
            if (l <= r)
                P += tokens[r--];
            sc--;
        }
        return max;
    }
}
