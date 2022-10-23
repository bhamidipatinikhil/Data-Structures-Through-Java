import DSJ.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(new int[]{8, 9, 10, 23, 6,});
        System.out.println(aq.curr_size);
        int lmt = aq.curr_size;
        for(int i = 0; i < lmt-3; i++){
//        int i = 0;
//        while(!aq.is_empty()){
            System.out.print(i + "->");
            aq.print_list();
            aq.dequeue();
//            i++;
        }
        aq.print_list();
        aq.enqueue(56);
        aq.enqueue(59);
        aq.enqueue(90);
        aq.print_list();
    }
}
