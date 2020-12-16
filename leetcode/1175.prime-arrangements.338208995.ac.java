/*
 * @lc app=leetcode id=1175 lang=java
 *
 * [1175] Prime Arrangements
 *
 * https://leetcode.com/problems/prime-arrangements/description/
 *
 * algorithms
 * Easy (51.56%)
 * Total Accepted:    13.7K
 * Total Submissions: 26.5K
 * Testcase Example:  '5'
 *
 * Return the number of permutations of 1 to n so that prime numbers are at
 * prime indices (1-indexed.)
 * 
 * (Recall that an integer is prime if and only if it is greater than 1, and
 * cannot be written as a product of two positive integers both smaller than
 * it.)
 * 
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1]
 * is not because the prime number 5 is at index 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 100
 * Output: 682289015
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 100
 * 
 * 
 */
class Solution {
    int max = 1_000_000_007;
    public int numPrimeArrangements(int n) {
        if (n < 3)
            return 1;
        int x = cnt(n);
        long ans = f(n-x)*f(x)%max;
        return (int) ans;
    }
    
    int cnt(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean is = true;
            for (int x : ls)
                if (i%x == 0) {
                    is = false;
                    break;
                }
            if (is)
                ls.add(i);
        }
        return ls.size();
    }
    
    long f(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++)
            ans = ans * i % max;
        return ans;
    }
}
