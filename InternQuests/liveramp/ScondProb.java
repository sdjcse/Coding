package com.intern.liveramp;


/**
 * Created by sdj on 11/21/16.
 *
 * * Sub array sort - sort the sub array within the array that is scrambled within
 */
public class ScondProb {
        public int solution(int[] A) {
            int start=0,end,max,min;
            int n = A.length;
            // List<Integer> inpList = new ArrayList<Integer>(Arrays.asList(A));
            for(start = 0;start<n-1;start++){
                if(A[start] > A[start+1]){
                    break;
                }
            }
            if(start == n-1){
                return 0;
            }
            for(end=n-1;end>0;end--){
                if(A[end] < A[end-1]){
                    break;
                }
            }

            max = A[start]; min = A[end];
            for(int i = start+1;i<=end;i++){
                if(A[i] > max){
                    max = A[i];
                }
                if(A[i] < min){
                    min = A[i];
                }
            }

            for(int i=0;i<start;i++){
                if(A[i] > min){
                    start = i;
                    break;
                }
            }

            for(int i = n-1;i>=end+1;i--){
                if(A[i]< max){
                    end=i;
                    break;
                }
            }
            return end-start+1;
        }

    public static void main(String[] args) {
        ScondProb s = new ScondProb();
        System.out.print(s.solution(new int[]{1,2,6,5,5,8,9}));
    }
}
