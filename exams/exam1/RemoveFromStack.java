/**
 * Big O Notation: this algorithm is O(n)
 * 
 * In a nutshell, every item gets touched a few times, but never NESTED
 * clone() will copy each item one time (which is n), and the first while loop 
 * will pop everything off the copy and onto temporary (so that's another n). 
 * Additionally, the second while loop will pop everything off temporary adn pushes the ones that 
 * im keeping onto result (so that's another n). And as we know, push and pop are both 
 * constant time. 
 * 
 * All that to say, since NONE OF THE LOOPS ARE INSIDE EACH OTHER, I just added them up:
 * n + n + n = 3n, and so if you disregard the constant that leaves with O(n) complexity  
 * 
 */



/**
 *  Takes a stack adn gives back a new one with a certain item removed, WITHOUT MESSING UP THE ORIGINAL. 
 * running the main() will run tests for it
 */
public class RemoveFromStack {

    /**
     * Make a new stack that has everything from the original BESIDES the item 
     * that we want gone. Does not change the original stack
     * @param original the stack we're removing things from 
     * @param item the item to get rid of (can be null)
     * @return a new stack without any copies of item
     */
    public static <T> Stack<T> removeItem(Stack<T> original, T item) {
        // using copy so that i don't touch the original
        Stack<T> copy = original.clone();
        Stack<T> temporary = new Stack<T>();
        Stack<T> result = new Stack<T>();

        // dumps everythign into temporary, while also flipping it upside down
        while (!copy.isEmpty()) {
            temporary.push(copy.pop());
        }

        // deumps it back into result, NOT including the matches (the items that we want removed)
        // note that this flips it back to normal
        while (!temporary.isEmpty()) {
            T current = temporary.pop();

            boolean match;
            if (current == null) {
                match = (item == null);
            } else {
                match = current.equals(item);
            }

            if (!match) {
                result.push(current);
            }
        }
        return result;
    }

    /**
     * Compares what we got to what was expected and prints PASS or FAIL
     *  
     * @param testname what the test is checking
     * @param actual what removeItem actually gave back
     * @param expected what it should have given back
     */
    public static void check(String testname, String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("pass: " + testname);
        } else {
            System.out.println("fail: " + testname + " (expected " + expected + ", got " + actual + ")");
        }
    }

    /**
     * Runs all the tests including ALL POTENTIAL EDGE CASES
     */
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        // remove middle, top, bottom, and removing something that isn't there
        check("remove the MIDDLE", removeItem(stack1, 2).toString(), "bottom ->[1, 3]<- top");
        check("original UNCHANGED", stack1.toString(), "bottom ->[1, 2, 3]<- top");
        check("remove the TOP", removeItem(stack1, 3).toString(), "bottom ->[1, 2]<- top");
        check("remove the BOTTOM", removeItem(stack1, 1).toString(), "bottom ->[2, 3]<- top");
        check("case where item is not found", removeItem(stack1, 9).toString(), "bottom ->[1, 2, 3]<- top");

        // an empty stack shouldn't crash
        Stack<Integer> stack2 = new Stack<Integer>();
        check("empty stack", removeItem(stack2, 5).toString(), "<<empty stack>>");

        // because every item is the same, the resutl should be empty
        Stack<Integer> stack3 = new Stack<Integer>();
        stack3.push(4);
        stack3.push(4);
        stack3.push(4);

        check("ALL MATCH", removeItem(stack3, 4).toString(), "<<empty stack>>");
        check("ALL MATCH, show original unchanged", stack3.toString(), "bottom ->[4, 4, 4]<- top");

        // duplicates all over the stack 
        Stack<Integer> stack4 = new Stack<>();

        stack4.push(1000);
        stack4.push(5);
        stack4.push(1000);
        stack4.push(6);
        stack4.push(1000);
        check("DUPLICATES", removeItem(stack4, 1000).toString(), "bottom ->[5, 6]<- top");
    
        // strings and null edge case
        Stack<String> stack5 = new Stack<>();
        stack5.push("a");
        stack5.push(null);
        stack5.push("b");

        check("remove string", removeItem(stack5, "a").toString(), "bottom ->[null, b]<- top");
        check("remove NULL", removeItem(stack5, null).toString(), "bottom ->[a, b]<- top");
        check("strings, ORIGINAL UNCHANGED", stack5.toString(), "bottom ->[a, null, b]<- top");
    }
}
