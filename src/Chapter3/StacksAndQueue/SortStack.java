package Chapter3.StacksAndQueue;

import java.util.Stack;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
 * an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class SortStack {

    void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            //Insert each element in s in sorted order into r
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        //Copy the elements from r back into s
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

}
