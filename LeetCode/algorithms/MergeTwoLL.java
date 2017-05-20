/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLL {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = null;
        if(l1 != null){
            if(l2!=null && l1.val < l2.val){
                temp = l1;
                temp.next = mergeTwoLists(l1.next,l2);
            }else if(l2!=null && l2.val <= l1.val){
                temp = l2;
                temp.next = mergeTwoLists(l1,l2.next);
            }else{
                return l1;
            }
        }else if(l2 != null){
            return l2;
        }else{
            return null;
        }
        return temp;
    }
}
