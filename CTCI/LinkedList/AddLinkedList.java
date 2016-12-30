package com.ctci.strarr;

/**
 * Created by sdj on 12/30/16.
 *
 * The problem is given two linked list representing numbers with the nodes having
 * single digit of the number. Sum up two given numbers i.e., Linked list
 *
 *  1) First the number is in reverse order that is the head node represents uni digit
 *  2) Second the number is in forward order that is the tail node represents uni digit
 */
public class AddLinkedList
{
    AddLinkedList next = null;
    int data = 0;
    AddLinkedList(int data)
    {
        this.data = data;
    }
    AddLinkedList(int data,AddLinkedList next)
    {
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return this.data;
    }

    long length(){
        long len = 1;
        AddLinkedList runner = this;
        for(;runner.next!=null;runner = runner.next){
            len++;
        }
        return len;
    }

    // Adding two linked list assuming that head represents uni digit
    AddLinkedList reveresedLL(AddLinkedList n1,AddLinkedList n2,int carry){
        int firstData = 0;
        int secondData = 0;
        AddLinkedList l1 = null;
        AddLinkedList l2 = null;
        if(n1==null && n2 == null && carry == 0){
            return null;
        }
        if(n1==null && n2!=null){
            secondData = n2.getData();
            l2 = n2.next;
        }else if(n2==null && n1!=null){
            firstData = n1.getData();
            l1 = n1.next;
        } else if (n1!=null && n2!= null){
            firstData = n1.getData();
            secondData = n2.getData();
            l1 = n1.next;
            l2 = n2.next;
        }
        AddLinkedList retList = new AddLinkedList((firstData+secondData+carry)%10);
        carry = (firstData + secondData + carry)/10;
        retList.next = reveresedLL(l1,l2,carry);
        return retList;
    }

    boolean addElements(int data){
        AddLinkedList runner = this;
        while(runner.next != null){
            runner = runner.next;
        }
        runner.next = new AddLinkedList(data);
        return true;
    }

    public void printLL(){
        AddLinkedList runner = this;
        System.out.print(runner.getData());
        while(runner.next!=null){
            runner = runner.next;
            System.out.print(runner.getData());
        }
        System.out.println();
    }

    public void formatterForwardLL(AddLinkedList l1,AddLinkedList l2,AddLinkedList output){
       if(l1==null && l2==null){
           output = null;
           return;
       }
        long l1Len = l1.length();
        long l2Len = l2.length();
        if(l1Len > l2Len){
            l2 = l2.padZeros(l2,l1Len-l2Len);
        }else if(l2Len > l1Len){
            l1 = l1.padZeros(l1,l2Len-l1Len);
        }
        int finalCarry = forwardLL(l1,l2,output);
        if(finalCarry != 0){
            output = new AddLinkedList(finalCarry,output);
        }
    }

    // returns carry
    int forwardLL(AddLinkedList l1,AddLinkedList l2,AddLinkedList output){
        if(l1==null && l2==null && output==null){
            return -1;
        }
        int toBeReturned = forwardLL(l1.next,l2.next,output);
        int sum  = l1.getData()+l2.getData() + toBeReturned;
        if(toBeReturned == -1){
            sum ++;
            output = new AddLinkedList(sum%10);
        }else{
            output = new AddLinkedList(sum%10,output);
        }
        toBeReturned = sum/10;
        return toBeReturned;
    }

    public AddLinkedList padZeros(AddLinkedList l1,long n){
        AddLinkedList newNode = null;
        while(n>0){
            newNode = new AddLinkedList(0);
            newNode.next = l1;
            l1 = newNode;
            n--;
        }
        return l1;
    }
    public static void main(String[] args)
    {
        AddLinkedList l1 = new AddLinkedList(7);
        l1.addElements(9);
        l1.addElements(9);
        AddLinkedList l2 = new AddLinkedList(9);
        l2.addElements(3);
        l2.addElements(8);
        AddLinkedList output = null;
        output = l1.reveresedLL(l1,l2,0);
        l1.printLL(); l2.printLL(); output.printLL();

        //l1.formatterForwardLL(l1,l2,output);
        //l1.printLL(); l2.printLL(); output.printLL();
    }
}
