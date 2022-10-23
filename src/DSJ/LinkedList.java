package DSJ;

public class LinkedList {
    public static LinkedListNode root;
    public static LinkedListNode tail;

    public LinkedList(int[] arr){
        root = new LinkedListNode(arr[0]);
        tail = root;
        for(int i = 1; i < arr.length; i++){
            insert_node_at_end(arr[i]);
        }
    }

    public LinkedList(int n){
        root = new LinkedListNode(n);
        tail = root;
    }

    public static int get_size(){
        int size = 0;
        LinkedListNode curr = root;
        while(curr!=null){
            curr = curr.next;
            size += 1;
        }

        return size;
    }


    private static void insert_in_sandwich(LinkedListNode n1, LinkedListNode n2, int n){
        LinkedListNode tmp = new LinkedListNode(n);

        if(get_size()==0){
            root = tmp;
            tail = root;
        }
        else if(n1==tail && n2==null){
            tail.next = tmp;
            tail = tmp;
        }
        else if(n1==null && n2 == root){
            LinkedListNode mem = root;
            root = tmp;
            tmp.next = mem;
        }
        else{
            n1.next = tmp;
            tmp.next = n2;
        }
    }

    public static LinkedListNode find_prev_node(int n){
        return find_prev_node(root, n);
    }
    public static LinkedListNode find_prev_node(LinkedListNode t_root, int n){

        if(get_size()==0){
            return null;
        }

        if(t_root == root){
            if(root.num==n){
                return null;
            }
        }
        else if(t_root.num==n){
            LinkedListNode curr = root;
            while(curr.next != t_root){
                curr = curr.next;
            }
            return curr;
        }

        LinkedListNode curr = t_root;
        while(curr!=tail && curr.next.num != n){
            curr = curr.next;
        }
        if(curr==tail){
            System.out.printf("The given number %d does not exist in the linked list. ", n);
            return tail;
        }
        else{
            return curr;
        }
    }

    public static void insert_node_after(int n, int p){
        LinkedListNode prever = find_prev_node(n);
        LinkedListNode n1;
        if(prever==tail){
            return;
        }
        else{
            n1 = prever.next;
        }
        LinkedListNode n2 = n1.next;
        insert_in_sandwich(n1, n2, p);
    }

    public static void insert_node_before(int n, int p){

        if(get_size()==0){
            return;
        }

        LinkedListNode n1 = find_prev_node(n);
        LinkedListNode n2;
        if(n1==null){
            n2 = root;
        }
        else{
            n2 = n1.next;
        }
        insert_in_sandwich(n1, n2, p);
    }

    public static void insert_node_at_end(int n){
        insert_in_sandwich(tail, null, n);
    }

    public static void print_list(){
        LinkedListNode curr = root;
        while(curr != null){
            System.out.printf("%d -> ", curr.num);
            curr = curr.next;
        }
        System.out.printf("null\n");
    }

    public static void delete_node(int n){
        if(get_size()==0){
            return;
        }

        LinkedListNode prever = find_prev_node(n);
        safe_deletify(prever);
    }

    private static void safe_deletify(LinkedListNode prever){
        if(prever==null){
            if(root==tail){
                root = null;
                tail = root;
            }
            else{
                root = root.next;
            }
        }
        else{
            LinkedListNode nower = prever.next;
            if(nower==null){
                System.out.println("Node not found. So it cannnot be deleted.");
                return;
            }
            else{
                LinkedListNode afterer = prever.next.next;
                if(afterer==null){
                    tail=prever;
                    tail.next=null;
                }
                else{
                    prever.next = afterer;
                }
            }

        }
    }

    private static LinkedListNode find_prev_node_by_ind(int ind){
        LinkedListNode prever;
        if(ind==0){
            prever=null;
        }
        else{
            int ctr = 0;
            prever = root;
            while(ctr != (ind-1)){
                prever = prever.next;
                ctr++;
            }
        }

        return prever;
    }

    public static int peek(int ind){
        if(ind > (get_size()-1) || ind < 0){
            System.out.println("The Program is not stupid");
            return -30101998;
        }

        LinkedListNode prever = find_prev_node_by_ind(ind);

        return prever.next.num;
    }
    public static int remove_at_ind(int ind){
        if(!index_safety(ind)){
            return -30101998;
        }

        LinkedListNode prever = find_prev_node_by_ind(ind);
        int ans;
        if(ind == 0){
            ans = root.num;
        }
        else{
            ans = prever.next.num;
        }

        safe_deletify(prever);
        return ans;

    }

    public static int find_ind_by_value(){return 0;}

    public static boolean index_safety(int ind){
        return ind <= (get_size() - 1) && ind >= 0;
    }

    public static void add_at_ind(int ind, int val){
        LinkedListNode tmp = new LinkedListNode(val);

        if(get_size()==0 && ind==0){
            root = tail = tmp;
            return;
        }

        if(ind==0){
            LinkedListNode mem = root.next;
            root = tmp;
            root.next = mem;
            return;
        }

        if(ind - get_size()==1){
            tail.next = tmp;
            tail = tmp;
            return;
        }


        if(index_safety(ind)){
            LinkedListNode prever = find_prev_node_by_ind(ind);
            LinkedListNode nower = prever.next;
            prever.next = tmp;
            tmp.next = nower;
            return;
        }

    }


}
