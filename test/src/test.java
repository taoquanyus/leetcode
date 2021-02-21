import java.util.*;

public class test {
    public static void main(String[] args) {
        HashMap<int[],Integer> hashMap=new HashMap<>();
        int[] temp=new int[]{1,2};
        hashMap.put(temp,100);
        int[] temp1=new int[]{1,2};
        System.out.println(hashMap.containsKey(temp1));
    }

//    private static void change(String[] a) {
//        a[0]="hello2";
//    }
}
