/*
 * @lc app=leetcode id=1169 lang=java
 *
 * [1169] Invalid Transactions
 *
 * https://leetcode.com/problems/invalid-transactions/description/
 *
 * algorithms
 * Medium (31.55%)
 * Total Accepted:    21.9K
 * Total Submissions: 69.5K
 * Testcase Example:  '["alice,20,800,mtv","alice,50,100,beijing"]'
 *
 * A transaction is possibly invalid if:
 * 
 * 
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with
 * the same name in a different city.
 * 
 * 
 * Each transaction string transactions[i] consists of comma separated values
 * representing the name, time (in minutes), amount, and city of the
 * transaction.
 * 
 * Given a list of transactions, return a list of transactions that are
 * possibly invalid.  You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction
 * occurs within a difference of 60 minutes, have the same name and is in a
 * different city. Similarly the second one is invalid too.
 * 
 * Example 2:
 * 
 * 
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have
 * lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and
 * 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and
 * 2000.
 * 
 * 
 */
class Solution {
    static class Trans {
        String s;
        String name;
        int tm;
        int tot;
        String city;
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        List<Trans> trs = new ArrayList<>();
        for (String tr: transactions) {
            String[] arr = tr.split(",");
            Trans t = new Trans();
            t.s = tr;
            t.name = arr[0];
            t.tm = Integer.valueOf(arr[1]);
            t.tot = Integer.valueOf(arr[2]);
            t.city = arr[3];
            trs.add(t);
        }
        for (Trans t1 : trs)
            for (Trans t2 : trs)
                if (t1.tot > 1000 || t1.name.equals(t2.name) && !t1.city.equals(t2.city) && Math.abs(t1.tm - t2.tm) <= 60) {
                    ans.add(t1.s);
                    break;
                }
        
        return ans;
    }
}
