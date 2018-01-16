package com.whu.sun;

import java.util.Stack;

/**
 * Created by Administrator on 2018/1/16.
 */

/*
    * 二叉树(BinaryTree)是n(n>=0)个节点的有限集，它或者是空集(n=0)，或者由一个根节点及两棵互不相交、分别称作这个根的左子树和右子树的二叉树组成
    * 遍历二叉树是指以一定的次序访问二叉树中的每个节点，实质上是把二叉树的节点进行线性排列的过程
    * N(Node)、L(Left Subtree)和R(Right Subtree)分别是根、根的左子树和根的右子树
    * NLR、LNR、LRN分别称为先根遍历、中根遍历和后根遍历
    * */

public class BinaryTree {

    private Node root = null;

    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    //查找
    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
    }

    //插入
    public String insert(int value) {
        String error = null;

        Node node = new Node(value);

        if (root == null) {
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (value < current.value) {
                    parent = current;
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        break;
                    }
                } else if (value > current.value) {
                    parent = current;
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        break;
                    }
                } else {
                    error = "having same value in binary tree";
                }
            }
        }

        return error;
    }

    /*
    * 中序遍历递归操作
    * 1.调用自身来遍历节点的左子树
    * 2.访问这个节点
    * 3.调用自身来遍历节点的右子树
    * */
    public void inOrderTraverse() {
        System.out.println("中序遍历: ");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }

    /*
    * 中序遍历非递归操作
    * 1.对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空
    * 2.若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
    * 3.重复1、2步操作，直到current为空且栈内节点为空
    * */
    public void inOrderByStack() {
        System.out.println("中序非递归遍历：");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    /*
    * 前序遍历：
    * 1.访问这个节点
    * 2.调用自身来遍历节点的左子树
    * 3.调用自身来遍历节点的右子树
    * */
    public void preOrderTraverse() {
        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /*
    * 前序遍历非递归操作
    * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空
    * 2.若左子树为空，栈顶结点出栈，将该节点的右子树置为current
    * 3.重复1、2操作，直到current为空且栈内结点为空
    * */
    public void preOrderByStack() {

    }

    /*
    * 后序遍历
    * 1.调用自身来遍历节点的左子树
    * 2.调用自身来遍历节点的右子树
    * 3.访问这个节点
    * */
    public void postOrderTraverse() {
        System.out.println("后序遍历：");
        postOrderTraverse();
    }

    private void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }

    /*
    * 后序遍历非递归操作
    * 1.对于任意节点current，若该节点不为空则访问该节点后再将节点压栈，并将左子树节点置为current，重复此操作，直到current为空
    * 2.若左子树为空，取栈顶节点的右子树，如果右子树为空或右子树刚访问过，则访问该节点，并将preNode置为该节点
    * 3.重复1、2步操作，直到current为空且栈内节点为空
    * */
    public void postOrderByStack() {

    }

    //获取最小值
    public int getMinValue() {
        Node current = root;
        while (true) {
            if (current.leftChild == null) {
                return current.value;
            }

            current = current.leftChild;
        }
    }

    //删除
    public boolean delete(int value) {
        return false;
    }

    /*
    * 节点类
    * */
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value) {
            this.value = value;
        }

        public void display() {
            System.out.println(this.value + "\t");
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
