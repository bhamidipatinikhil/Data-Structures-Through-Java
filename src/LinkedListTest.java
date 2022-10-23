import java.util.*;
import DSJ.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(new int[]{4,});
        ll.print_list();
        ll.insert_node_at_end(7);
        ll.print_list();
        ll.insert_node_after(7, 5);
        ll.print_list();
        ll.insert_node_before(4, 1);
        ll.print_list();
        ll.delete_node(5);
        ll.delete_node(7);
        ll.delete_node(4);
        ll.print_list();
        ll.delete_node(1);
        ll.print_list();
        ll.insert_node_at_end(6);
        ll.print_list();
        ll.insert_node_before(ll.root.num, 3);
        ll.print_list();
        ll.delete_node(6);
        ll.print_list();
        ll.delete_node(0);
        ll.print_list();
        ll.delete_node(3);
        ll.print_list();
        ll.delete_node(0);
        ll.print_list();
        ll.insert_node_before(0, 2);
        ll.print_list();
        ll.insert_node_at_end(5);
        ll.print_list();
        ll.insert_node_before(5, 1);
        ll.print_list();
        System.out.println(ll.get_size());
        ll.remove_at_ind(0);
        ll.print_list();
        ll.remove_at_ind(0);
        ll.print_list();

    }
}
