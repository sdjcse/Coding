package com.hackerrank.practice.interviewchall;

import java.util.Arrays;

/**
 * Created by sdj on 9/27/16.
 */
public class StringSubSeq {
    static int longestSubsequence(String x, String y) {
        char [] xArr = x.toCharArray();
        char [] yArr = y.toCharArray();
        System.out.println(x);
        System.out.println(y);
        Arrays.sort(xArr);
        Arrays.sort(yArr);
        int lcs = 0;
        for(int i=0,j=0;i<xArr.length && j<yArr.length;){
            if(xArr[i] == yArr[j]){
                lcs++;
                i++;
                j++;
            }else if(xArr[i]<yArr[j]){
                i++;
            }else{
                j++;
            }
        }
        return lcs;
    }

    public static void main(String[] args) {
        String x = "pxmfjrmvkehafjpxrehkkqcqbjpcmxymsgnfdzzplkdaewzoteyavwwzcnbtsrxyccjxfmbwsfquqelpicmmvymatfvwpemabhlxpjxuywludjhkfwpyowvnkpupalimnnecvtesblatxnewkywvvohdbgfavjxumqhvkznutjpowuvhmnyvzbykuzmchbnlmuiavdfbcuutaqqgiwhjefmcapfisdtohavoputtnhzecalriymlnfabvtbkhtnpenxkbtubuyskwykpablacspjkanwlnxeuuksccptvtqwomusmvuygfdmbkftbdlwmmxeudbdknqudfcrsaefetouygyejfelfqoqvhfabprdbjcihqrzfdbqcafvoowjskqwzironkxxsqedgbycvhnuskhdkkgfpggahvuznqytlldquvbofbxafrxmnbaignazengaxngdobatpmqfzghlamzuoelwvajlvzbuoxwluxqhsmcj";
        String y = "ohazmsexovixkuuneqnzdhhsweyjmrevqszglreqzacuzefaszzyzramuctxeusmzmtajezzfnrqmmmcyvrogrhntqwlbfpatgjxlweewaiaqidxrqplxdudscuqhrfjtqvksksnfmfhcodvghtkgzojpzytmdcimjzwaonnwmhmsaacnrblvvzhwbiokgziuvsfersuxiiydcfcvnkpbzljsqrqtgmhywkjxlxsixlxrwsnyypjkoxgtyczbouvojmfoqptnqfkvrynavuywnemedlvbvlafhorcfpqixphfwoybefcsbubegqmhcgyfbetfsyuqbadugfylowmzrifijkzlpawkewixgcfvqxapcyzpegrzrqczfdssgvspnjktlshhjqvvlkcmvwtwclpfwlwwulvfvmnnzldpiotcalpktbklalusufgbkrqgzdbagtqzlzealvq";

        x = "hackerranks";
        y = "hackers";
        System.out.println(x.length());
        System.out.println(y.length());
        // System.out.println(longestSubsequence(x,y));

        char xArr[] = x.toCharArray();
        char yArr[] = y.toCharArray();

        int lenArr [][] = new int[x.length()][y.length()];
        for(int i=0;i<x.length();i++){
            for(int j=0;j<y.length();j++){
                lenArr[i][j] = 0;
            }
        }

        for(int i=0,j=0;i<x.length()-2 && j<y.length()-2;){
            lenArr[i+1][j] = (lenArr[i+1][j]>lenArr[i][j])?lenArr[i+1][j]:lenArr[i][j];
            if(xArr[i]==yArr[j]){
                lenArr[i+1][j+1] =  (lenArr[i+1][j+1]>lenArr[i][j]+1)?lenArr[i+1][j+1]:lenArr[i][j]+1;
                //i++;
                j++;
            }
            //if(x.length()>y.length()){
                i++;
            //}
        }
        System.out.println(lenArr[x.length()-2][y.length()-2]);
    }
}
