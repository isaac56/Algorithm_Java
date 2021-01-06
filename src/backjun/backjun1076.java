package backjun;
import java.util.*;

public class backjun1076 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Long> val = new HashMap<>();
        val.put("black", 0L);
        val.put("brown",1L);
        val.put("red",2L);
        val.put("orange", 3L);
        val.put("yellow", 4L);
        val.put("green", 5L);
        val.put("blue", 6L);
        val.put("violet",7L);
        val.put("grey",8L);
        val.put("white",9L);

        System.out.println((val.get(sc.nextLine()) * 10 + val.get(sc.nextLine())) * (long)Math.pow(10, val.get(sc.nextLine())));
        sc.close();
    }
}
