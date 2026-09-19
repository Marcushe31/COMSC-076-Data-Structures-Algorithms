/*
 * Name: Marcus Hernandez
 * Assignment: Stacks 
 * COMSC 076   
 */

public class TestStack {

    /**
     * merge: Given two stacks containing Integer objects in increasing order
     * from the bottom up, create a third stack such that the Integer objects
     * are in increasing order from the bottom up. If an item appears n times
     * in the two given stacks, it will appear n times in the new stack.
     *
     * @param s1 the first stack
     * @param s2 the second stack
     * @return the new stack, with the items from the two given stacks merged
     */
    public static Stack<Integer> merge(Stack<Integer> s1, Stack<Integer> s2) {
        // TODO 1: make copies of s1 and s2 with clone() so the inputs are not modified
        // TODO 2: create the result stack
        // TODO 3: loop while either copy still has items, moving the larger top
        // onto the result (handle the case where one copy runs out first)
        // TODO 4: fix the order of the result so it ends up increasing from bottom to
        // top
        // TODO 5: return the result
        return null; // TODO: replace this stub
    }

    /**
     * reverse: Given a stack of Integer objects, create and return a stack
     * with the same objects in reverse order.
     *
     * @param s1 the input stack
     * @return the new stack, with the items in reverse order
     */
    public static Stack<Integer> reverse(Stack<Integer> s1) {
        // TODO 1: clone s1 so the input is not modified
        // TODO 2: create the result stack
        // TODO 3: pop from the copy and push onto the result until the copy is empty
        // TODO 4: return the result
        return null; // TODO: replace this stub
    }

    /**
     * makeStack: Given an array of Integer objects, create and return a stack
     * with the same objects. The first item in the array will be at the bottom
     * of the stack, the last item at the top.
     *
     * @param arr the Integer array
     * @return the new stack
     */
    public static Stack<Integer> makeStack(Integer[] arr) {
        Stack<Integer> result = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            result.push(arr[i]);
        }
        return result;
    }

    /**
     * Runs the required merge() test cases and prints the results.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // TODO 1: Test 1, equal length, no duplicates
        // build two stacks with makeStack(), print both, call merge(), print result

        // TODO 2: Test 2, unequal length, no duplicates

        // TODO 3: Test 3, unequal length with shared duplicates
        // use 3 5 7 19 and 1 7 11 11 15

        // TODO 4: Test 4, one stack with values and one empty stack
        // an empty stack is makeStack(new Integer[] {})

        // TODO 5: after a merge, print s1 and s2 again to show they were not changed

        // TODO 6: call reverse() on at least one stack and print the result
    }
}