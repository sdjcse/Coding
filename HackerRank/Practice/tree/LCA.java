package tree;
/*
https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
* */

class Node{
    Node(){

    }
    Node(int data){
        this.data = data;
    }
    Node(int data,Node left,Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    int data;
    Node left;
    Node right;
}

public class LCA {
    public static void main(String[] args) {
        /*Node root = new Node(4,
                new Node(2,new Node(1),new Node(3)),
                new Node(7,new Node(6),null));*/

        Node root = new Node(8,
                new Node(4,
                        new Node(1,null,new Node(2,null,new Node(3))),new Node(6,new Node(5),null)),
                new Node(9)
        );
        System.out.println(
                lca(root,1,2).data
        );
    }
    static Node lca(Node root,int v1,int v2)
    {
        Node temp = root;
        if(root.data < v1 && root.data < v2){
            temp = lca(root.right,v1,v2);
        }else if(root.data > v1 && root.data > v2){
            temp = lca(root.left,v1,v2);
        }
        return temp;
    }

}
