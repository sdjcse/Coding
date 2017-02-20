package com.soda.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 2/18/17.
 */
public class PoisonPlants
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        List<Long> longList = new ArrayList<>();
        while(n>0){
            longList.add(inp.nextLong());
            n--;
        }
        int counter = 0;
        int i=longList.size()-1;
        boolean removal = false;

        while(true){
            i = longList.size()-1;
            removal = false;
            while(i>0){
                if(longList.get(i)>longList.get(i-1)){
                    removal = true;
                    longList.remove(i);
                }
                i--;
            }
            if(!removal){
                break;
            }
            counter ++;
        }
        System.out.println(counter);
    }


}
