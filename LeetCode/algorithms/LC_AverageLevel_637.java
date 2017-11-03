package algorithms;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LC_AverageLevel_637 {
    class QElement implements Comparable<QElement>{
        int val;
        int level;
        QElement(int val,int level){
            this.val = val;
            this.level = level;
        }

        @Override
        public int compareTo(QElement o) {
            return Integer.compare(this.level,o.level);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        List<Double> vals = new LC_AverageLevel_637().averageOfLevels(root);
        for(Double i : vals){
            System.out.println(i);
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> finList = new ArrayList<>();
        PriorityQueue<QElement> queue = new PriorityQueue<>();
        fillQueue(root,0,queue);
        double count=0,sum=0;
        int prev=-1;
        QElement unit;
        while (!queue.isEmpty()){
            unit = queue.poll();
            if(prev==-1){
                sum += unit.val;
                count++;
            }else if(prev!=unit.level){
                finList.add(sum/count);
                sum = unit.val;
                count = 1;
            }else{
                sum+=unit.val;
                count++;
            }
            prev = unit.level;
        }
        finList.add(sum/count);
        return finList;
    }

    private void fillQueue(TreeNode root,int level,PriorityQueue<QElement> queue){
        if(root==null){
            return;
        }
        queue.offer(new QElement(root.val,level));
        fillQueue(root.left,level+1,queue);
        fillQueue(root.right,level+1,queue);
    }
}
