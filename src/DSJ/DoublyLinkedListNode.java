package DSJ;

public class DoublyLinkedListNode  extends LinkedListNode{
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int n){
        super(n);
        prev = null;
    }
}
