/*
 * Name: Marcus Hernandez
 * Assignment: Stacks (Assignment #5)
 * COMSC 076
 * Description: Merges two sorted stacks, reverses a stack, and builds a
 *              stack from an array, without modifying the input stacks.
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
        // clone stack of s1
        Stack<Integer> clone1 = s1.clone();
        // clone stack of s2
        Stack<Integer> clone2 = s2.clone();
        // result stack
        Stack<Integer> result = new Stack<>();

        while (!clone1.isEmpty() || !clone2.isEmpty()) {
            // clone1 ran out, so taking from clone2
            if (clone1.isEmpty()) {
                result.push(clone2.pop());
            }
            // clone2 ran out, so taking from clone1
            else if (clone2.isEmpty()) {
                result.push(clone1.pop());
            }
            // both have items, so pushing the larger top onto the result
            else if (clone1.peek() > clone2.peek()) {
                result.push(clone1.pop());
            } else {
                result.push(clone2.pop());
            }
        }
        // result is decreasing from the bottom up, so reversing it to increasing
        return reverse(result);
    }

    /**
     * reverse: Given a stack of Integer objects, create and return a stack
     * with the same objects in reverse order.
     *
     * @param s1 the input stack
     * @return the new stack, with the items in reverse order
     */
    public static Stack<Integer> reverse(Stack<Integer> s1) {
        // cloning s1 so the input is not modified
        Stack<Integer> copy = s1.clone();
        // creating result stack
        Stack<Integer> result = new Stack<>();

        // popping from the copy and push onto the result (until the copy is empty)
        while (!copy.isEmpty()) {
            result.push(copy.pop());
        }

        return result;
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
        // creating new stack named result
        Stack<Integer> result = new Stack<>();

        // iterating through the array's size, then pushing it to the result stack
        for (int i = 0; i < arr.length; i++) {
            result.push(arr[i]);
        }
        return result;
    }

    /**
     * Runs the required merge() test cases and prints the results!
     */
    public static void main(String[] args) {
        // Test 1: equal length, no duplicates
        Stack<Integer> a1 = makeStack(new Integer[] { 1, 3, 5, 7 });
        Stack<Integer> a2 = makeStack(new Integer[] { 2, 4, 6, 8 });

        System.out.println("Test 1: equal length, no duplicates");
        System.out.println("Stack 1: " + a1);
        System.out.println("Stack 2: " + a2);

        System.out.println("Result: " + merge(a1, a2));
        System.out.println("------------------------------------ \n");

        // Test 2: unequal length, no duplicates
        Stack<Integer> b1 = makeStack(new Integer[] { 1, 3, 5, 7 });
        Stack<Integer> b2 = makeStack(new Integer[] { 2, 4, 6, 8, 10 });

        System.out.println("Test 2: unequal length, no duplicates");
        System.out.println("Stack 1: " + b1);
        System.out.println("Stack 2: " + b2);

        System.out.println("Result: " + merge(b1, b2));
        System.out.println("------------------------------------ \n");

        // Test 3, unequal length with shared duplicates
        Stack<Integer> c1 = makeStack(new Integer[] { 3, 5, 7, 19 });
        Stack<Integer> c2 = makeStack(new Integer[] { 1, 7, 11, 11, 15 });

        System.out.println("Test 3: unequal length with shared duplicates");
        System.out.println("Stack 1: " + c1);
        System.out.println("Stack 2: " + c2);

        System.out.println("Result: " + merge(c1, c2));
        System.out.println("------------------------------------ \n");

        // Test 4, one stack with values and one empty stack
        // an empty stack is makeStack(new Integer[] {})
        Stack<Integer> d1 = makeStack(new Integer[] { 3, 5, 7, 19 });
        Stack<Integer> d2 = makeStack(new Integer[] {});

        System.out.println("Test 4: one stack with values and one empty stack");
        System.out.println("Stack 1: " + d1);
        System.out.println("Stack 2: " + d2);

        System.out.println("Result: " + merge(d1, d2));
        System.out.println("------------------------------------ \n");

        // Test 5, after a merge, print s1 and s2 again to show they were not changed
        Stack<Integer> e1 = makeStack(new Integer[] { 1, 3, 5, 7 });
        Stack<Integer> e2 = makeStack(new Integer[] { 2, 4, 6, 8 });

        System.out.println("Test 5: after a merge, print s1 and s2 again to show they were not changed");
        System.out.println("Stack 1: " + e1);
        System.out.println("Stack 2: " + e2);

        System.out.println("Result: " + merge(e1, e2));

        System.out.println("Proof that e1 and e2 were not changed: " + e1 + " | " + e2);
        System.out.println("------------------------------------ \n");

    }
}