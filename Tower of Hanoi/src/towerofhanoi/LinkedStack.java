// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)

package towerofhanoi;

import CS2114.*;

import java.util.*;

import stack.*;

import java.util.EmptyStackException;
import java.math.*;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 *          The LinkedStack class implements a StackInterface and creates the
 *          methods for the stack
 * @param <T>
 *            Generic data type so that the LinkedStack could be used for any
 *            data type.
 */
public class LinkedStack<T> implements StackInterface<T> {

    private int size = 0;

    private Node<T> topNode = null;

    /**
     * This constructor is left blank to allow the other methods to create the
     * LinkedStack
     */
    public LinkedStack() {
        /**
         * This constructor is left blank to allow the other methods to create
         * the
         * LinkedStack
         */
    }


    /**
     * This clear constructor sets size of the Stack to 0, and the topNode null.
     */
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }


    /**
     * The isEmpty method is treated to return a boolean value deciphering if
     * the Linked Stack is
     * empty.
     * 
     * @return Returns the end value if the stack is empty
     *         or not.
     */
    public boolean isEmpty() {
        return (size() == 0);
    }


    /**
     * toString method returns all the data fields, in a string array, within in
     * the Linked Stack
     * 
     * @return Returns a string array with all the elements present in the
     *         the Linked Stack.
     */
    public String toString() {
        super.toString();
        Node<T> temp = this.topNode;
        StringBuilder string = new StringBuilder();
        string.append("[");
        boolean first = true;
        if (!isEmpty()) {

            while (temp != null) {
                if (!first) {
                    string.append(", ");
                }
                else {
                    first = false;
                }
                string.append(temp.data.toString());
                temp = temp.nextNode;
            }
        }
        string.append("]");
        return string.toString();

    }


    /**
     * The peek method returns the data field present at the top of the Linked
     * Stack.
     * 
     * @return Returns the data field present at the top of the Linked Stack.
     */
    @Override
    public T peek() {
        if (this.size <= 0) {
            throw new EmptyStackException();
        }
        return this.topNode.getData();
    }


    /**
     * The pop method removes the data field present at the top of the Linked
     * Stack and
     * returns it.
     * 
     * @return Returns the data field at the top of the the Linked Stack.
     */
    @Override
    public T pop() {

        if (size <= 0) {
            throw new EmptyStackException();
        }

        Node<T> temp = this.topNode;
        this.topNode = temp.getNextNode();
        size--;
        return temp.getData();
    }


    /**
     * The method adds the parameter data field on the top of the Linked Stack.
     * 
     * @param top
     *            The data field passed as the parameter is added to the top of
     *            the Linked Stack.
     */
    @Override
    public void push(T top) {
        Node<T> newNode = new Node<T>(top);
        newNode.setNextNode(topNode);
        this.topNode = newNode;
        size++;
    }


    /**
     * This method returns the side of our linked stack
     * 
     * @return return the size of our stack
     */
    public int size() {
        System.out.println("Returning Size...");
        return this.size;
    }

    /**
     * This private class manages the nodes and its data so that it can be
     * implemented in the form of a LinkedStack.
     *
     * @param <T>
     *            Generic class type so that the class can be used with any data
     *            type.
     */
    private class Node<T> {
        private Node<T> nextNode;
        private T data;

        /**
         * The constructor initializes the nextNode to null and the data for the
         * same Node to be data.
         * 
         * @param anEntry
         *            The data passed by the user to get stored as the data for
         *            the same Node.
         */
        public Node(T anEntry) {
            this(null, anEntry);

        }


        /**
         * The constructor returns the data field of the current Node
         * 
         * @param data
         *            The data passed by the user to get stored as the data for
         *            the same Node.
         * @param nextNode
         *            The nextNode by the user to pass the data through the
         *            parameter.
         */
        public Node(Node<T> nextNode, T data) {
            this.nextNode = nextNode;
            this.data = data;
        }


        /**
         * This method returns the nextNode when called.
         * 
         * @return Returns the next Node.
         */
        public Node<T> getNextNode() {
            return this.nextNode;
        }


        /**
         * Returns the data of the current Node.
         * 
         * @return Returns the data field of the node when called.
         */
        public T getData() {
            return this.data;
        }


        /**
         * This method sets the nextNode of the Node to the parameter passed.
         * 
         * @param newNext
         *            The node's next node will be the parameter passed.
         */
        public void setNextNode(Node<T> newNext) {
            this.nextNode = newNext;
        }

    }

}
