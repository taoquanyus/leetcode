import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int a=22,b=3;
        String c=Integer.toString(a)+'b'+(b);//一个函数内没有用，或者；隔开，相当于用同一个函数？？
        int[] sum_value=new int[10];
        sum_value[2]=5;
        {
            System.out.println(sum_value[3]);
        }

    }
}
