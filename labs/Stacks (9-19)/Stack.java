import java.util.ArrayList;
import java.util.NoSuchElementException;

class Stack<T> implements Cloneable {
    
    /*
     * The top of the stack is at the end
     * of the ArrayList.
     */
    private ArrayList<T> items;
    
    /*
     * Create a new stack
     */
    public Stack() {
        this.items = new ArrayList<T>();
    }
    
    /*
     * Returns true if there are no items on the stack;
     * false otherwise.
     */
    public boolean isEmpty() {
        return (this.items.isEmpty());
    }
    
    /*
     * Pushes given item on the top of the stack
     */
    public void push(T item) {
        this.items.add(item);
    }
    
    /*
     * Removes the item on top of the stack and returns it.
     * If the stack is empty, throws an exception.
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size() - 1);
    }
    
    /*
     * Returns the item on top of the stack without removing it.
     * If the stack is empty, throws an exception.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.get(items.size() - 1);
    }
    
    /*
     * Returns the number of items on the stack.
     */
    public int size() {
        return this.items.size();
    }
    
    /*
     * Convert to string as an array from bottom to top
     */
    public String toString() {
        
        if (!this.items.isEmpty()) {
            String arrString = this.items.toString();
            return "bottom ->" + arrString + "<- top";
        } else {
            return "<<empty stack>>";
        }
    }
    
    /*
     * Create a copy of the stack (not merely a 
     * copy of the reference to this stack)
     */
    public Stack<T> clone() {
        Stack<T> result = new Stack<T>();
        for (int i = 0; i < this.items.size(); i++) {
            result.items.add(this.items.get(i));
        }
        return result;
    }
}
