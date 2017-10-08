package Chapter2.LinkedLists;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class KthToLast {

    //pretty straight forward solution but not the one we needed
    public static int giveMeKthToLastElement(SLL<Integer> list, int k) {
        int counter = 0;
        int c = 0;
        int myElem = 0;
        SLLNode tmp = list.getFirst();
        SLLNode tmp1 = list.getFirst();
        while (tmp != null) {
            tmp = tmp.succ;
            counter++;
        }
        if (k < counter) myElem = counter - k;

        while (tmp1 != null) {

            if (c == myElem) {
                return (int) tmp1.element;
            }
            tmp1 = tmp1.succ;
            c++;
        }

        return 0;
    }

    /*
       Recursive solution Space O(n) Time O(n)
     */
    public static int printKthToLast(SLLNode<Integer> head, int k) {
        if (head == null) return 0;
        int index = printKthToLast(head.succ, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.element);
        }
        return index;

    }

    /*
        The best solution is iterative but is not that straight forward
        This algorithm takes O(n) time and O(1)
     */
    public static SLLNode<Integer> nthToLast(SLLNode<Integer> head, int k) {
        SLLNode<Integer> p1 = head;
        SLLNode<Integer> p2 = head;
        /* Move p1 k nodes into the list*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // out of bounds
            p1 = p1.succ;
        }
        /* Move them at the same pace. When p1 hits the end, p2 will be at the right element.*/
        while (p1 != null) {
            p1 = p1.succ;
            p2 = p2.succ;
        }
        return p2;
    }


    public static void main(String[] args) {
        SLL<Integer> list = new SLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        System.out.println(nthToLast(list.getFirst(), 2));
        //printKthToLast(list.getFirst(), 4);

    }
}
