/*package algorithms;

public class LC_OddEvenList_328 {

    public static void main(String[] args) {
        ListNode head = LC_SwapPairs_24.frameLL(new int[]{1,2,3,4,5,6,7});
        head = oddEvenList(head);
        LC_SwapPairs_24.printLL(head);
    }
    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode front = head,back = head.next,midRunner = head.next.next,temp = null,intermediate = back;
        int counter = 1;
        while(midRunner!=null){
            temp = midRunner.next;
            if (counter%2!=0){
                front.next = midRunner;
                front = front.next;
                midRunner.next = back;
                intermediate.next = temp;
                intermediate = intermediate.next;
            }
            counter++;
            midRunner = temp;
        }
        return head;
    }
}
*/