/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 *
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * algorithms
 * Medium (50.72%)
 * Total Accepted:    111.2K
 * Total Submissions: 219.2K
 * Testcase Example:  '[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]'
 *
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts.  Two accounts definitely belong
 * to the same person if there is some email that is common to both accounts.
 * Note that even if two accounts have the same name, they may belong to
 * different people as people could have the same name.  A person can have any
 * number of accounts initially, but all of their accounts definitely have the
 * same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order.  The accounts themselves can be returned in any
 * order.
 * 
 * Example 1:
 * 
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John",
 * "johnnybravo@mail.com"], ["John", "johnsmith@mail.com",
 * "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email
 * "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email
 * addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary',
 * 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']]
 * would still be accepted.
 * 
 * 
 * 
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * 
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> ufs = new HashMap<>();
        List<Set<String>> mails = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (List<String> ls : accounts) {
            int id = -1;
            for (int i = 1; i < ls.size(); i++) {
                String s = ls.get(i);
                if (ufs.containsKey(s)) {
                    id = ufs.get(s);
                    break;
                }
            }
            Set<String> acc;
            if (id >= 0) {
                acc = mails.get(id);
                for (int i = 1; i < ls.size(); i++) {
                    String s = ls.get(i);
                    if (ufs.containsKey(s)) {
                        int existId = ufs.get(s);
                        if (existId != id) {
                            for (String str : mails.get(existId)) {
                                ufs.put(str, id);
                                acc.add(str);
                            }
                        }
                    } else {
                        acc.add(s);
                        ufs.put(s, id);
                    }
                }
            } else {
                acc = new HashSet<>();
                names.add(ls.get(0));
                id = mails.size();
                mails.add(acc);
                for (int i = 1; i < ls.size(); i++) {
                    acc.add(ls.get(i));
                    ufs.put(ls.get(i), id);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < mails.size(); i++) {
            if (ufs.get(mails.get(i).iterator().next()) != i)
                continue;
            List<String> ls = new ArrayList<>(mails.get(i));
            Collections.sort(ls);
            ls.add(0, names.get(i));
            ans.add(ls);
        }
        
        return ans;
    }
}
