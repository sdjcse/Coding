package com.ctci.linkedlist;


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
            secondPtr = secondPtr.next.next;
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

    public boolean checkPalindrome(){
        if(this.checkIfLooped())
            return false;
        int lenMid = this.length();

        return false;
    }

    public static void main(String[] args)
    {
        LinkedListCust a= new LinkedListCust(12);
        a.next = new LinkedListCust(13);
        a.next.next = new LinkedListCust(10);
        a.next.next.next = new LinkedListCust(7);
        a.next.next.next.next = new LinkedListCust(21);
        a.next.next.next.next.next = a.next.next;

        System.out.println(a.startOfLoop().data);
    }
}
