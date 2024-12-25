/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer>result=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            int max=Integer.MIN_VALUE;
            while(n-->0){
                TreeNode node=queue.remove();
                max=Math.max(node.val,max);
                if(node.left!=null){
                    queue.add(node.left);
                }
                  if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        
       return result; 
    }
}