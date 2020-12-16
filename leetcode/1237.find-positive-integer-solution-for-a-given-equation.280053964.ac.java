/*
 * @lc app=leetcode id=1237 lang=java
 *
 * [1237] Find Positive Integer Solution for a Given Equation
 *
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/description/
 *
 * algorithms
 * Easy (69.76%)
 * Total Accepted:    29.6K
 * Total Submissions: 42.4K
 * Testcase Example:  '1\n5'
 *
 * Given a function  f(x, y) and a value z, return all positive integer pairs x
 * and y where f(x,y) == z.
 * 
 * The function is constantly increasing, i.e.:
 * 
 * 
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * 
 * 
 * The function interface is defined like this: 
 * 
 * 
 * interface CustomFunction {
 * public:
 * // Returns positive integer f(x, y) for any given positive integer x and
 * y.
 * int f(int x, int y);
 * };
 * 
 * 
 * For custom testing purposes you're given an integer function_id and a target
 * z as input, where function_id represent one function from an secret internal
 * list, on the examples you'll know only two functions from the list.  
 * 
 * You may return the solutions in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: function_id = 1, z = 5
 * Output: [[1,4],[2,3],[3,2],[4,1]]
 * Explanation: function_id = 1 means that f(x, y) = x + y
 * 
 * Example 2:
 * 
 * 
 * Input: function_id = 2, z = 5
 * Output: [[1,5],[5,1]]
 * Explanation: function_id = 2 means that f(x, y) = x * y
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= function_id <= 9
 * 1 <= z <= 100
 * It's guaranteed that the solutions of f(x, y) == z will be on the range 1 <=
 * x, y <= 1000
 * It's also guaranteed that f(x, y) will fit in 32 bit signed integer if 1 <=
 * x, y <= 1000
 * 
 * 
 */
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        find(ret, customfunction, z, 1, 1, 1000, 1000);
        return ret;
    }
    void find(List<List<Integer>> ret, CustomFunction f, int z, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return;
        }
        int x = (x1+x2)/2;
        int y = (y1+y2)/2;
        int dz = check(ret, f, z, x, y);
        
        if (x1 == x && y1 == y) {
            if (x < x2) {
                check(ret, f, z, x+1, y);
            }
            if (y < y2) {
                check(ret, f, z, x, y+1);
            }
            if (x < x2 && y < y2) {
                check(ret, f, z, x+1, y+1);
            }
            return;
        }
        if (dz < 0) {
            find(ret, f, z, x1, y1, x, y);
        } else if (dz > 0) {
            find(ret, f, z, x, y, x2, y2);
        }
        find(ret, f, z, x+1, y1, x2, y-1);
        find(ret, f, z, x1, y+1, x-1, y2);
    }
    int check(List<List<Integer>> ret, CustomFunction f, int z, int x, int y) {
        int z0 = f.f(x, y);
        if (z0 == z) {
            List<Integer> r = new ArrayList<>(2);
            r.add(x);
            r.add(y);
            ret.add(r);          
        }
        return z - z0;
    }
}
