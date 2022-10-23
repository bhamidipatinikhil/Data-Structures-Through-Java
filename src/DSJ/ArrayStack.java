package DSJ;

public class ArrayStack{
    private static int max_size = 100;
    public static int curr_size;
    private static int[] arr = new int[max_size];

    public ArrayStack(int[] arr){
        for(int i = 0; i < arr.length; i++){
            this.arr[i] = arr[i];
        }
        curr_size = arr.length;
    }

    public static void push(int n){
        arr[curr_size] = n;
        curr_size++;
    }

    public static boolean is_empty(){
        return curr_size==0;
    }

    public static boolean is_full(){
        return curr_size==max_size;
    }

    public static int pop(){
        curr_size--;
        return arr[curr_size];
    }



}
