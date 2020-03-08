package assignment3;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackListBased {
    //create object in linked list for stack
    LinkedList<Object> items;

    StackListBased(){
        items = new LinkedList<Object>();
    }
    /**
     * Creates a new Stack
     * createStack() ADT
     * @return a new Stack Based List
     */
    public StackListBased createStack() {
        return new StackListBased();
    }
    /**
     * Removes all items in Stacks
     * popAll() ADT
     * @return all values removed
     */
    public Object popAll() {
        int i = 0;
        int initialSize = items.size();
        Object x = null;
        while (i < initialSize) {
            x = items.pop();
            i++;
        }
        return x;
    }
    /**
     * Gets size of stack
     * getSize() ADT
     * @return size of stack
     */
    public int getSize() {
        return items.size();
    }
    /**
     * Checks if stack is empty
     * isEmpty() ADT
     * @return true if it is empty
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
    /**
     * Pushes param to the top of the stack
     * push() ADT
     * @param e
     */
    public void push(Object e){
        items.push(e);
    }
    /**
     * Removes the object at the top of the stack
     * pop() ADT
     * @return object that was removed from the otp
     */
    public Object pop() {
        if (items.peek() == null) {
            throw new NoSuchElementException();
        }
        return items.pop();
    }
    /**
     * Looks at the object at the top of the stack 
     * peek() ADT
     * @return the object at the top of the stack
     */
    public Object peek() {
        return items.peek();
    }
}