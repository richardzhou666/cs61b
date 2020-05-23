package synthesizer;

public abstract class AbstractBoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return this.capacity;
    }
    public int fillCount() {
        return this.fillCount;
    }
}
