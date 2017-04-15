import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        String login1 = "ronaldo";
        String login2 = "romario";
        String login3 = "roberto";

        String password1 = "password1";
        String password2 = "password2";
        String password3 = "password3";

        Map<String, String> hashMap = new HashMap();
        hashMap.put(login1, password1);
        hashMap.put(login2, password2);
        hashMap.put(login3, password3);
        System.out.println("Printing HashMap...");
        System.out.println(hashMap);
        System.out.println();

        System.out.println("Printing HashMap after sorting according to key...");
        hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println();

        System.out.println("Printing TreeMap...");
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put(login1, password1);
        treeMap.put(login2, password2);
        treeMap.put(login3, password3);
        System.out.println(treeMap);
    }
}
