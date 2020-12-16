/*
 * @lc app=leetcode id=640 lang=java
 *
 * [640] Solve the Equation
 *
 * https://leetcode.com/problems/solve-the-equation/description/
 *
 * algorithms
 * Medium (42.52%)
 * Total Accepted:    26.9K
 * Total Submissions: 63.2K
 * Testcase Example:  '"x+5-3+x=6+x-2"'
 *
 * 
 * Solve a given equation and return the value of x in the form of string
 * "x=#value". The equation contains only '+', '-' operation, the variable x
 * and its coefficient.
 * 
 * 
 * 
 * If there is no solution for the equation, return "No solution".
 * 
 * 
 * If there are infinite solutions for the equation, return "Infinite
 * solutions".
 * 
 * 
 * If there is exactly one solution for the equation, we ensure that the value
 * of x is an integer.
 * 
 * 
 * Example 1:
 * 
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "x=x"
 * Output: "Infinite solutions"
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "2x=x"
 * Output: "x=0"
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * 
 * 
 * 
 * Example 5:
 * 
 * Input: "x=x+2"
 * Output: "No solution"
 * 
 * 
 */
class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] l = helper(eq[0]);
        int[] r = helper(eq[1]);
        if (l[0] == r[0]) {
            return l[1] == r[1] ? "Infinite solutions" : "No solution";
        }
        return "x=" + (l[1]-r[1])/(r[0]-l[0]);
    }
    
    int[] helper(String s) {
        s = s.replaceAll("-", "+-");
        String[] arr = s.split("\\+");
        int[] ans = new int[2];
        for (String st : arr) {
            int n = st.length() - 1;
            if (n < 0)
                continue;
            if (st.charAt(n) == 'x') {
                if (n == 0)
                    ans[0]++;
                else if (n == 1 && st.charAt(0) == '-')
                    ans[0]--;
                else
                    ans[0] += Integer.valueOf(st.substring(0, n));
            }
            else
                ans[1] += Integer.valueOf(st);
        }
        return ans;
    }
}
