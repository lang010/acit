/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (42.71%)
 * Total Accepted:    35.3K
 * Total Submissions: 82.6K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * A gene string can be represented by an 8-character long string, with choices
 * from "A", "C", "G", "T".
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to
 * "end"), where ONE mutation is defined as ONE single character changed in the
 * gene string.
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * 
 * Also, there is a given gene "bank", which records all the valid gene
 * mutations. A gene must be in the bank to make it a valid gene string.
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is
 * the minimum number of mutations needed to mutate from "start" to "end". If
 * there is no such a mutation, return -1.
 * 
 * Note:
 * 
 * 
 * Starting point is assumed to be valid, so it might not be included in the
 * bank.
 * If multiple mutations are needed, all mutations during in the sequence must
 * be valid.
 * You may assume start and end string is not the same.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * return: 1
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * return: 2
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * return: 3
 * 
 * 
 * 
 * 
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        Set<String> set = new HashSet<>();
        for (String s : bank)
            set.add(s);
        if (!set.contains(end))
            return -1;
        set.remove(start);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            int cnt = map.get(s);
            Set<String> set1 =  new HashSet<>();
            for (String str : set)
                if (check(str, s)) {
                    if (str.equals(end))
                        return cnt+1;
                    map.put(str, cnt+1);
                    queue.offer(str);
                } else
                    set1.add(str);
            set = set1;
        }
        return -1;
    }
    
    boolean check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (cnt > 1)
                    return false;
            }
        return cnt == 1;
    }
}
