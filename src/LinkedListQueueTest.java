import DSJ.LinkedListQueue;


public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue llq = new LinkedListQueue(new int[] {8, 9, 2, 7});

        while(!llq.is_empty()){
            llq.print_list();
            llq.dequeue();
        }
        llq.print_list();

    }
}
