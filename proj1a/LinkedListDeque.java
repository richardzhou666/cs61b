public class LinkedListDeque<Type>{
    public class Node{
        Node prev;
        Type item;
        Node next;
        Node(Node p, Type i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
/** Invariant: sentinel is always the previous of the first item, first = sentinel.next
 * last is always sentinel.prev
 * size is always the total number of items */

    private int size;
    final Node sentinel;

    /* Create an empty list*/
    public LinkedListDeque() {
        sentinel = new Node(null,  null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    // Create list
    public LinkedListDeque(Type x) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        addLast(x);
        size = 1;
    }

    public void addFirst(Type x) {
        Node first = new Node(sentinel, x , sentinel.next);
        sentinel.next.prev = first; // set the back pointer of the second item to first item
        sentinel.next = first; // set the forward pointer from sentinel to first item
        size += 1;
    }

    public Type getFirst() {
        return sentinel.next.item;
    }

    public Object get(int index){
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

    public void addLast(Type x) {
        // add value between last of list and sentinel
        Node last = new Node(sentinel.prev, x , sentinel);
        // point forward pointer from second to last to last
        sentinel.prev.next = last;
        // point backward pointer from sentinel to last
        sentinel.prev = last;
        size += 1;
    }

    public Type getLast(){
        return sentinel.prev.item;
    }

    public int size() {
        return size;
    }

    public Object removeFirst(){
        if (this.isEmpty()) {
            return null;
        }
        Type temp = getFirst();
        sentinel.next.prev = sentinel.prev;
        sentinel.next = sentinel.next.next;
        size -=1;
        return temp;
    }

    public Object removeLast(){
        if (this.isEmpty()) {
            return null;
        }
        Type temp = getLast();
        sentinel.prev.next = sentinel.next;
        sentinel.prev = sentinel.prev.prev;
        size -=1;
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printDeque() {
        Node p = sentinel.next;
        for (int i =1; i <= size; i++) {
            System.out.print( p.item + " " );
            p = p.next;
        }
    }

    public void ReversePrint() {
        Node p = sentinel.prev;
        for (int i =1; i <= size ; i++) {
            System.out.print(p.item + " ");
            p = p.prev;
        }
     }
}

