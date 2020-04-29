package arraystack;

import java.util.EmptyStackException;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-26
 * 
 * @param <T>
 *            The type of objects that the stack will hold.
 */
public class ArrayBasedStack<T> implements StackADT<T> {

    private T[] stackArray;
    private int size;
    private int capacity;

    /**
     * 
     * firstconstructor
     * 
     * @param cap
     *        is the capacity
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int cap) {
        this.capacity = cap;
        stackArray = (T[])new Object[capacity];
        size = 0;
    }


    /**
     * 
     * secondconstructor
     */
    public ArrayBasedStack() {
        this(100);
    }


    /**
     * 
     * override
     */
    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * 
     * isempty
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }


    /**
     * 
     * peek
     */
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return stackArray[size - 1];
        }
    }


    /**
     * 
     * pop
     */
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            T lastElement = stackArray[size - 1];
            stackArray[size - 1] = null;
            size--;
            return lastElement;
        }
    }


    /**
     * 
     * push
     */
    @Override
    public void push(T item) {
        if (size == capacity) {
            this.expandCapacity();
        }
        stackArray[size] = item;
        size++;
    }


    /**
     * 
     * contains
     */
    @Override
    public boolean contains(T item) {
        for (T element : stackArray) {
            if (element == item) {
                return true;
            }
        }
        return false;
    }


    /**
     * 
     * size
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * 
     * clear
     */
    @Override
    public void clear() {
        while (!this.isEmpty()) {
            this.pop();
        }

    }

}
