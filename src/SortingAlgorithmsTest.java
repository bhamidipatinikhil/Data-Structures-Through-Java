import java.util.*;
import java.io.*;
import DSJ.SortingAlgorithms;


public class SortingAlgorithmsTest {
    public static void main(String[] args) {
        Random r = new Random(System.nanoTime());
        int length_of_arr = 10_00_00_000;
        int[] arr = new int[r.nextInt(length_of_arr)];


        
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(arr.length*10);
        }

//        int[] arr = {6, 4, 1};
        SortingAlgorithms sa = new SortingAlgorithms();
//        sa.insertion_sort(arr);
//        sa.bubble_sort(arr);
        sa.quick_sort(arr, 0, arr.length);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter Test Cases:: ");
        int t = s.nextInt();
        while(t-- > 0){
            System.out.print("Enter the key to search:: ");
            int k = s.nextInt();

            int res = sa.iter_binary_search(arr, k);
            //System.out.print(res + ".  ");
            if(res==-1){
                System.out.printf("Unfortunately, the key %d was not found in the array\n", k);
            }
            else{
                System.out.printf("Success! The key was found in the index %d\n", res);
            }
        }
    }
}
