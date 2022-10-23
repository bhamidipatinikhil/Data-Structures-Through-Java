package DSJ;

public class LinkedListQueue extends LinkedList{
    public LinkedListQueue(int[] arr){
        super(arr);
    }

    public LinkedListQueue(int n){
        super(n);
    }

    public void enqueue(int n){
        super.add_at_ind(0, n);
    }

    public int dequeue(){
        return super.remove_at_ind(0);
    }

    public boolean is_empty(){
        return super.get_size()==0;
    }



}
