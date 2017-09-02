package LeetCode.algorithms;

import java.util.List;

            class ListNode {
                int val;
                ListNode next;
            }
            public class LC_NthFromEnd_19 {
                public static void main(String[] args) {
                    ListNode framedList = convertListToLL(new Integer[]{1,2});
                    printNode(framedList);
                    ListNode removed = removeNthFromEnd(framedList,2);
                    printNode(removed);
        }

        public static  ListNode convertListToLL(Integer[] givenList){
            ListNode head = null;
            ListNode temp = null;
            for (int i = 0; i < givenList.length; i++) {
                if(temp!=null){
                    temp.next = new ListNode();
                    temp = temp.next;
                }else{
                    temp = head = new ListNode();
                }
                temp.val = givenList[i];
                temp.next = null;
            }
            return head;
        }


        public  static  void printNode(ListNode temp){
            ListNode iter = temp;
            while(iter!=null){
                System.out.print(iter.val + " ");
                iter = iter.next;
            }
            System.out.println();
        }


        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = head;
            ListNode ret = head;
            ListNode first,second;
            first = null;
            second = head;
            int i = 0;
            while(i++<n){
                second = second.next;
            }
            while(second!=null){
                first = first==null? head : first.next;
                second = second.next;
            }
            if(ret==first && first.next == second){
                ret.next = null;
            }else if(first==null){
                temp = ret;
                ret = ret.next;
                temp.next = null;
                temp = null;
            }else{
                temp = first.next;
                first.next = temp.next;
                temp.next = null;
                temp = null;
            }
            return ret;
        }
}
