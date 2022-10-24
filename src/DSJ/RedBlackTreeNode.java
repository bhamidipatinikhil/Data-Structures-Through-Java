package DSJ;

public class RedBlackTreeNode{
    public int data;
    //color 1 is red, 0 is black
    public int color;
    public RedBlackTreeNode left;
    public RedBlackTreeNode right;

    public RedBlackTreeNode parent;
    public RedBlackTreeNode(int n, int c){
        data = n;
        color = c;
    }

    public RedBlackTreeNode(){}
}
