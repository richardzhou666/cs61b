package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private final T[] rb;

    // Nested class
    private class KeyIterator implements Iterator<T> {
        // pointer
        private int ptr;
        private int count = 0;
        // Constructor
        KeyIterator() {
            ptr = first;
        }
        public boolean hasNext() {
            return count != fillCount();
        }
        public T next() {
            T returned = rb[ptr];
            ptr += 1;
            count += 1;
            ptr = update(ptr);
            return returned;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        this.capacity = capacity;
        this.fillCount = 0;
        rb = (T[]) new Object[this.capacity];
    }

    private int update(int index) {
//        if (index <0){
//            index =  this.capacity-1;
//        }
        if (index >= this.capacity) {
            index -= this.capacity;
        }
        return index;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (this.fillCount == this.capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last += 1;
        last = update(last);
        this.fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T returned = rb[first];
        first += 1;
        first = update(first);
        this.fillCount -= 1;
        return returned;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }
}
