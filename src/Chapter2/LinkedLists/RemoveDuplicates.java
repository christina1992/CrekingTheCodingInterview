package Chapter2.LinkedLists;

import java.util.HashSet;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * Complexity O(n)
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);

        removeDuplicates(list);
        System.out.println(list.toString());

    }

    private static void removeDuplicates(SLL<Integer> list) {
        SLLNode<Integer> tmp = list.getFirst();
        HashSet<Integer> set = new HashSet<>();
        SLLNode<Integer> previous = null;
        while (tmp != null) {
            if (set.contains(tmp.element)) {
                previous.succ = tmp.succ;
            } else {
                set.add(tmp.element);
                previous = tmp;
            }
            tmp = tmp.succ;
        }
    }

    /*
        Without additional data structure
        Complexity O(n^2)
        Iterate with 2 pointers / runner
     */
    public static void deleteDups(SLL<Integer> list) {
        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null) {
            SLLNode<Integer> runner = tmp;
            while (runner.succ != null) {
                if (runner.succ.element == runner.element) {
                    runner.succ = runner.succ.succ;
                } else {
                    runner = runner.succ;
                }
            }
            tmp = tmp.succ;
        }

    }

}
