package DSJ;

public class AVLTreeNode {
    public int item, height;
    public AVLTreeNode left, right;

   AVLTreeNode(int d) {
        item = d;
        height = 1;
    }
}
