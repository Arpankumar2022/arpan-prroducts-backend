package mistakes;

public class BoundedTypeExample<T> {

    /**
     * According to Type Erasure  , this code will be complied by compiler
     * but generics Type will be erased at runtime for JVM
     */
    T obj;

    BoundedTypeExample(Integer num){

    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    /**
     *
     *
     * After erasing the above code internally it looks like
     *
     * public class BoundedTypeExample {
     *     Object parameter;
     *
     *     ..setters and getters
     *
     * }
     *
     *
     *
     */
}
