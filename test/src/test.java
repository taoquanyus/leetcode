import java.util.*;

public class test {
    static int c=5;
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        int c=4;
        for(int b:a){
            System.out.println("b");
        }
        System.out.println(c);
        dps();
    }

    private static void dps() {
        System.out.println(c);//为什么这里打印的是5？
    }
}
