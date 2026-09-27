public class RemoveFromStack {
    public static <T> Stack<T> removeItem(Stack<T> original, T item) {
        Stack<T> copy = original.clone();
        Stack<T> temporary = new Stack<T>();
        Stack<T> result = new Stack<T>();

        while(!copy.isEmpty()) {
            temporary.push(copy.pop());
        }

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


    public static void check(String testname, String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("pass: " + testname);
        } else {
            System.out.println("fail: " + testname + " (expected " + expected + ", got " + actual + ")");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
    }
}

