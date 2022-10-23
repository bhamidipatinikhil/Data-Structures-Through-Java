package DSJ;

import java.util.Random;

public class SortingAlgorithms {
    public static int iter_binary_search(int[] arr, int key) {

        int st = 0;
        int end = arr.length;
        int mid = (int)(st + end)/2;

        while(st != end){
            if(key < arr[mid]) {
                end = mid;
                mid = (int)(st+end)/2;
            }
            else if(key > arr[mid]) {
                st = mid + 1;
                mid = (int)(st+end)/2;
            }
            else {
                return mid;
            }
        }

        return -1;

    }

    public static void bubble_sort(int[] arr) {

        for(int i = arr.length-1; i > 0; i--) {

            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

    }

    public static void insertion_sort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            int j = i-1;
            int tmp = arr[i];

            while(j >= 0 && arr[j] > tmp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;

        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quick_sort(int[] arr, int st, int end){
        int n = arr.length;
        Random r = new Random(System.nanoTime());

        int rand_ind = r.nextInt(n);
        swap(arr, rand_ind, n-1);

        int k = partition(arr, st, end);

        quick_sort(arr, st, k);
        quick_sort(arr, k+1, end);
    }

    public static int partition(int[] arr, int st, int end){

    }
}
