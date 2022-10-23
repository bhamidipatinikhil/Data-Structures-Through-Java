import DSJ.LinkedListStack;


public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack lls = new LinkedListStack(new int[]{6, 8, 1, 3, 1});

        while(lls.is_empty()==false){
            System.out.print(lls.pop() + ", ");
        }
        System.out.println("");
    }
}
