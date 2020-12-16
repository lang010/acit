/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (56.67%)
 * Total Accepted:    113.2K
 * Total Submissions: 199.8K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1:
 * 
 * 
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * Example 2:
 * 
 * 
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */
class Solution {
    
    List<Integer> nums = new ArrayList<>();
    List<Character> operators = new ArrayList<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        parse(input);
        List<Integer> ans = dc(0, operators.size()-1);
        return ans;
    }
    
    void parse(String str) {
        int cur = 0;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                cur = cur*10 + c - '0';
            } else {
                nums.add(cur);
                cur = 0;
                operators.add(c);
            }
        }
        nums.add(cur);
    }
    
    List<Integer> dc(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        if (l > r) {
            ans.add(nums.get(l));
            return ans;
        }
        if (l == r) {
            ans.add(compute(nums.get(l), nums.get(l+1), operators.get(l)));
            return ans;
        }
        for (int i = l; i <= r; i++) {
            List<Integer> left = dc(l, i-1);
            List<Integer> right = dc(i+1, r);
            for (int x : left)
                for (int y : right) {
                    ans.add(compute(x, y, operators.get(i)));
                }
        }
        return ans;
    }
    
    int compute(int x, int y, char operator) {
        switch (operator) {
            case '-':
                return x-y;
            case '+':
                return x+y;
            case '*':
                return x*y;
        }
        return -1;
    }
}
