/*
 * @lc app=leetcode id=1452 lang=java
 *
 * [1452] People Whose List of Favorite Companies Is Not a Subset of Another List
 *
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/description/
 *
 * algorithms
 * Medium (54.71%)
 * Total Accepted:    13.8K
 * Total Submissions: 25.2K
 * Testcase Example:  '[["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]\r'
 *
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of
 * favorites companies for the ith person (indexed from 0).
 * 
 * Return the indices of people whose list of favorite companies is not a
 * subset of any other list of favorites companies. You must return the indices
 * in increasing order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: favoriteCompanies =
 * [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * Output: [0,1,4] 
 * Explanation: 
 * Person with index=2 has favoriteCompanies[2]=["google","facebook"] which is
 * a subset of favoriteCompanies[0]=["leetcode","google","facebook"]
 * corresponding to the person with index 0. 
 * Person with index=3 has favoriteCompanies[3]=["google"] which is a subset of
 * favoriteCompanies[0]=["leetcode","google","facebook"] and
 * favoriteCompanies[1]=["google","microsoft"]. 
 * Other lists of favorite companies are not a subset of another list,
 * therefore, the answer is [0,1,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: favoriteCompanies =
 * [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * Output: [0,1] 
 * Explanation: In this case favoriteCompanies[2]=["facebook","google"] is a
 * subset of favoriteCompanies[0]=["leetcode","google","facebook"], therefore,
 * the answer is [0,1].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * Output: [0,1,2,3]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * All strings in favoriteCompanies[i] are distinct.
 * All lists of favorite companies are distinct, that is, If we sort
 * alphabetically each list then favoriteCompanies[i] !=
 * favoriteCompanies[j].
 * All strings consist of lowercase English letters only.
 * 
 * 
 */
class Solution {
    Set<String>[] sets;
    public List<Integer> peopleIndexes(List<List<String>> fc) {
        List<Integer> ans = new ArrayList<>();
        int n = fc.size();
        sets = new Set[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<String>();
            for (String s : fc.get(i))
                sets[i].add(s);
        }
        for (int i = 0; i < n; i++) {
            boolean is = true;
            for (int j = 0; j < n; j++)
                if (check(i, j)) {
                    is = false;
                    break;
                }
            if (is)
                ans.add(i);
        }
        return ans;
    }
    
    boolean check(int x, int y) {
        if (x == y || sets[x].size() > sets[y].size())
            return false;
        for (String s : sets[x])
            if (!sets[y].contains(s))
                return false;
        return true;
    }
}
