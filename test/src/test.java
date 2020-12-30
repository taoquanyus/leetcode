import java.util.*;

public class test {
    public static void main(String[] args) {
        int i=10;
        print(i++);
        i=10;
        print(++i);
        i=10;
        print(i+1);
        i=10;
        print(i+=1);


    }

    private static void print(int i) {
        System.out.println(i);
    }
}
