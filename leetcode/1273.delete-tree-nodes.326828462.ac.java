/*
 * @lc app=leetcode id=1273 lang=java
 *
 * [1273] Delete Tree Nodes
 *
 * https://leetcode.com/problems/delete-tree-nodes/description/
 *
 * algorithms
 * Medium (62.97%)
 * Total Accepted:    6.2K
 * Total Submissions: 9.8K
 * Testcase Example:  '7\n[-1,0,0,1,2,2,2]\n[1,-2,4,0,-2,-1,-1]'
 *
 * A tree rooted at node 0 is given as follows:
 * 
 * 
 * The number of nodes is nodes;
 * The value of the i-th node is value[i];
 * The parent of the i-th node is parent[i].
 * 
 * 
 * Remove every subtree whose sum of values of nodes is zero.
 * 
 * After doing so, return the number of nodes remaining in the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]
 * Output: 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nodes = 5, parent = [-1,0,1,0,0], value = [-672,441,18,728,378]
 * Output: 5
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: nodes = 5, parent = [-1,0,0,1,1], value = [-686,-842,616,-739,-746]
 * Output: 5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nodes <= 10^4
 * parent.length == nodes
 * 0 <= parent[i] <= nodes - 1
 * parent[0] == -1 which indicates that 0 is the root.
 * value.length == nodes
 * -10^5 <= value[i] <= 10^5
 * The given input is guaranteed to represent a valid tree.
 * 
 * 
 */
class Solution {
    boolean[] visited;
    
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] child = new int[nodes];
        
        for (int i = 0; i < nodes; i++) {
            int p = parent[i];
            if (p >= 0)
                child[p]++;
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < nodes; i++)
            if (child[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int p = parent[cur];
            if (p >= 0) {
                value[p] += value[cur];
                child[p]--;
                if (child[p] == 0)
                    queue.offer(p);
            }
        }
        
        visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++)
            if (!visited[i])
                zero(i, parent, value);
        int ans = 0;
        for (int x : value)
            if (x != 0)
                ans++;
        return ans;
    }

    
    void zero(int st, int[] parent, int[] value) {
        if (visited[st])
            return;
        visited[st] = true;
        if (value[st] == 0)
            return;
        int p = parent[st];
        if (p < 0)
            return;
        zero(p, parent, value);
        if (value[p] == 0) {
            value[st] = 0;
            return;
        }
        return;
    }
    
    public int deleteTreeNodes1(int nodes, int[] parent, int[] value) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        int root = 0;
        for (int i = 0; i < nodes; i++) {
            if (parent[i] == -1)
                root = i;
            else {
                Set<Integer> set = tree.get(parent[i]);
                if (set == null) {
                    set = new HashSet<>();
                    tree.put(parent[i], set);
                }
                set.add(i);
            }
        }
        dfs(tree, root, value);
        return cnt(tree, root, value);
    }
    
    int dfs(Map<Integer, Set<Integer>> tree, int root, int[] value) {
        if (!tree.containsKey(root))
            return value[root];
        for (int next : tree.get(root)) {
            value[root] += dfs(tree, next, value);
        }
        return value[root];
    }
    
    int cnt(Map<Integer, Set<Integer>> tree, int root, int[] value) {
        if (value[root] == 0)
            return 0;
        if (!tree.containsKey(root)) {
            return 1;
        }
        int ans = 1;
        for (int next : tree.get(root)) {
            ans += cnt(tree, next, value);
        }
        return ans;
    }
}
