package DSJ;

import java.util.Random;

public class SortingAlgorithms {
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubble_sort(int[] arr) {

        for(int i = arr.length-1; i > 0; i--) {

            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
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


    public static void quick_sort(int[] arr){
        quick_sort_helper(arr, 0, arr.length);
    }
    public static void quick_sort_helper(int[] arr, int st, int end){
        if(st>=(end-1)){
            return;
        }

        int n = end - st;
        Random r = new Random(System.nanoTime());
        int rand_ind = r.nextInt(n) + st;
        swap(arr, rand_ind, end-1);

        int k = partition(arr, st, end);
//        System.out.println(k);
//        print_arr(arr);
        quick_sort_helper(arr, st, k);
        quick_sort_helper(arr, k+1, end);
        return;
    }

    public static int partition(int[] arr, int st, int end){
        int pivot_ptr = end-1;

        int i = st-1;

        for(int j = st; j < end-1; j++){
            if(arr[j] <= arr[pivot_ptr]){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, pivot_ptr);

        return i+1;
    }

    public static void merge_sort(int[] arr){
        merge_sort_helper(arr, 0, arr.length);
    }
    public static void merge_sort_helper(int[] arr, int st, int end){
        if(st >=(end-1)){
//            System.out.println(arr[st]);
            return;
        }

        int mid = (int)(st + end)/2;
        merge_sort_helper(arr, st, mid);
        merge_sort_helper(arr, mid, end);
        merge(arr, st, mid, end);
    }

    public static void merge(int[] arr, int st, int mid, int end){
        int inf = (int)Double.POSITIVE_INFINITY;
        int l1 = mid - st;
        int l2 = end-mid;

        int[] arr1 = new int[l1+1];
        int[] arr2 = new int[l2+1];

        for(int i = 0; i < l1; i++){
            arr1[i] = arr[st+i];
//            System.out.print(arr1[i] + " ");
        }
        arr1[l1] = inf;
        for(int i = 0; i < l2; i++){
            arr2[i] = arr[mid+i];
//            System.out.print(arr2[i] + " ");
        }
//        System.out.println("");
        arr2[l2] = inf;

        int n = end-st;
        int j = 0;
        int k = 0;
        for(int i = 0; i < n; i++){
            int min;
            if(arr1[j] < arr2[k]){
                min = arr1[j];
                j++;
            }
            else{
                min = arr2[k];
                k++;
            }
            arr[st+i] = min;
        }

    }

    public static void print_arr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

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

    public static int recur_binary_search(int[] arr, int key){
        return recur_binary_search_helper(arr, key, 0, arr.length);
    }

    public static int recur_binary_search_helper(int[] arr, int key, int st, int end){
        if(st==(end-1)){
            if(arr[st]==key){
                return st;
            }
            else{
                return -1;
            }
        }

        int mid = (int)(st+end)/2;

        if(key < arr[mid]){
            return recur_binary_search_helper(arr, key, st, mid);
        }
        else if(key > arr[mid]){
            return recur_binary_search_helper(arr, key, mid+1, end);
        }
        else{
            return mid;
        }
    }

    public static void selection_sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min_ind = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min_ind]){
                    min_ind = j;
                }
            }
            swap(arr, i, min_ind);
        }
    }

    public static void copy_arr(int[] arr1, int[] arr2){
        for(int i = 0; i < arr2.length; i++){
            arr1[i] = arr2[i];
        }
    }


    public static void heap_sort(int[] arr){
        ArrayHeap h = new ArrayHeap(arr);

//        int[] sorted_arr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = h.extract_minimum();
//            System.out.print(arr[i] + " ");
        }
//        System.out.println("");
    }
}
