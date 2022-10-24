package DSJ;

import java.util.*;


public class ArrayHeap {
    private int ptr = -1;
    private ArrayList<Integer> heap = new ArrayList<Integer>();


    public ArrayHeap(int[] arr) {
        for(int n: arr){
            insert_into_heap(n);
        }
    }



    public void insert_into_heap(int node) {
        if(ptr==-1) {
            heap.add(node);
            ptr += 1;
        }
        else {
            heap.add(node);
            ptr += 1;

            int local_ptr = ptr;

            int par = (int)((local_ptr-1)/2);

            while(par >= 0 && heap.get(local_ptr).compareTo(heap.get(par)) < 0) {
                int tmp = heap.get(local_ptr);
                heap.set(local_ptr, heap.get(par));
                heap.set(par, tmp);

                local_ptr = par;
                par = (int)((local_ptr-1)/2);
            }
        }
    }

    public int size() {
        return ptr+1;
    }

    public int peek() {
        return heap.get(0);
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public void print_heap() {
        System.out.println(heap);
    }

    public int extract_minimum() {
        int minim = heap.get(0);
        heap.set(0, heap.get(ptr));
        ptr -= 1;

        heapify(0);

        return minim;
    }


    public void heapify(int st) {
        int smallest = st;
        int l = 2*st + 1;
        int r = 2*st + 2;

        if(l <= ptr && heap.get(l) < heap.get(smallest)) {
            smallest = l;
        }

        if(r <= ptr && heap.get(r) < heap.get(smallest)) {
            smallest = r;
        }

        if(smallest != st) {
            int tmp = heap.get(st);
            heap.set(st, heap.get(smallest));
            heap.set(smallest, tmp);

            heapify(smallest);
        }
    }
}


