package GraphsAndTreesBasic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hnastevska on 6/12/2017.
 */
public class TreeNode<T> {
    private T data = null;
    private List<TreeNode> children = new ArrayList<>();
    private TreeNode parent = null;

    public TreeNode(T data) {
        this.data = data;
    }




    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        TreeNode<T> newChild = new TreeNode<>(data);
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChildren(List<TreeNode> children) {
        for (TreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }
}