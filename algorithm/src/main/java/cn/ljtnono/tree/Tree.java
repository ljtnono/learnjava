package cn.ljtnono.tree;

import java.util.Optional;


public class Tree {

    private TreeNode head;

    public enum Pos {
        LEFT,RIGHT
    }

    public Tree(TreeNode head) {
        head = Optional.ofNullable(head).orElse(new TreeNode());
        this.head = head;
    }

    public void insertNode(TreeNode node, String name, Pos pos) {

        if (node == null) {
            throw new NullPointerException("param node can't be null");
        }

        TreeNode parent = searchNode(head, name);
        if (parent == null) {
            throw new NullPointerException("there isn't a node named = " + name);
        }
        if (pos == Pos.LEFT) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
    }

    public TreeNode searchNode(TreeNode head, String nodeName) {

        if (nodeName == null || nodeName.isEmpty()) {
            throw new IllegalArgumentException("nodeName can't be " + nodeName);
        }
        if (head == null) {
            return null;
        }

        if (head.getData().getName().equals(nodeName)) {
            return head;
        } else {
            if (searchNode(head.getLeft(), nodeName) != null) {
                return searchNode(head.getLeft(), nodeName);
            } else {
                return searchNode(head.getRight(), nodeName);
            }
        }
    }

    public TreeNode leftTree(TreeNode head) {
        if (head == null) {
            throw new NullPointerException("param head can't be null");
        }
        return head.getLeft();
    }

    public TreeNode rightTree(TreeNode head) {
        if (head == null) {
            throw new NullPointerException("param head can't be null");
        }
        return head.getRight();
    }


    public boolean treeIsEmpty(TreeNode head) {
        if (head == null) {
            throw new NullPointerException("param head can't be null");
        }
        return true;
    }

    public int treeDepth(TreeNode head) {
        int depth_left, depth_right;
        if (head == null) {
            return 0;
        } else {
            depth_left = treeDepth(head.getLeft());
            depth_right = treeDepth(head.getRight());
            if (depth_left > depth_right) {
                return depth_left + 1;
            } else {
                return depth_right + 1;
            }
        }
    }


    public void clearTree(TreeNode head) {
        if (head != null) {
            clearTree(head.getLeft());
            clearTree(head.getRight());
            head = null;
        }
    }


    public void treeNodeData(TreeNode head) {
        System.out.println(head);
    }
    
}