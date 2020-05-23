package synthesizer;

public abstract class AbstractBoundedQueue{
    protected int fillCount;
    protected int capacity;
    public int capacity() {
        return this.capacity;
    }
    public int fillCount() {
        return this.fillCount;
    }
}
