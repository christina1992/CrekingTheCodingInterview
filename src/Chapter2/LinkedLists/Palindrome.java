package Chapter2.LinkedLists;

import java.util.Stack;

/**
 * Created by Christina on 04-Jun-17.
 */
public class Palindrome {

    private static boolean isPalindrome(SLLNode<Integer> head) {
        SLLNode<Integer> reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static boolean isEqual(SLLNode<Integer> one, SLLNode<Integer> two) {
        while (one != null && two != null) {
            if (!one.element.equals(two.element)) {
                return false;
            }
            one = one.succ;
            two = two.succ;
        }
        return one == null && two == null;
    }

    private static SLLNode<Integer> reverseAndClone(SLLNode<Integer> node) {
        SLLNode<Integer> head = null;
        while (node != null) {
            SLLNode<Integer> n = new SLLNode<>(node.element, node.succ);
            n.succ = head;
            head = n;
            node = node.succ;
        }
        return head;
    }

    /*
        Iterative solution using stack
     */
    public static boolean isPalindrome2(SLLNode<Integer> head) {
        SLLNode<Integer> fast = head;
        SLLNode<Integer> slow = head;
        Stack<Integer> stack = new Stack<>();
        /*Push elements from first half of linked list onto stack. When fast runner
        (which is moving at 2x speed) reaches the end of the linked list, then we
         know we're at the middle */
        while (fast != null && fast.succ != null) {
            stack.push(slow.element);
            slow = slow.succ;
            fast = fast.succ.succ;
        }
        /* Has odd number of elements, so skip the middle element */
        if (fast != null) {
            slow = slow.succ;
        }
        while (slow != null) {
            int top = stack.pop();

            /* If values are different, then it's not a palindrome */
            if (top != slow.element) {
                return false;
            }
            slow = slow.succ;
        }
        return true;
    }

    static class Result {

        public SLLNode node;
        public boolean result;

        public Result(SLLNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    boolean isPalindrome3(SLLNode<Integer> head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    private Result isPalindromeRecurse(SLLNode head, int length) {
        if (head == null || length <= 0) { // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) { // Odd number of nodes
            return new Result(head.succ, true);
        }

        /* Recurse on sublist. */
        Result res = isPalindromeRecurse(head.succ, length - 2);

         /* If child calls are not a palindrome, pass back up
           a failure . */
        if (!res.result || res.node == null) {
            return res;
        }

        /* Check if matches corresponding node on other side. */
        res.result = (head.element == res.node.element);

        /* Return corresponding node. */
        res.node = res.node.succ;

        return res;
    }

    private int lengthOfList(SLLNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.succ;
        }
        return size;
    }

    public static void main(String[] args) {
        SLL<Integer> list1 = new SLL<>();

        list1.insertLast(7);
        list1.insertLast(1);
        list1.insertLast(6);
        list1.insertLast(6);
        list1.insertLast(1);
        list1.insertLast(7);
        System.out.println(isPalindrome(list1.getFirst()));


    }
}
