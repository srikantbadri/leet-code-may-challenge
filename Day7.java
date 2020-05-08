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
    class nodeParam{
        TreeNode node;
        int height;
        int parent;
        nodeParam(TreeNode node, int height, int parent){
            this.node=node;
            this.height=height;
            this.parent=parent;
        }
    }
    Map<Integer,nodeParam> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        calculateHeights(root,0,-1);
        nodeParam nodeX = map.get(x);
        nodeParam nodeY = map.get(y);
        if(nodeX.height == nodeY.height && nodeX.parent != nodeY.parent)
            return true;
        return false;
    }
    public void calculateHeights(TreeNode node, int height, int parent){
        if(node == null) 
            return; 
        nodeParam param = new nodeParam(node, height, parent);
        map.put(node.val,param);
        calculateHeights(node.left,height+1,node.val);
        calculateHeights(node.right,height+1,node.val);
    }
}
