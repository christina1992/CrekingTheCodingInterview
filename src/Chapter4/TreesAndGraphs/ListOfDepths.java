package Chapter4.TreesAndGraphs;

import GraphsAndTreesBasic.finki_stuff.binarysearchtree.BNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by hnastevska on 6/21/2017.
 */
public class ListOfDepths {

    void createLevelLinkedList(BNode root, ArrayList<LinkedList<BNode>> lists, int level) {
        if (root == null) return; //base case
        LinkedList<BNode> list = null;
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

    ArrayList<LinkedList<BNode>> createLevelLinkedList(BNode root) {
        ArrayList<LinkedList<BNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    ArrayList<LinkedList<BNode>> createLevelLinkedList2(BNode root) {
        ArrayList<LinkedList<BNode>> result = new ArrayList<>();
        LinkedList<BNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current);
            LinkedList<BNode> parents = current = new LinkedList<>();
            for (BNode parent : parents) {
                //visit the children
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;

    }

}
