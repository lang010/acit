/*
 * @lc app=leetcode id=866 lang=java
 *
 * [866] Prime Palindrome
 *
 * https://leetcode.com/problems/prime-palindrome/description/
 *
 * algorithms
 * Medium (25.07%)
 * Total Accepted:    20.3K
 * Total Submissions: 80.9K
 * Testcase Example:  '6'
 *
 * Find the smallest prime palindrome greater than or equal to N.
 * 
 * Recall that a number is prime if it's only divisors are 1 and itself, and it
 * is greater than 1. 
 * 
 * For example, 2,3,5,7,11 and 13 are primes.
 * 
 * Recall that a number is a palindrome if it reads the same from left to right
 * as it does from right to left. 
 * 
 * For example, 12321 is a palindrome.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 6
 * Output: 7
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 8
 * Output: 11
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 13
 * Output: 101
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 * 
 * 
 */
class Solution {
    
    int[] sm = {2, 3, 5, 7, 11};
    
    public int primePalindrome(int N) {
        if (N <= 11)
            for (int x : sm)
                if (x >= N)
                    return x;
        for (int i = 10; i < 100000; i++) {
            int v = build(i);
            if (v >= N && isPrime(v))
                return v;
        }
        return -1;
    }
    
    int build(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        return Integer.valueOf(s + sb.reverse().toString().substring(1));
    }
    
    boolean isPrime(int x) {
        if (x % 2 == 0)
            return false;
        for (int i = 3; i*i <= x; i += 2)
            if (x%i == 0)
                return false;
        return true;
    }
}
