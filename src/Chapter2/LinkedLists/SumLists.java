package Chapter2.LinkedLists;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2) .Thatis,617 + 295.
 * Output: 2 - > 1 - > 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295.
 * Output: 9 - > 1 - > 2. That is, 912.
 */
public class SumLists {
    /*
        Using StringBuilder, pretty straight-forward solution
     */
    public static SLL<Integer> sumLists(SLLNode<Integer> head1, SLLNode<Integer> head2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        SLL<Integer> result = new SLL<>();
        while (head1 != null) {
            sb1.append(head1.element);
            head1 = head1.succ;
        }
        while (head2 != null) {
            sb2.append(head2.element);
            head2 = head2.succ;
        }
        sb1 = sb1.reverse();
        sb2 = sb2.reverse();

        int num1 = Integer.parseInt(new String(sb1));
        int num2 = Integer.parseInt(new String(sb2));

        int sum = num1 + num2;
        String fin = String.valueOf(sum);
        char[] chars = fin.toCharArray();
        for (char c : chars) {
            result.insertLast(Integer.parseInt(String.valueOf(c)));
        }
        return result;
    }

    public static void main(String[] args) {
        SLL<Integer> list1 = new SLL<>();
        SLL<Integer> list2 = new SLL<>();

        list1.insertLast(7);
        list1.insertLast(1);
        list1.insertLast(6);

        list2.insertLast(5);
        list2.insertLast(9);
        list2.insertLast(2);
        System.out.println(sumLists(list1.getFirst(), list2.getFirst()).toString());
    }

    /*
        Solution from the book / Recursion
     */
    SLLNode<Integer> addLists(SLLNode<Integer> l1, SLLNode<Integer> l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        SLLNode<Integer> result = new SLLNode<>(0, null);
        int value = carry;
        if (l1 != null) {
            value += l1.element;
        }
        if (l2 != null) {
            value += l2.element;
        }
        result.element = value % 10; /* Second digit of the number */
        /*Recursive*/
        if (l1 != null || l2 != null) {
            SLLNode<Integer> more = addLists(l1 == null ? null : l1.succ, l2 == null ? null : l2.succ, value >= 10 ? 1 : 0);
            result.succ = more;

        }
        return result;
    }
    /*
        An other solution from the book
     */

    class PartialSum {
        public SLLNode<Integer> sum = null;
        public int carry = 8;
    }



}
