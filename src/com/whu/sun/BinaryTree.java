package com.whu.sun;

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

    }

    //插入
    public String insert(int value) {

    }

    //中序遍历递归操作
    public void inOrderTraverse() {

    }

    //中序遍历非递归操作
    public void inOrderByStack() {

    }

    //前序遍历
    public void preOrderTraverse() {

    }

    //前序遍历非递归操作
    public void preOrderByStack() {

    }

    //后序遍历
    public void postOrderTraverse() {

    }

    //后序遍历非递归操作
    public void postOrderByStack() {

    }

    //获取最小值
    public int getMinValue() {

    }

    //删除
    public boolean delete(int value) {

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
