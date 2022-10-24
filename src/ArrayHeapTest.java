import DSJ.ArrayHeap;
import java.util.Random;

import java.util.ArrayList;


public class ArrayHeapTest{
    public static void main(String[] args) {
        int[] arr = new int[100];

        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < 100; i++) {
            arr[i] = -1000 + r.nextInt(2001);
        }
        System.out.println("Hello");

        ArrayHeap h1 = new ArrayHeap(arr);

        h1.print_heap();

        ArrayList<Integer> sorted_arr = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            sorted_arr.add(h1.extract_minimum());
        }


        System.out.println(sorted_arr);
    }
}
