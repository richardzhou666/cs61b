public class ArrayDeque {
    private int size;
    private int[] items;
    private int nextLast;
    private int nextFirst;

    public ArrayDeque() {
        items = new int[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public int getLength(){
        return items.length;
    }

    private void resize(int capacity){
        int[] temp = new int[capacity];
        if (update(nextLast -1)> update(nextFirst+1)){
            System.arraycopy(items,update(nextFirst+1),temp,
                    0,update(nextLast)-update(nextFirst+1));
        }
        else {
            System.arraycopy(items, update(nextFirst + 1), temp,
                    0, items.length - update(nextFirst + 1));
            System.arraycopy(items, 0, temp,
                    items.length - update(nextFirst + 1), update(nextLast));
        }
        items = temp;
        nextFirst = items.length-1;
        nextLast = size;
    }

    public void truncate(){
        double ratio = (double) size /items.length;
        if (ratio < 0.25){
            int capacity = (int) Math.ceil(size/0.25);
            resize(capacity);
        }
    }

    private int update(int index){
        if (index <0){
            index =  items.length-1;
        }
        if (index >= items.length){
            index -=items.length;
        }
        return index;
    }

    public void addFirst(int x){
        if (size == items.length) {
            resize(size*2);
        }
        items[nextFirst] =x;
        nextFirst -=1;
        size += 1;
        nextFirst = update(nextFirst);
     }

    public void addLast(int x) {
         if (size == items.length) {
            resize(size*2);
        }
        items[nextLast] =x;
        nextLast +=1;
        size += 1;
        nextLast = update(nextLast);
    }

    public void printDeque(){
        int start = update(nextFirst+1);
        for (int i = 0; i< size;i++){
            start = update(start);
            System.out.print(items[start] + " ");
            start = start +1;
        }
    }

    public int get(int x){
        if (x > size){
            System.out.println("Index Out of Bounds!");
        }
        int index = nextFirst +1 + x;
        index = update(index);
        return items[index];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object removeFirst(){
        if (isEmpty()){
            return null;
        }
        int removed = items[nextFirst+1];
        nextFirst += 1;
        nextFirst = update(nextFirst);
        size -=1;
        return removed;
    }

    public Object removeLast(){
        if (isEmpty()) {
            return null;
        }
        int removed = items[nextLast-1];
        nextLast -= 1;
        nextLast = update(nextLast);
        size -= 1;
        return removed;
    }

//    public static void main(String[] args){
//        ArrayDeque A = new ArrayDeque();
//        System.out.println("The initial length of memory box is "+ A.getLength());
//        A.addFirst(-2);
//        A.addFirst(-1);
//        A.addFirst(0);
//        A.addFirst(1);
//        A.addFirst(2);
//        A.addFirst(3);
//        A.addFirst(4);
//        A.addFirst(5);
//        A.addLast(6);
//        A.addFirst(9);
//        System.out.println(A.removeLast());
//        A.resize(100);
//        System.out.println("The initial length of memory box after adding is "+ A.getLength());
//        A.truncate();
//        A.printDeque();
//        System.out.println("The size is "+ A.size());
//        System.out.println("The length of memory box is " + A.getLength());
//        System.out.println("The seventh item is "+ A.get(6));
//    }
}

