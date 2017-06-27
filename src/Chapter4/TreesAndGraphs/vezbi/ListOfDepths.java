package Chapter4.TreesAndGraphs.vezbi;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by hnastevska on 6/25/2017.
 */
public class ListOfDepths {
    public static void main(String[] args) {
        BNode<Character> a, b, c, e;
        BTree<Character> tree = new BTree<>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');
        e = tree.addChild(c, BNode.RIGHT, 'P');
        System.out.println(createLevelLinkedList(tree.root));

    }

    static ArrayList<LinkedList<BNode>> createLevelLinkedList(BNode root) {
        ArrayList<LinkedList<BNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    static void createLevelLinkedList(BNode root, ArrayList<LinkedList<BNode>> lists, int level) {
        if (root == null) return; //base case
        LinkedList<BNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
}
