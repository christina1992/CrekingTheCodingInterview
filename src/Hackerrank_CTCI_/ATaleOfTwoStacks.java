package Hackerrank_CTCI_;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hnastevska on 7/26/2017.
 */
public class ATaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();


        protected void enqueue(T t){
            stackOldestOnTop.push(t);
        }

        protected void dequeue(){
            if(stackNewestOnTop.isEmpty()){
                while(!stackOldestOnTop.isEmpty()){
                    stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            stackNewestOnTop.pop();
        }

        protected String peek(){
            if(stackNewestOnTop.isEmpty()){
                while(!stackOldestOnTop.isEmpty()){
                    stackNewestOnTop.push(stackOldestOnTop.pop());
                }
            }
            return stackNewestOnTop.peek().toString();

        }
        public int size(){
            return stackNewestOnTop.size();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
 /*       queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);

        System.out.println(queue.peek());
        System.out.println(queue.size());*/
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
