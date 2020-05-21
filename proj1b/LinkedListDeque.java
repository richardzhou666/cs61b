public class LinkedListDeque<T> implements Deque<T>{
    private class Node{
        Node prev;
        T item;
        Node next;
        Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
/** Invariant: sentinel is always the previous of the first item, first = sentinel.next
 * last is always sentinel.prev
 * size is always the total number of items */

    private int size;
    private final Node sentinel;

    /* Create an empty list*/
    public LinkedListDeque() {
        sentinel = new Node(null,  null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // Create list
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        addLast(x);
        size = 1;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null,  null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i=0; i < other.size(); i ++) {
            addLast((T) other.get(i));
        }
    }

    @Override
    public void addFirst(T x) {
        Node first = new Node(sentinel, x , sentinel.next);
        // set the back pointer of the second item to first item
        sentinel.next.prev = first;
        // set the forward pointer from sentinel to first item
        sentinel.next = first;
        size += 1;
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    @Override
    public T get(int index){
        int i = 0;
        Node p = sentinel;
        if (index > size - 1) {
            return null;
        }
        while (i <= index) {
            p = p.next;
            i = i+1;
        }
        return p.item;
    }

    // WIP
    public T getRecursive(int index){
        return get(index);
    }

    @Override
    public void addLast(T x) {
        // add value between last of list and sentinel
        Node last = new Node(sentinel.prev, x , sentinel);
        // point forward pointer from second to last to last
        sentinel.prev.next = last;
        // point backward pointer from sentinel to last
        sentinel.prev = last;
        size += 1;
    }

    public T getLast(){
        return sentinel.prev.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst(){
        if (this.isEmpty()) {
            return null;
        }
        T temp = getFirst();
        // head = head.next
        // make the second item as head
        sentinel.next = sentinel.next.next;
        // head.prev = sentinel
        // link the new head to sentinel
        sentinel.next.prev = sentinel;
        size -=1;
        return temp;
    }

    @Override
    public T removeLast(){
        if (this.isEmpty()) {
            return null;
        }
        T temp = getLast();
        // tail = tail.prev
        // make the second last item as tail
        sentinel.prev = sentinel.prev.prev;
        // tail.next = sentinel
        // link the new tail to sentinel
        sentinel.prev.next = sentinel;
        size -=1;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        for (int i =1; i <= size; i++) {
            System.out.print( p.item + " " );
            p = p.next;
        }
    }

    // print the list in reversed order
    public void ReversePrint() {
        Node p = sentinel.prev;
        for (int i =1; i <= size ; i++) {
            System.out.print(p.item + " ");
            p = p.prev;
        }
     }
}

