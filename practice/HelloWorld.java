import java.util.HashMap;

public class HelloWorld {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);


        HashMap<String,String> map2 = new HashMap<>();
        map2.put("Hello" ,"World");

        System.out.println(map.keySet());
    }
}
