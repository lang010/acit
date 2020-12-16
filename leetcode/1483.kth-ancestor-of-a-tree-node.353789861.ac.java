/*
 * @lc app=leetcode id=1483 lang=java
 *
 * [1483] Kth Ancestor of a Tree Node
 *
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/description/
 *
 * algorithms
 * Hard (29.71%)
 * Total Accepted:    9.1K
 * Total Submissions: 30.8K
 * Testcase Example:  '["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]\n' +
  '[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]'
 *
 * You are given a tree with n nodes numbered from 0 to n-1 in the form of a
 * parent array where parent[i] is the parent of node i. The root of the tree
 * is node 0.
 * 
 * Implement the function getKthAncestor(int node, int k) to return the k-th
 * ancestor of the given node. If there is no such ancestor, return -1.
 * 
 * The k-th ancestor of a tree node is the k-th node in the path from that node
 * to the root.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * 
 * 
 * Input:
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * 
 * Output:
 * [null,1,0,-1]
 * 
 * Explanation:
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * 
 * treeAncestor.getKthAncestor(3, 1);  // returns 1 which is the parent of 3
 * treeAncestor.getKthAncestor(5, 2);  // returns 0 which is the grandparent of
 * 5
 * treeAncestor.getKthAncestor(6, 3);  // returns -1 because there is no such
 * ancestor
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= n <= 5*10^4
 * parent[0] == -1 indicating that 0 is the root node.
 * 0 <= parent[i] < n for all 0 < i < n
 * 0 <= node < n
 * There will be at most 5*10^4 queries.
 * 
 */
class TreeAncestor {
    
    int maxPow;
    int[][] par;

    public TreeAncestor(int n, int[] parent) {
        maxPow = (int) (Math.log(n)/Math.log(2) + 1);
        par = new int[maxPow][n];
        par[0] = parent;
        for (int i = 1; i < maxPow; i++) {
            for (int j = 0; j < n; j++) {
                int pre = par[i-1][j];
                par[i][j] = pre == -1 ? -1 : par[i-1][pre];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int max = maxPow;
        while (k > 0 && node > -1) {
            int p = 1 << max;
            if (k >= p) {
                k -= p;
                node = par[max][node];
            } else
                max--;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
