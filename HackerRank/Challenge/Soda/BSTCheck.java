package com.soda.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sdj on 2/18/17.
 *
 * Check if a given tree is a BST
 */
class Node {
    int data;
    Node left;
    Node right;
}
public class BSTCheck
{
    static boolean  checkBST(Node root) {
        if(root==null){
            return true;
        }
        return (root.left!=null ? maxVal(root.left)<root.data : true) && (root.right!=null ? minVal(root.right)>root.data : true)
                && checkBST(root.left) && checkBST(root.right);
    }

    static int maxVal(Node root){
        Queue<Node> bfsQ = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        bfsQ.add(root);
        Node temp = null;
        while(!bfsQ.isEmpty()){
            temp = bfsQ.poll();
            max = Math.max(max,temp.data);
            if(temp.left!=null){
                bfsQ.add(temp.left);
            }
            if(temp.right!=null){
                bfsQ.add(temp.right);
            }
        }
        return max;
    }

    static int minVal(Node root){
        Queue<Node> bfsQ = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        bfsQ.add(root);
        Node temp = null;
        while(!bfsQ.isEmpty()){
            temp = bfsQ.poll();
            max = Math.min(max,temp.data);
            if(temp.left!=null){
                bfsQ.add(temp.left);
            }
            if(temp.right!=null){
                bfsQ.add(temp.right);
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        Node root = new Node();
        root.data = 4;
        root.left = new Node();
        root.left.data = 2;
        root.right = new Node();
        root.right.data = 6;
        root.left.left = new Node();
        root.left.left.data = 1;
        root.left.right = new Node();
        root.left.right.data = 3;
        root.right.left = new Node();
        root.right.left.data = 5;

        if(checkBST(root)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println();
    }
}
