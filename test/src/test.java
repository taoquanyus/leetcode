import java.util.*;

public class test {
    public static void main(String[] args) {
        int[]matrix=new int[]{1};
        int left=0,right=matrix.length-1;
        int target=2;
        int mid=0;
        while(left<=right){
            mid =left+(right-left)/2;
            if(matrix[mid]<target){
                left= mid +1;
            }
            if(matrix[mid]>target){
                right= mid -1;
            }
        }
        mid=left+(right-left)/2;
        System.out.println(mid);
    }

//    private static void change(String[] a) {
//        a[0]="hello2";
//    }
}
