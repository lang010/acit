/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (37.47%)
 * Total Accepted:    186.1K
 * Total Submissions: 496.7K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 * 
 * Note:
 * 
 * 
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 * 
 * 
 */
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ls : tickets) {
            List<String> dest = map.get(ls.get(0));
            if (dest == null) {
                dest = new ArrayList<>();
                map.put(ls.get(0), dest);
            }
            dest.add(ls.get(1));
        }
        for (List<String> ls : map.values()) {
            Collections.sort(ls, (a, b) -> b.compareTo(a));
        }
        return dfs("JFK");
    }
    
    List<String> dfs(String st) {
        List<String> ans = new ArrayList<>();
        List<String> end = null;
        ans.add(st);
        List<String> tos = map.get(st);
        while (tos != null && tos.size() > 0) {
            String s = tos.remove(tos.size()-1);
            List<String> f = dfs(s);
            if (!st.equals(f.get(f.size()-1))) {
                end = f;
            } else {
                ans.addAll(f);
            }
        }
        if (end != null)
            ans.addAll(end);
        return ans;
    }
}
