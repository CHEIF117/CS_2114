// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (905956285)
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * @author name Gunnar Nelson
 * @version 2020-04-15
 *
 *          Here we are setting up our ArrayQueue class
 *          Also implementing the QueueInterface
 *          Then creating our fields with our set capacities
 *
 * @param <T>
 *        This is our type interface for your ArrayQueue class
 */
public class ArrayQueue<T> implements QueueInterface<T> {
    private T[] queue;
    private static final int MAX_CAPACITY = 100;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int enqueueIndex;
    private int dequeueIndex;

    /**
     * Creates new ArrayQueue object.
     */
    public ArrayQueue() {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        this.queue = tempQueue;
        this.size = 0;
        this.enqueueIndex = 0;
        this.dequeueIndex = 0;
    }


    /**
     * Gets length of queue.
     * 
     * @return length of queue.
     */
    public int getLength() {
        return this.queue.length;
    }


    /**
     * Gets the size of the queue
     * 
     * @return number of objects in queue
     */
    public int getSize() {
        return size;
    }


    /**
     * Checks to see if this queue is full.
     * 
     * @return boolean value if queue is full or not.
     */
    public boolean isFull() {
        return size == MAX_CAPACITY;
    }


    /**
     * Clears queue, isn't it obvious ;)
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempQueue = (T[])new Object[DEFAULT_CAPACITY + 1];
        queue = tempQueue;
        enqueueIndex = 0;
        dequeueIndex = 0;
        size = 0;
    }


    /**
     * Converts this queue to array.
     * 
     * @return Array representation of this queue.
     * @throws EmptyQueueException
     *             In the case that queue is empty.
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        int index = dequeueIndex;
        int tempIndex = 0;
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[])new Object[size];

        while (index != enqueueIndex) {
            tempArray[tempIndex] = queue[index];
            tempIndex++;
            index = incrementIndex(index);
        }

        return tempArray;
    }


    /**
     * This method showcases the increment of the index a array.
     * 
     * @return incremented of index
     */
    private int incrementIndex(int index) {
        return ((index + 1) % queue.length);
    }


    /**
     * Gets ride of an element in the queue.
     * 
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T queueFront = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return queueFront;
    }


    /**
     * Adds a new element to the queue.
     * 
     * @param newEntry
     *            New entry added to the queue.
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        queue[enqueueIndex] = newEntry;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    /**
     * Helper method that is used to upgrade the length of the queue when the
     * queue is full.
     * 
     * @throws IllegalStateException
     *             In the case that another element is being added when queue is
     *             full.
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (isFull()) {
            throw new IllegalStateException("MAX CAPACITY is exceeded");
        }
        if (size == getLength() - 1) {
            T[] newQueue = (T[])new Object[size * 2 + 1];
            int tempVar = dequeueIndex;
            int tempIndex = 0;
            while (tempVar != enqueueIndex) {
                newQueue[tempIndex] = queue[tempVar];
                tempIndex++;
                tempVar = incrementIndex(tempVar);
            }

            dequeueIndex = 0;
            enqueueIndex = size;
            queue = newQueue;
        }
    }


    /**
     * Here we are creating a new ArrayQueue in front of the queue.
     * Literally getting the queue in the front
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * This method checks to see if queue is empty.
     * 
     * @return boolean value if queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * This toString method will output our string
     * 
     * @return string output
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        int tempIndex = dequeueIndex;
        do {
            sb.append(queue[tempIndex].toString() + ", ");
            tempIndex = incrementIndex(tempIndex);
        }
        while (tempIndex != enqueueIndex - 1);
        sb.append(queue[enqueueIndex - 1].toString() + "]");
        return sb.toString();

    }


    /**
     * Our Equals method will compare this object to another object.
     * 
     * @param obj
     *            Object to be compared to this.
     * @return whether of not the two objects are equal
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> otherQueue = (ArrayQueue<T>)obj;

            if (size == otherQueue.getSize()) {
                int counter = 0;
                while (counter != size) {
                    T thisElement = queue[(dequeueIndex + counter)
                        % queue.length];
                    T otherQueueElement =
                        otherQueue.queue[(otherQueue.dequeueIndex + counter)
                            % otherQueue.getLength()];
                    if (!thisElement.equals(otherQueueElement)) {
                        return false;
                    }
                    counter++;
                }
                return true;
            }
        }
        return false;
    }

}
