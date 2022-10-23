package DSJ;

public class ArrayQueue {
    private static int max_size = 100;
    public static int curr_size = 0;

    private static int arr[] = new int[max_size];

    public ArrayQueue(int[] a){
        for(int i = 0; i < a.length; i++){
            arr[max_size-i-1] = a[a.length-i-1];
        }
        curr_size += a.length;
    }

    public static void enqueue(int n){
        arr[max_size-curr_size-1] = n;
        curr_size++;
    }

    public static void print_list(){

        for(int i = max_size-curr_size; i < max_size; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static int dequeue(){
        int ans = arr[max_size-curr_size];
        curr_size--;
        return ans;
    }

    public static boolean is_empty(){
        return (curr_size==0);
    }

    public static boolean is_full(){
        return (curr_size==max_size);
    }
}
