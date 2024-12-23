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
    public static  int getminswaps(int[] lval){
        int swaps=0;
        int[]sort=lval.clone();
        Arrays.sort(sort);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0; i<lval.length; i++){
            map.put(lval[i],i);
        }
        for(int i=0; i<lval.length; i++){
            if(lval[i]!=sort[i]){
                swaps++;
                int temp=map.get(sort[i]);
                map.put(lval[i],temp);
                lval[temp]=lval[i];
                
            }
        }
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int totalswap=0;
        while(!queue.isEmpty()){
            int levelsize=queue.size();
            int []lval=new int[levelsize];
            for(int i=0; i<levelsize; i++){
                TreeNode node=queue.poll();
                lval[i]=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            totalswap+=getminswaps(lval);
        }
        return totalswap;
    }
}