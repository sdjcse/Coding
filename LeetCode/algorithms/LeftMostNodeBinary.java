package LeetCode.algorithms;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Dhananjayan on 6/11/2017.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LeftMostNodeBinary {
    int maxHeight = 0;
    TreeNode leftMost = null,temp = null;
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9); */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new LeftMostNodeBinary().findBottomLeftValue(root));
    }
    public int findBottomLeftValue(TreeNode root) {
        maxHeight = 0;
        leftMost = root;
        heightUtil(root,0);
        return leftMost.val;
    }
    private void heightUtil(TreeNode root,int level){
        if(root == null){
            return;
        }
        if(level > maxHeight){
            maxHeight = level;
            leftMost = root;
        }
        heightUtil(root.left,level+1);
        heightUtil(root.right,level+1);
    }
}
