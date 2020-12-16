/*
 * @lc app=leetcode id=1490 lang=java
 *
 * [1490] Clone N-ary Tree
 *
 * https://leetcode.com/problems/clone-n-ary-tree/description/
 *
 * algorithms
 * Medium (83.90%)
 * Total Accepted:    6.5K
 * Total Submissions: 7.7K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given a root of an N-ary tree, return a deep copy (clone) of the tree.
 * 
 * Each node in the n-ary tree contains a val (int) and a list (List[Node]) of
 * its children.
 * 
 * 
 * class Node {
 * ⁠   public int val;
 * ⁠   public List<Node> children;
 * }
 * 
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 * 
 * Follow up: Can your solution work for the graph problem?
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,null,3,2,4,null,5,6]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output:
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node cloneTree(Node root) {
        if (root == null)
            return null;
        Node c = new Node(root.val);
        if (root.children != null) {
            c.children = new ArrayList<>();
            for (Node n : root.children)
                c.children.add(cloneTree(n));
        }
        return c;
    }
}
