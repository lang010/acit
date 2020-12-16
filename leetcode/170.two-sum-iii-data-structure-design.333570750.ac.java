/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 *
 * algorithms
 * Easy (34.59%)
 * Total Accepted:    93.9K
 * Total Submissions: 271.4K
 * Testcase Example:  '["TwoSum","add","add","add","find","find"]\n[[],[1],[3],[5],[4],[7]]'
 *
 * Design a data structure that accepts a stream of integers and checks if it
 * has a pair of integers that sum up to a particular value.
 * 
 * Implement the TwoSum class:
 * 
 * 
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers
 * whose sum is equal to value, otherwise, it returns false.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * Output
 * [null, null, null, null, true, false]
 * 
 * Explanation
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4, return true
 * twoSum.find(7);  // No two integers sum up to 7, return false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -10^5 <= number <= 10^5
 * -2^31 <= value <= 2^31 - 1
 * At most 5 * 10^4 calls will be made to add and find.
 * 
 * 
 */
class TwoSum {
    
    Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TwoSum() {
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int x) {
        map.put(x, map.getOrDefault(x, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int x : map.keySet()) {
            if (x + x == value) {
                if (map.get(x) > 1)
                    return true;
            } else {
                if (map.containsKey(value-x))
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
