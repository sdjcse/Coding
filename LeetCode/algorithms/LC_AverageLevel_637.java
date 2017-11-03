package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_AverageLevel_637 {
    class QElement{
        int val;
        int level;
        QElement(int val,int level){
            this.val = val;
            this.level = level;
        }
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> finList = new ArrayList<>();
        Queue<QElement> queue = new LinkedList<>();
        fillQueue(root,0,queue);
        while (!queue.isEmpty()){

        }
        return finList;
    }

    private void fillQueue(TreeNode root,int level,Queue<QElement> queue){
        if(root==null){
            return;
        }
        queue.add(new QElement(root.val,level));
        fillQueue(root.left,level+1,queue);
        fillQueue(root.right,level+1,queue);
    }
}
