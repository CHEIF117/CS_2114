// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Gunnar Nelson (ngunn15)
package towerofhanoi;

/**
 * @author name Gunnar Nelson
 * @version 2020-03-22
 * 
 * @param <T>
 *        This is our parameter for the data to pass through the methods
 */
public interface StackInterface<T> {
    /**
     * Checks if any disk is pushed at the top of the stack.
     * 
     * @param top
     *        This parameter checks for the top most part of the stack.
     */
    public void push(T top);


    /**
     * Checks if any disk is popped at the top of the stack.
     * @return returns the popped top most part of the stack
     */
    public T pop();


    /**
     * Checks to see the peek of the tower stack.
     * @return the peak of the stack
     * 
     */
    public T peek();


    /**
     * Checks to see if the stack is empty.
     * @return returns true to see if the stack is empty
     * 
     */
    public boolean isEmpty();


    /**
     * Clears the whole stack.
     * 
     */
    public void clear();

}
