package DSJ;

public class LinkedListStack extends LinkedList{
    public LinkedListStack(int[] arr){
        super(arr);
    }
    public LinkedListStack(int n){
        super(n);
    }

    public boolean is_empty(){
        return super.get_size()==0;
    }

    public void push(int n){
        super.insert_node_at_end(n);
    }

    public int pop(){
        int last_index = super.get_size()-1;
        int ans = super.peek(last_index);
        super.remove_at_ind(last_index);

        return ans;
    }

}
