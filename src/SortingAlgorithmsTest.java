import java.io.IOException;
import java.util.*;
import java.io.*;
import java.lang.*;
import DSJ.SortingAlgorithms;


public class SortingAlgorithmsTest {
    public static void main(String[] args) throws IOException{
        Random r = new Random(System.nanoTime());
//        System.out.println(System.nanoTime());
        int length_of_arr = 1_00_00_000; //1 Crore Integers
        int range = length_of_arr*10;
//        System.out.println(System.nanoTime());
        int[] arr = new int[length_of_arr];

        FileWriter inp_f = new FileWriter("inp_f.txt");
        FileWriter out_f = new FileWriter("out_f.txt");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(range);
//            inp_f.write(Integer.toString(arr[i]) + " ");
////            System.out.print(arr[i] + " ");
        }
//        inp_f.write("\n");
////        System.out.println("");
//
        SortingAlgorithms sa = new SortingAlgorithms();
//        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];
        int[] arr3 = new int[arr.length];
//        int[] arr4 = new int[arr.length];
//        int[] arr5 = new int[arr.length];
//        int[] arr6 = new int[arr.length];
//        sa.copy_arr(arr1, arr);
        sa.copy_arr(arr2, arr);
        sa.copy_arr(arr3, arr);
//        sa.copy_arr(arr4, arr);
//        sa.copy_arr(arr5, arr);
//        sa.copy_arr(arr6, arr);


        time_the_sorting(arr2, "quick_sort");
//        time_the_sorting(arr1, "insertion_sort");
        time_the_sorting(arr3, "merge_sort");
//        time_the_sorting(arr4, "heap_sort");
//        time_the_sorting(arr5, "bubble_sort");
//        time_the_sorting(arr6, "selection_sort");
        time_the_sorting(arr, "sort");
//        int n = arr.length;
//        for(int i = 0; i < n; i++) {
//            out_f.write(arr[i] + " ");
////            System.out.print(arr[i] + " ");
//        }
//        out_f.write("\n");
////        System.out.println("");


//        binary_search_test(arr);

        inp_f.close();
        out_f.close();
    }

    public static double time_the_sorting(int[] arr, String sorting_method){
        SortingAlgorithms sa = new SortingAlgorithms();

        long st_time = System.nanoTime();
        switch(sorting_method){
            case "merge_sort":
                sa.merge_sort(arr);
                break;
            case "quick_sort":
                sa.quick_sort(arr);
                break;
            case "bubble_sort":
                sa.bubble_sort(arr);
                break;
            case "insertion_sort":
                sa.insertion_sort(arr);
                break;
            case "selection_sort":
                sa.selection_sort(arr);
                break;
            case "heap_sort":
                sa.heap_sort(arr);
                break;
            case "sort":
                Arrays.sort(arr);
                break;
        }
//        sa.insertion_sort(arr);
//        sa.bubble_sort(arr);
//        sa.quick_sort(arr, 0, arr.length);
        long end_time = System.nanoTime();

        double process_time = (end_time - st_time)/Math.pow(10, 9);
        System.out.println(sorting_method + "[Process Execution Time]:: " + process_time);
        return process_time;
    }

    public static void binary_search_test(int[] arr){
        SortingAlgorithms sa = new SortingAlgorithms();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Test Cases:: ");
        int t = s.nextInt();
        while(t-- > 0){
            System.out.print("Enter the key to search:: ");
            int k = s.nextInt();

//            int res = sa.iter_binary_search(arr, k);
            int res = sa.recur_binary_search(arr, k);
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
