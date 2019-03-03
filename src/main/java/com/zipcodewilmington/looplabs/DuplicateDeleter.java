package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;
    protected int numberOfObjectsinArray;
    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
        numberOfObjectsinArray = array.length;
    }

    abstract public T[] removeDuplicates(int maxNumberOfDuplications);
    abstract public T[] removeDuplicatesExactly(int exactNumberOfDuplications);
}
