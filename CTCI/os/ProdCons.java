package com.ctci;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sdj on 2/22/17.
 */
public class ProdCons
{
    public static void main(String[] args)
    {
        Queue<Integer> queueProd = new LinkedList<>();
        Thread prod = new Thread(new Producer(queueProd,4),"Prod");
        Thread cons = new Thread(new Consumer(queueProd,4),"Cons");
        prod.start();
        cons.start();
    }
}

class Producer implements Runnable{

    private Queue<Integer> comQueue;
    private int size;

    Producer(Queue<Integer> queue,int size){
        comQueue = queue;
        this.size = size;
    }
    @Override
    public void run(){
        for (int i = 0; i < 12; i++)
        {
            while(comQueue.size()==size){
                synchronized (comQueue){
                    System.out.println("Queue is full Producer is waiting!");
                    try
                    {
                        comQueue.wait();
                    }catch (InterruptedException e)
                    {
                        System.out.println("Thread Interrupted");
                    }
                }
            }

            synchronized (comQueue){
                comQueue.add(i);
                //System.out.println("Fucker take it: " + i);
                comQueue.notifyAll();
            }
        }
    }
}

class Consumer implements Runnable{

    private Queue<Integer> comQueue;
    private int size;
    private int consumedElement = 0;

    Consumer(Queue<Integer> queue,int size){
        comQueue = queue;
        this.size = size;
    }
    @Override
    public void run(){
        while(consumedElement<12){
            while(comQueue.isEmpty()){
                synchronized (comQueue){
                    System.out.println("Queue is empty Consumer is waiting!");
                    try
                    {
                        comQueue.wait();
                    }catch (InterruptedException e)
                    {
                        System.out.println("Thread Interrupted");
                    }
                }

            }

            synchronized (comQueue){
                System.out.println("Consumer consumed element: " +comQueue.poll());
                comQueue.notifyAll();
            }
            try
            {
                Thread.sleep(50);
            }catch (InterruptedException e){
                System.out.println("Busted");
            }
            consumedElement++;
        }


    }
}
