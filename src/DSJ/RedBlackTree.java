package DSJ;

/**
 * @author Nikhil Bhamidipati
 *Note:: This file is not perfect yet, Needs to add more implementations of API of RedBlackTree
 */


import java.lang.Comparable;
import java.util.*;

class RedBlackNode<T extends Comparable<T>>{
    Color color;
    RedBlackNode left_child;
    RedBlackNode right_child;
    RedBlackNode parent;
    T data;

    RedBlackNode(){
        color = Color.BLACK;
    }

}

enum Color {
    RED,
    BLACK
}

public class RedBlackTree<T>{
    RedBlackNode root;
    //Optional<RedBlackNode> common_nil = Optional.ofNullable(null);
    RedBlackNode common_nil = new RedBlackNode();


    public static void right_rotate(RedBlackTree Tree, RedBlackNode x){
        var y = x.parent;
        var p = y.parent;
        var beta = x.right_child;

        if(beta != Tree.common_nil){
            beta.parent = y;
        }

        if(p == Tree.common_nil){
            Tree.root = x;
        }
        else if(y==p.left_child){
            x = p.left_child;
        }
        else if(y == p.right_child){
            x = p.right_child;
        }

        x.parent = p;

        x.right_child = y;
        y.parent = x;

        y.left_child = beta;
    }

    public static void left_rotate(RedBlackTree Tree, RedBlackNode y){
        var x = y.parent;
        var beta = y.left_child;
        var p = x.parent;


        if(beta != Tree.common_nil){
            beta.parent = x;
        }

        if(p==Tree.common_nil){
            Tree.root = y;
        }
        else if(x == p.right_child){
            p.right_child = y;
        }
        else if(x == p.left_child){
            p.left_child = y;
        }

        y.parent = p;

        y.left_child = x;
        x.parent = y;

        x.right_child = beta;
    }


    public static void insert_node(RedBlackTree Tree, RedBlackNode z){
        var prev_x = Tree.common_nil;
        var x = Tree.root;
        int compar_res;

        while(x != Tree.common_nil){
            compar_res = z.data.compareTo(x.data);
            prev_x = x;
            if(compar_res < 0){
                // z less than x
                x = x.left_child;
            }
            else if(compar_res > 0){
                x = x.right_child;
            }
        }

        if(prev_x == Tree.common_nil){
            Tree.root = z;
        }
        else if(compar_res < 0){
            prev_x.left_child = z;
        }
        else if(compar_res > 0){
            prev_x.right_child = z;
        }

        z.parent = prev_x;
        z.left_child = Tree.common_nil;
        z.right_child = Tree.common_nil;
        z.color = Color.RED;

        fix_colors(RedBlackTree Tree, RedBlackNode z);
    }

    public static void fix_colors(RedBlackTree Tree, RedBlackNode z){

        if(z.parent.color == Color.RED){

            var grandparent = z.parent.parent;
            RedBlackNode uncle = (grandparent.left_child == z.parent)
                    ? grandparent.right_child
                    : grandparent.left_child;

            if(uncle.color == Color.RED){
                grandparent.color = Color.RED;
                uncle.color = Color.BLACK;
                z.parent.color = Color.BLACK;
            }
            else{
                if(grandparent.left_child == z.parent){
                    if(z == z.parent.left_child){
                        //Case 1
                        right_rotate(Tree, z.parent);

                    }
                    else{
                        // Case 2
                        left_rotate(Tree, z);
                        right_rotate(Tree, z);

                    }
                }
                else{
                    if(z == z.parent.right_child){
                        //Case 3
                        left_rotate(Tree, z.parent);
                    }
                    else{
                        //Case 4
                        right_rotate(Tree, z);
                        left_rotate(Tree, z);
                    }
                }

                z.color = Color.BLACK;
                z.left_child.color = Color.RED;
                z.right_child.color = Color.RED;
            }
        }

        Tree.root.color = Color.BLACK;
    }
}
