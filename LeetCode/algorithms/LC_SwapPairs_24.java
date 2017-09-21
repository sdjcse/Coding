package algorithms;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class LC_SwapPairs_24 {

    public static void main(String[] args) {
        ListNode framedList = frameLL(new int[]{1,2,3});
        // printLL(framedList);
        framedList = swapPairs(framedList);
        printLL(framedList);
    }

    private static ListNode frameLL(int [] arr){
        ListNode head,temp = new ListNode(arr[0]);
        head = temp;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    private static void printLL(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static  ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode runner = head;
        ListNode temp = null;
        ListNode prev = null;
        while (runner!=null && runner.next!=null){
            temp = runner.next;
            runner.next = temp.next;
            temp.next = runner;
            if(prev!=null){
                prev.next = temp;
            }else{
                head = temp;
            }
            prev = runner;
            runner = runner.next;
        }
        return head;
    }
}
