package LeetCode.algorithms;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;


public class LC_LargestValRow_515 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftRigt = new TreeNode(3);
        TreeNode rightRight = new TreeNode(9);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        left.right = leftRigt;
        right.right = rightRight;

        List<Integer> outList = largestValues(root);
        for(Integer unit:outList){
            System.out.println(unit);
        }
    }
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> outList = new ArrayList<>();
        recurser(root,0,outList);
        return outList;
    }

    private static void recurser(TreeNode root,int level,List<Integer> outList){
        if(root==null){
            return;
        }
        if(outList.size() < level+1){
            outList.add(root.val);
        }else if(outList.get(level) < root.val){
             outList.set(level,root.val);
        }
        recurser(root.left,level+1,outList);
        recurser(root.right,level+1,outList);
    }
}
