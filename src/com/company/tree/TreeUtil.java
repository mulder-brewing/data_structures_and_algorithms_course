package com.company.tree;

import com.company.tree.model.Tree;

public class TreeUtil {

    public static void binarySearchTree() {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);

        System.out.println("In Order Traverse..");
        tree.traverseInOrder();

        System.out.println("Pre Order Traverse..");
        tree.traversePreOrder();

        System.out.println(tree.get(27));
        System.out.println(tree.get(15));
        System.out.println(tree.get(333));

        System.out.println("Min = " + tree.min());
        System.out.println("Max = " + tree.max());

        System.out.println("Delete 15...");
        tree.delete(15);
        tree.traverseInOrder();

        System.out.println("Delete 27...");
        tree.delete(27);
        tree.traverseInOrder();

    }
}
