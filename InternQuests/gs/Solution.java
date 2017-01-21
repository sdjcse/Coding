package com.intern.gs;

import java.util.*;

/**
 * Created by sdj on 9/12/16.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println();
    }

    static int numberOfBreaches(String [] input){

            double arr[][] = new double[8][30];
        for(int i=0;i<8;i++) {
            for(int j=0;j<30;j++) {
                arr[i][j] = 0f;
            }
        }
            Object[] container = new Object[8];
            double value;
            int time;
            int day;
            List<Double> valList = new ArrayList<>();
            List<Integer> timeList = new ArrayList<>();
            List<Integer> dayList = new ArrayList<>();
            int numBreach = 0;
            for(int i=0;i<container.length;i++){
                container[i] = null;
            }

            for(int i=0;i<input.length;i++){
                String s[] = input[i].split(",");
                value = Double.parseDouble(s[0]);

                valList.add(value);
                time = Integer.parseInt(s[1]);
                timeList.add(time);
                day = Integer.parseInt(s[2]);
                dayList.add(day);
                System.out.println(value + " " + time + " " + day);

                arr[time-9][day-1] += value;



            }

            for(int i=0;i<8;i++){

                for(int j=0;j<30;j++) {
                    if(arr[i][j] != 0) {

                        List<Double> avgList = null;
                        double average = 0f;
                        if(container[i]==null){
                            avgList = new ArrayList<>();
                            avgList.add(arr[i][j]);
                            container[i] = avgList;
                        }
                        else{
                            avgList = (List)container[i];
                            int listSize = avgList.size();
                            double checkBreach = 0f;
                            if(listSize > 5){
                                checkBreach = (double)((avgList.get(listSize-1) - avgList.get(listSize-6))/5);
                            }else{
                                checkBreach = (double)(avgList.get(listSize-1) / avgList.size());
                            }
                            numBreach = (Double.compare(arr[i][j],checkBreach) > 0) ? numBreach+1 : numBreach;
                            // numBreach = (arr[i][j]>checkBreach) ? (numBreach+1) : numBreach;
                            avgList.add(avgList.get(listSize-1)+arr[i][j]);
                            container[i] = avgList;
                        }
                    }
                }

            }


            return numBreach;
        }


    }
