import DSJ.ArrayStack;



public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(new int[]{7, 9, 6, 9, 2});
        System.out.println(as.curr_size);

        for(int i = as.curr_size-1; i >= 0; i--){
            System.out.print(as.pop() + ", ");
        }
        System.out.println("");
    }


}
