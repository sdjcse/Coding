package com.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdj on 2/27/17.
 */

class SpecialNode{
    String str;
    List<SpecialNode> children;
    SpecialNode(String s){
        this.str = s;
        children = new ArrayList<>();
    }
    public void addChild(SpecialNode ch){
        this.children.add(ch);
    }
}
public class GraphToTree
{
    public static void main(String[] args)
    {
        SpecialNode root = new SpecialNode("a");
        SpecialNode bCh = new SpecialNode("b");
        SpecialNode cCh = new SpecialNode("c");
        SpecialNode dCh = new SpecialNode("d");
        SpecialNode eCh = new SpecialNode("e");
        SpecialNode fCh = new SpecialNode("f");
        SpecialNode gCh = new SpecialNode("g");
        root.addChild(bCh);
        root.addChild(cCh);
        bCh.addChild(dCh);
        cCh.addChild(dCh);
        dCh.addChild(eCh);
        dCh.addChild(fCh);
        eCh.addChild(gCh);
        fCh.addChild(gCh);
        SpecialNode treeRoot = makeItATree(root);
        System.out.println();
    }

    public static  SpecialNode makeItATree(SpecialNode a){
        SpecialNode temp = new SpecialNode(a.str);
        for(SpecialNode s:a.children)
            temp.children.add(makeItATree(s));
        return temp;
    }

}
