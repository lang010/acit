/*
 * @lc app=leetcode id=1570 lang=java
 *
 * [1570] Dot Product of Two Sparse Vectors
 *
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/description/
 *
 * algorithms
 * Medium (91.57%)
 * Total Accepted:    16.4K
 * Total Submissions: 17.9K
 * Testcase Example:  '[1,0,0,2,3]\n[0,3,0,4,0]'
 *
 * Given two sparse vectors, compute their dot product.
 * 
 * Implement class SparseVector:
 * 
 * 
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector
 * and vec
 * 
 * 
 * A sparse vector is a vector that has mostly zero values, you should store
 * the sparse vector efficiently and compute the dot product between two
 * SparseVector.
 * 
 * Follow up: What if only one of the vectors is sparse?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
 * Output: 8
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
 * Output: 0
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
 * Output: 6
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums1.length == nums2.length
 * 1 <= n <= 10^5
 * 0 <= nums1[i], nums2[i] <= 100
 * 
 * 
 */
class SparseVector {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (map.size() > vec.map.size())
            return vec.dotProduct(this);
        int ans = 0;
        for (int x : map.keySet()) {
            ans += map.get(x) * vec.map.getOrDefault(x, 0);
        }
        
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
