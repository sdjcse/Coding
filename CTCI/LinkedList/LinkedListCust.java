package com.ctci.linkedlist;


import sun.awt.image.ImageWatched;

/**
 * Created by sdj on 12/30/16.
 */
public class LinkedListCust
{
    int data;
    LinkedListCust next ;
    LinkedListCust(int data){
        this.data = data;
        this.next = null;
    }
    LinkedListCust(int data, LinkedListCust next){
        this.data = data;
        this.next = next;
    }

    public LinkedListCust addAtBeg(int data){
        return new LinkedListCust(data,this);
    }
    public void addAtEnd(int data){
        LinkedListCust runner = this;
        while(runner.next!=null){
            runner = runner.next;
        }
        runner.next = new LinkedListCust(data);
    }
    public int length(){
        int len = -1;
        LinkedListCust runner = this;
        if(!this.checkIfLooped()){
            len = 1;
            while(runner.next != null){
                runner = runner.next;
                len++;
            }
        }
        return len;
    }

    public boolean checkIfLooped(){
        LinkedListCust firstPtr = this;
        LinkedListCust secondPtr = this;
        while(firstPtr != null && secondPtr!=null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
            if(secondPtr!=null){
                secondPtr = secondPtr.next;
            }
            if(firstPtr==secondPtr)
                return true;
        }
        return false;
    }

    public LinkedListCust startOfLoop(){
        LinkedListCust firstPtr = this;
        LinkedListCust secondPtr = this;
        while(firstPtr!=null && secondPtr!=null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next.next;
            if(firstPtr==secondPtr){
                firstPtr = this;
                while(firstPtr!=secondPtr){
                    firstPtr = firstPtr.next;
                    secondPtr = secondPtr.next;
                }
                return firstPtr;
            }
        }
        return null;
    }

    // checks if the list has the data and return the first index if its present
    public int contains(int n){
        if(this.data==n)
            return 1;
        int k = 1;
        LinkedListCust runner = this;
        while(runner.next!= null && runner.data !=n){
            runner = runner.next;
            k++;
        }
        if(runner.data==n){
            return k;
        }
        return 0;
    }

    public LinkedListCust reverse(LinkedListCust present,LinkedListCust prev){
        if(present.next == null){
            present.next = prev;
            return present;
        }
        LinkedListCust temp = present.next;
        present.next = prev;
        return reverse(temp,present);
    }
    public boolean equalsLL(LinkedListCust b){
        LinkedListCust run1 = this;
        LinkedListCust run2 = b;
        for(;run1!=null && run2!=null; run1 = run1.next,run2=run2.next)
            if(run1.data != run2.data)
                return false;

        return true;
    }
    LinkedListCust findMid(LinkedListCust a){
        LinkedListCust runner = a,walker = a;
        while(runner!=null){
            runner = runner.next;
            if(runner!= null){
                runner = runner.next;
                walker = walker.next;
            }

        }
        return walker;
    }
    public LinkedListCust split(){
        LinkedListCust head1 = this;
        LinkedListCust mid = this.findMid(this);
        LinkedListCust head2 = mid;
        LinkedListCust prev = head1;
        while(head1!=null && head1!=mid){
            prev = head1;
            head1=head1.next;
        }
        prev.next = null;
        return head2;
    }
    public boolean checkPalindrome(){
        if(this.checkIfLooped())
            return false;
        LinkedListCust temp = this.split();
        temp = this.reverse(temp,null);
        LinkedListCust reference = this;
        boolean retVal = this.equalsLL(temp);
        reference = this.joinLL(this.reverse(temp,null));
        return retVal;
    }

    public LinkedListCust joinLL(LinkedListCust a){
        LinkedListCust runner = this;
        while(runner.next!=null)
            runner = runner.next;
        runner.next = a;
        return this;
    }
    public void printLL(LinkedListCust printThis){
        while(printThis!=null){
            System.out.print(printThis.data + " ");
            printThis = printThis.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        LinkedListCust a= new LinkedListCust(12);
        a.next = new LinkedListCust(13);
        a.next.next = new LinkedListCust(10);
        a.next.next.next = new LinkedListCust(13);
         a.next.next.next.next = new LinkedListCust(12);
        // a.next.next.next.next.next = a.next.next;
        //a.printLL(a.reverse(a.findMid(a),null));
        System.out.println(a.checkPalindrome());
    }
}
