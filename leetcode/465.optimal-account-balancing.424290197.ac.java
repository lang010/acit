/*
 * @lc app=leetcode id=465 lang=java
 *
 * [465] Optimal Account Balancing
 *
 * https://leetcode.com/problems/optimal-account-balancing/description/
 *
 * algorithms
 * Hard (47.96%)
 * Total Accepted:    40.5K
 * Total Submissions: 84.4K
 * Testcase Example:  '[[0,1,10],[2,0,5]]'
 *
 * A group of friends went on holiday and sometimes lent each other money. For
 * example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5
 * for a taxi ride. We can model each transaction as a tuple (x, y, z) which
 * means person x gave person y $z. Assuming Alice, Bill, and Chris are person
 * 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can
 * be represented as [[0, 1, 10], [2, 0, 5]].
 * 
 * Given a list of transactions between a group of people, return the minimum
 * number of transactions required to settle the debt.
 * 
 * Note:
 * 
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we
 * could also have the persons 0, 2, 6.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * [[0,1,10], [2,0,5]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 * 
 * Two transactions are needed. One way to settle the debt is person #1 pays
 * person #0 and #2 $5 each.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 * 
 * Therefore, person #1 only need to give person #0 $4, and all debt is
 * settled.
 * 
 * 
 */
class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tr : transactions) {
            map.put(tr[0], map.getOrDefault(tr[0], 0) - tr[2]);
            map.put(tr[1], map.getOrDefault(tr[1], 0) + tr[2]);
        }
        List<Integer> ls = new ArrayList<>();
        map.forEach((a, b) -> {
            if (b != 0)
                ls.add(b);
        });
        return dfs(0, ls);
    }
    int dfs(int s, List<Integer> ls) {
        while (s < ls.size() && ls.get(s) == 0)
            s++;
        if (s == ls.size())
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = s+1; i < ls.size(); i++)
            if (ls.get(s) * ls.get(i) < 0) {
                ls.set(i, ls.get(i) + ls.get(s));
                ans = Math.min(ans, 1+dfs(s+1, ls));
                ls.set(i, ls.get(i) - ls.get(s));
            }
        return ans;
    }
}
