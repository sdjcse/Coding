package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/*
https://www.hackerrank.com/challenges/tree-top-view
* */
class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
}

class Qds{
    Node node;
    int uniqueVal;
    Qds(Node node,int uniqueVal){
        this.node = node;
        this.uniqueVal = uniqueVal;
    }
}
public class TreeTop {
    public static void main(String[] args) {
        Node leaf = new Node(4);
        Node leafUlt = new Node(3,null,leaf);
        Node leaf1 = new Node(6);
        Node leaf1Ult = new Node(5,leafUlt,leaf1);
        Node rootUlt = new Node(2,null,leaf1Ult);
        Node root = new Node(
                1,null,rootUlt
        );
        printTopView(root);
    }

    private static void printTopView(Node root){
        Queue<Qds> queue = new LinkedList<>();
        Set<Integer> uniqueSet = new HashSet<>();
        Qds temp = null;
        queue.add(new Qds(
                root,0
        ));

        while(!queue.isEmpty()){
            temp = queue.poll();
            if(!uniqueSet.contains(temp.uniqueVal)){
                System.out.print(temp.node.data + " ");
                uniqueSet.add(temp.uniqueVal);
            }

            if(temp.node.left!=null){
                queue.add(
                        new Qds(
                                temp.node.left,
                                temp.uniqueVal-1
                        )
                );
            }

            if(temp.node.right != null){
                queue.add(
                        new Qds(
                                temp.node.right,
                                temp.uniqueVal+1
                        )
                );
            }
        }
    }
}
