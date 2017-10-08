package Chapter2.LinkedLists.exc;

import Chapter2.LinkedLists.SLL;
import Chapter2.LinkedLists.SLLNode;

import java.util.ArrayList;

/**
 * Created by hnastevska on 10/7/2017.
 */
public class Exc {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        //System.out.println(giveMeKthToLastElement1(list, 2));
        deleteMiddle(list.getFirst().succ.succ.succ);
        System.out.println(list.toString());

    }

    private static void deleteMiddle(SLLNode<Integer> node) {
        SLLNode<Integer> previous = node;
        SLLNode<Integer> next = node.succ;
        previous.element = next.element;
        previous.succ = next.succ;
    }



        //pretty straight forward solution but not the one we needed
    public static int giveMeKthToLastElement1(SLL<Integer> list, int k) {
        int counter = 0;
        SLLNode<Integer> tmp = list.getFirst();
        SLLNode<Integer> runner = list.getFirst();

        for (int i = 0; i < k; i++) {
            runner = runner.succ;
        }
        while (runner != null) {
            if (runner.succ == null) {
                return tmp.succ.element;
            } else {
                runner = runner.succ;
                tmp = tmp.succ;
            }
        }
        return 0;
    }
}
