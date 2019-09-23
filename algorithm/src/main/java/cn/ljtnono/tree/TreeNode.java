package cn.ljtnono.tree;

public class TreeNode {
    private Student data;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode [data=" + data + ", left=" + left + ", parent=" + parent + ", right=" + right + "]";
    }

    

}