package com.whu.sun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/12.
 */
public class Test {

    public static void main(String[] args) {

        //测试Map
        Map<String, String> map = new HashMap<>();
        System.out.println(map == null);
        System.out.println(map.isEmpty());

        //测试二叉树
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        bt.insert(999);

        bt.inOrderTraverse();
        System.out.println("==================================================================================");

        bt.inOrderByStack();

        System.out.println("==================================================================================");

        BinaryTree.Node node = bt.findKey(777);
        node.display();

        BinaryTree.Node root = bt.findKey(52);

        int maxDeath = bt.getMaxDeath(root);
        System.out.println(maxDeath);

        int minDepth = bt.getMinDepth(root);
        System.out.println(minDepth);

        int numOfNode = bt.getNumOfNode(root);
        System.out.println(numOfNode);

        int numOfNoChildNode = bt.getNumOfNoChildNode(root);
        System.out.println(numOfNoChildNode);

        int numOfkLevelNode = bt.getNumOfkLevelNode(root, 4);
        System.out.println(numOfkLevelNode);
    }
}
