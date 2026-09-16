import java.util.Stack;

public class practice_week4 {
    public static void main(String args[]) {
        System.out.println("HELLO WEEK 4!!!");

        Stack<Integer> s1 = new Stack<>();

        s1.push(10);
        s1.push (20);

        // System.out.println(s1);

        for (int i = 0; i < s1.size(); i += 1) {
            System.out.println(s1.get(i) + " ");
        }
        

    }
}