package com.soda.challenge;

import java.util.*;

/**
 * Created by sdj on 2/18/17.
 * https://www.hackerrank.com/challenges/poisonous-plants
 */
class NodeP{
    Long l;
    int day;
    NodeP(Long l,int day){
        this.l=l;
        this.day=day;
    }
}
public class PoisonPlants
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        List<Long> longList = new ArrayList<>();
        while(n>0){
            longList.add(1*inp.nextLong());
            n--;
        }
        int counter = 0;
        Stack<NodeP> s = new Stack<>();
        NodeP top = null;
        int checker = 0;
        for (int j = 0; j < longList.size(); j++)
        {
            if(s.isEmpty()){
                s.push(new NodeP(longList.get(j),0));
            }else{
                top = s.peek();
                if(longList.get(j) > top.l){
                    s.push(new NodeP(longList.get(j),1));
                }else{
                    top = s.peek();
                    checker = top.day;
                    while (!s.isEmpty() && top.l>=longList.get(j)){
                        s.pop();
                        if(s.isEmpty())
                            break;
                        checker = Math.max(checker,top.day);
                        top = s.peek();
                    }

                    if(s.isEmpty()){
                        s.push(new NodeP(longList.get(j),0));
                    }else{
                        s.push(new NodeP(longList.get(j),checker+1));
                        counter = Math.max(counter,checker+1);
                    }
                }
            }
        }
        System.out.println(counter);
    }


}
