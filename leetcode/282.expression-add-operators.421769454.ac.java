/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (36.37%)
 * Total Accepted:    119.5K
 * Total Submissions: 328.6K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= num.length <= 10
 * num only contain digits.
 * 
 * 
 */
class Solution {
    List<String> ans = new ArrayList<>();
    int tar;
    char[] chs;
    int n;
    public List<String> addOperators(String num, int target) {
        tar = target;
        chs = num.toCharArray();
        n = chs.length;
        if (n == 0)
            return ans;
        StringBuilder sb = new StringBuilder();
        //sb.append(chs[0]);
        dfs(0, sb);
        return ans;
    }
    
    void dfs(int i, StringBuilder sb) {
        if (i == n-1) {
            String s = sb.toString()+chs[i];
            if (check(s))
                ans.add(s);
            return;
        }
        sb.append(chs[i++]);
        
        sb.append('*');
        int sz = sb.length();
        dfs(i, sb);
        sb.delete(sz-1, sz);
        
        sb.append('+');
        dfs(i, sb);
        sb.delete(sz-1, sz);
        
        sb.append('-');
        dfs(i, sb);
        sb.delete(sz-1, sz);
        
        dfs(i, sb);
        
        sb.delete(sz-2, sz-1);
    }
    
    boolean check(String s) {
        return plus(s) == tar;
    }
    
    long plus(String s) {
        s = s.replaceAll("-", "+-");
        String[] arr = s.split("\\+");
        long ans = 0;
        for (String str : arr) {
            long val = times(str);
            if (val == Long.MAX_VALUE)
                return val;
            ans += val;
        }
        return ans;
    }
    
    long times(String s) {
        String[] arr = s.split("\\*");
        long ans = 1;
        for (String str : arr)
            if (str.startsWith("0") && str.length() > 1 || str.startsWith("-0") && str.length() > 2)
                return Long.MAX_VALUE;
            else
                ans *= Long.valueOf(str);
        return ans;
    }
}
