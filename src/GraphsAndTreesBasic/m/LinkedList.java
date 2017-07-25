package GraphsAndTreesBasic.m;

import Chapter2.LinkedLists.SLL;
import Chapter2.LinkedLists.SLLNode;

/**
 * Created by hnastevska on 7/21/2017.
 */
public class LinkedList {

    static SLLNode<Integer> deleteOdd(SLLNode<Integer> head) {
        if (head == null) {
            return null;
        } else {
            SLLNode<Integer> cur = head;
            SLLNode<Integer> previous = cur;
            while (cur.succ != null) {
                cur = cur.succ;
                if (cur.element % 2 != 0) {
                    previous.succ = cur.succ;
                } else {
                    previous = previous.succ;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.insertLast(8);

        SLLNode<Integer> smth = deleteOdd(list.getFirst());

        while (smth.succ != null) {
            System.out.println(smth.element);
            smth = smth.succ;
        }

    }
}

