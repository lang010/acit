/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 *
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/description/
 *
 * algorithms
 * Medium (43.17%)
 * Total Accepted:    21K
 * Total Submissions: 48.6K
 * Testcase Example:  '["joe","joe","joe","james","james","james","james","mary","mary","mary"]\n' +
  '[1,2,3,4,5,6,7,8,9,10]\n' +
  '["home","about","career","home","cart","maps","home","home","about","career"]'
 *
 * We are given some website visits: the user with name username[i] visited the
 * website website[i] at time timestamp[i].
 * 
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by
 * the time of their visits.  (The websites in a 3-sequence are not necessarily
 * distinct.)
 * 
 * Find the 3-sequence visited by the largest number of users. If there is more
 * than one solution, return the lexicographically smallest such
 * 3-sequence.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: username =
 * ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
 * timestamp = [1,2,3,4,5,6,7,8,9,10], website =
 * ["home","about","career","home","cart","maps","home","home","about","career"]
 * Output: ["home","about","career"]
 * Explanation: 
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2
 * users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1
 * user.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 3 <= N = username.length = timestamp.length = website.length <= 50
 * 1 <= username[i].length <= 10
 * 0 <= timestamp[i] <= 10^9
 * 1 <= website[i].length <= 10
 * Both username[i] and website[i] contain only lowercase characters.
 * It is guaranteed that there is at least one user who visited at least 3
 * websites.
 * No user visits two websites at the same time.
 * 
 * 
 */
class Solution {
    static class Visit {
        int time;
        String web;
        Visit(int tm, String web) {
            time = tm;
            this.web = web;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Visit>> map = new HashMap<>(); 
        for (int i = 0; i < n; i++) {
            List<Visit> ls = map.get(username[i]);
            if (ls == null) {
                ls = new ArrayList<>();
                map.put(username[i], ls);
            }
            ls.add(new Visit(timestamp[i], website[i]));
        }

        Map<String, Integer> vs = new HashMap<>();
        for (List<Visit> ll : map.values()) {
            Collections.sort(ll, (a, b) -> a.time - b.time);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < ll.size(); i++)
                for (int j = i+1; j < ll.size(); j++)
                    for (int k = j+1; k < ll.size(); k++) {
                        String s = String.format("%s#%s#%s", ll.get(i).web, ll.get(j).web, ll.get(k).web);
                        if (!set.contains(s)) {
                            set.add(s);
                            vs.put(s, vs.getOrDefault(s, 0)+1);
                        }
                    }
        }
        int max = 0;
        String maxS = null;
        for (String s : vs.keySet()) {
            if (max < vs.get(s)) {
                maxS = s;
                max = vs.get(s);
            } else if (max == vs.get(s) && s.compareTo(maxS) < 0)
                maxS = s;
        }
        return Arrays.asList(maxS.split("#"));
    }
}
