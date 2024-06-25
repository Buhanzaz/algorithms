package com.buhanzaz.my_api.kdtrees;

import java.util.stream.IntStream;

public class KDTreeNode {
    int k = 2;
    int[] point;
    KDTreeNode left, right;

    public KDTreeNode() {
        
    }
    public KDTreeNode(int[] array) {
        this.point = array;
        this.left = this.right = null;
    }

    public static void main(String[] args) {
        com.buhanzaz.my_api.kdtrees.KDTreeNode kdTreeKDTreeNode = new com.buhanzaz.my_api.kdtrees.KDTreeNode();

        KDTreeNode root = null;
        int[][] points = {{3, 6}, {17, 15}, {13, 15}, {6, 12}, {9, 1}, {2, 7}, {10, 19}};

        for (int[] point : points) root = kdTreeKDTreeNode.insert(root, point);

        int[] point1 = {10, 19};
        System.out.println(kdTreeKDTreeNode.search(root, point1) ? "Found" : "Not found");

        int[] point2 = { 12, 19 };
        System.out.println(kdTreeKDTreeNode.search(root, point2) ? "Found" : "Not found");
    }

    public KDTreeNode newKDTreeNode(int[] array) {
        return new KDTreeNode(array);
    }

    public KDTreeNode insertRec(KDTreeNode root, int[] point, int depth) {
        if (root == null) return new KDTreeNode(point);

        int cd = depth % k;

        if (point[cd] < root.point[cd]) {
            root.left = insertRec(root.left, point, depth + 1);
        } else {
            root.right = insertRec(root.right, point, depth + 1);
        }

        return root;
    }

    public KDTreeNode insert(KDTreeNode root, int[] point) {
        return insertRec(root, point, 0);
    }

    public boolean arePointsSame(int[] point1, int[] point2) {
        return IntStream.range(0, k).noneMatch(i -> point1[i] != point2[i]);
    }

    public boolean searchRec(KDTreeNode root, int[] point, int depth) {
        if (root == null) return false;
        if (arePointsSame(root.point, point)) return true;

        int cd = depth % k;

        if (point[cd] < root.point[cd]) {
            return searchRec(root.left, point, depth + 1);
        } else {
            return searchRec(root.right, point, depth + 1);
        }
    }

    public boolean search(KDTreeNode root, int[] point) {
        return searchRec(root, point, 0);
    }
}
