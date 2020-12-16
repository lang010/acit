/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 *
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (45.89%)
 * Total Accepted:    45.1K
 * Total Submissions: 98.4K
 * Testcase Example:  '1'
 *
 * Given the API rand7() that generates a uniform random integer in the range
 * [1, 7], write a function rand10() that generates a uniform random integer in
 * the range [1, 10]. You can only call the API rand7(), and you shouldn't call
 * any other API. Please do not use a language's built-in random API.
 * 
 * Each test case will have one internal argument n, the number of times that
 * your implemented function rand10() will be called while testing. Note that
 * this is not an argument passed to rand10().
 * 
 * Follow up:
 * 
 * 
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * 
 * 
 * 
 * Example 1:
 * Input: n = 1
 * Output: [2]
 * Example 2:
 * Input: n = 2
 * Output: [2,8]
 * Example 3:
 * Input: n = 3
 * Output: [3,8,10]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * 
 * 
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int x = 7;
        int y = rand7();
        while (x == 7)
            x = rand7();
        x = (x-1) * 7 + y - 1;
        if (x < 40)
            return x % 10+1;
        return rand10();
    }
}
