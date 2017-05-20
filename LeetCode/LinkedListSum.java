package com.leetcode;

/**
 * Created by sdj on 5/15/17.
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class LinkedListSum
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp = sum;
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        int rem=0;
        boolean first = true;
        while(l1Temp!=null && l2Temp != null){
            rem = l1Temp.val + l2Temp.val + rem;
            l1Temp = l1Temp.next;
            l2Temp = l2Temp.next;
            if(first){
                first = false;
                temp.val =rem%10;
            }else {
                temp.next = new ListNode(rem%10);
                temp = temp.next;
            }
            rem /= 10;
        }
        while (l1Temp!=null){
            rem = rem+l1Temp.val;
            temp.next = new ListNode(rem%10);
            temp = temp.next;
            rem /= 10;
            l1Temp = l1Temp.next;
        }
        while (l2Temp!=null){
            rem = rem+l2Temp.val;
            temp.next = new ListNode(rem%10);
            temp = temp.next;
            rem /= 10;
            l2Temp = l2Temp.next;
        }
        if(rem>0){
            temp.next = new ListNode(1);
        }
        return sum;
    }

    public static void main(String[] args)
    {
        /*ListNode one = new ListNode(2);
        one.next = new ListNode(4);
        one.next.next = new ListNode(3);
        ListNode two = new ListNode(5);
        two.next = new ListNode(6);
        two.next.next = new ListNode(4);*/
        /*ListNode one = new ListNode(1);
        ListNode two = new ListNode(9);
        two.next = new ListNode(9);*/
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(5);
        ListNode sum = new LinkedListSum().addTwoNumbers(one,two);
        while(sum!=null){
            System.out.println(sum.val);
            sum = sum.next;
        }
    }
}
