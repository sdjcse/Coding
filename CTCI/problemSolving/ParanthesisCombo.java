package com.ctci.probSolv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 1/21/17.
 */
public class ParanthesisCombo
{
    static char s [] = new char[100];
    static void listCombo(int position,int n,int open,int close,List<String> outlist)
    {
        if(close == n)
        {
            outlist.add(new String(s));
            return;
        }
        else
        {
            if (open > close)
            {
                s[position] = '}';
                listCombo(position+1,n,open,close+1,outlist);
            }
            if (open < n)
            {
                s[position] = '{';
                listCombo(position+1,n,open+1,close,outlist);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        List<String> out = new ArrayList<>();
        if(n>0)
        {
            listCombo(0,n,0,0,out);
        }
        for(String s: out)
        {
            System.out.println(s);
        }
    }
}
