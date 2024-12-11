package mistakes;

public class UnBoundedTypeExample<T extends Number> {

    T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     *
     *
     * After erasing the above code internally it looks like with Upper Bounded Object
     * and provides bytecode.
     *
     * public class BoundedTypeExample {
     *     Number parameter;
     *
     *     ..setters and getters
     *
     * }
     *
     *
     *
     */
}
