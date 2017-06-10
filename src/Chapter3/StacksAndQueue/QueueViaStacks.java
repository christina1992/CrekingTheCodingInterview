package Chapter3.StacksAndQueue;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */

import java.util.Stack;

public class QueueViaStacks {
    public static class MyQuequ<T> {
        Stack<T> stackNewest, stackOldest;

        public MyQuequ() {
            stackNewest = new Stack<T>();
            stackOldest = new Stack<T>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        //Push onto stackNewest, which always has the newest elements on top
        public void add(T value) {
            stackNewest.push(value);
        }

        /*
         Move elements from stackNewest into stackOldest. This is usually done so that
            we can do operations on stackOldest
          */
        public void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks(); //Ensure stackOldest has the current elements
            return stackOldest.peek();//retrieve the oldest item.
        }

        public T remove() {
            shiftStacks(); //Ensure stackOldest has the current elements
            return stackOldest.pop(); //pop the oldest item
        }

        public static void main(String[] args) {

        }
    }
}
